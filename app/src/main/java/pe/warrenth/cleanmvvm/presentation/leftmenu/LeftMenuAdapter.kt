package pe.warrenth.cleanmvvm.presentation.leftmenu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.warrenth.cleanmvvm.core.extention.exhaustive
import pe.warrenth.cleanmvvm.core.extention.loadImage
import pe.warrenth.cleanmvvm.core.presentation.ui.BaseItem
import pe.warrenth.cleanmvvm.core.presentation.ui.BaseRecyclerAdapter
import pe.warrenth.cleanmvvm.core.presentation.ui2.BaseBindingViewHolder
import pe.warrenth.cleanmvvm.core.presentation.ui2.BaseViewHolder2
import pe.warrenth.cleanmvvm.databinding.ItemImageBinding
import pe.warrenth.cleanmvvm.databinding.ItemTextBinding
import pe.warrenth.cleanmvvm.domain.entity.PostEntity
import java.lang.IllegalArgumentException

class LeftMenuAdapter : BaseRecyclerAdapter<BaseItem>() {

    companion object {
        const val TEXT_TYPE = 0  //const set, getter 없음.
        const val IMAGE_TYPE = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holder : RecyclerView.ViewHolder

        when(viewType) {
            TEXT_TYPE -> holder = TextViewHolder(ItemTextBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            IMAGE_TYPE -> holder = ImageViewHolder(ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
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

    inner class TextViewHolder(private val binding: ItemTextBinding) : BaseBindingViewHolder<PostEntity>(binding.root) {

        override fun binding(item: PostEntity) {
            with(binding) {
                title.text = item?.title
            }
        }

    }

    class ImageViewHolder(private val binding: ItemImageBinding) :  BaseBindingViewHolder<PostEntity>(binding.root) {

        override fun binding(item: PostEntity) {
            with(binding) {
                image.loadImage(item?.thumbnailUrl)
                title.text = item?.title
            }
        }
    }


//    inner class TextViewHolder(private val binding: ItemTextBinding) : BaseViewHolder2(binding.root), Binder<PostEntity> {
//
//        override fun bind(data: PostEntity) {
//            with(binding) {
//                title.text = data?.title
//            }
//        }
//
//    }
//
//    inner class ImageViewHolder(private val binding: ItemImageBinding) : BaseViewHolder2(binding.root), Binder<PostEntity> {
//
//        override fun bind(data: PostEntity) {
//            with(binding) {
//                image.loadImage(data?.thumbnailUrl)
//                title.text = data?.title
//            }
//        }
//
//    }

}