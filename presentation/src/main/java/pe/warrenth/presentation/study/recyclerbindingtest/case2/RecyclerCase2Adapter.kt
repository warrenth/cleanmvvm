package pe.warrenth.presentation.study.recyclerbindingtest.case2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import pe.warrenth.domain.entity.PostEntity
import pe.warrenth.presentation.R
import pe.warrenth.presentation.base.extention.loadImage
import pe.warrenth.presentation.base.ui.BaseItem
import pe.warrenth.presentation.base.ui.BaseRecyclerAdapter
import pe.warrenth.presentation.study.recyclerbindingtest.case3.BaseBindingViewHolder
import pe.warrenth.presentation.databinding.BrItemTextBinding
import pe.warrenth.presentation.databinding.ItemImageBinding
import java.lang.IllegalArgumentException


/**
 * binding lazy 를 쓰는 방식
 *
 */
class RecyclerCase2Adapter : BaseRecyclerAdapter<BaseItem>() {

    companion object {
        const val TEXT_TYPE = 0  //const set, getter 없음.
        const val IMAGE_TYPE = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            TEXT_TYPE -> TextBindingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_text, parent, false))
            IMAGE_TYPE -> ImageBindingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false))
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder : BaseBindingViewHolder<Any> = holder as BaseBindingViewHolder<Any>

        when(getItemViewType(position)) {
            TEXT_TYPE -> {
                viewHolder.binding(mItems[position].objects)
            }
            IMAGE_TYPE -> {
                viewHolder.binding(mItems[position].objects)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
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