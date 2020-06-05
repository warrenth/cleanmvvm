package pe.warrenth.cleanmvvm.presentation.recyclertest.case2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import pe.warrenth.cleanmvvm.R
import pe.warrenth.cleanmvvm.core.extention.exhaustive
import pe.warrenth.cleanmvvm.core.extention.loadImage
import pe.warrenth.cleanmvvm.core.presentation.ui.BaseItem
import pe.warrenth.cleanmvvm.core.presentation.ui.BaseRecyclerAdapter
import pe.warrenth.cleanmvvm.core.presentation.ui2.BaseBindingViewHolder
import pe.warrenth.cleanmvvm.databinding.BrItemTextBinding
import pe.warrenth.cleanmvvm.databinding.ItemImageBinding
import pe.warrenth.cleanmvvm.domain.entity.PostEntity
import java.lang.IllegalArgumentException


/**
 * binding lazy 를 쓰는 방식
 *
 * 1.
 *
 */
class RecyclerCase2Adapter : BaseRecyclerAdapter<BaseItem>() {

    companion object {
        const val TEXT_TYPE = 0  //const set, getter 없음.
        const val IMAGE_TYPE = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holder : RecyclerView.ViewHolder

        when(viewType) {
            TEXT_TYPE -> holder = TextBindingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_text, parent, false))
            IMAGE_TYPE -> holder = ImageBindingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false))
            else -> throw IllegalArgumentException("Invalid view type")
        }.exhaustive

        return holder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val viewHolder : BaseBindingViewHolder<Any> = holder as BaseBindingViewHolder<Any>

        //TODO binding 수정 필요.
        when(getItemViewType(position)) {
            TEXT_TYPE -> {
                viewHolder.binding(mItems[position].objects)
            }
            IMAGE_TYPE -> {
                viewHolder.binding(mItems[position].objects)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }.exhaustive
    }

    override fun getItemViewType(position: Int): Int {
        return mItems[position].viewType
    }

    override fun getItemCount(): Int {
        return super.getItemCount()
    }

    override fun setItems(items: List<BaseItem>) {
        super.setItems(items)
        notifyDataSetChanged()
    }

    override fun setItems(items: BaseItem?) {
        super.setItems(items)
    }


    inner class TextBindingViewHolder(private val view: View) : BaseViewBindingHolder<BrItemTextBinding>(view), Binder<PostEntity> {

        override fun bind(data: PostEntity) {
            with(binding) {
                title.text = data?.title
            }
        }
        fun onClick(item : PostEntity) {
            Toast.makeText(binding.root.context, "item="+item.title, Toast.LENGTH_SHORT).show()
        }
    }

    inner class ImageBindingViewHolder(private val view: View) : BaseViewBindingHolder<ItemImageBinding>(view), Binder<PostEntity> {

        override fun bind(data: PostEntity) {
            with(binding) {
                image.loadImage(data?.thumbnailUrl)
                title.text = data?.title
            }
        }
        fun onClick(item : PostEntity) {
            Toast.makeText(binding.root.context, "item="+item.title, Toast.LENGTH_SHORT).show()
        }

    }

}