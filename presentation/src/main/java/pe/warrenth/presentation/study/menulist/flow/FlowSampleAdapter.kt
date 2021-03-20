package pe.warrenth.presentation.study.menulist.livedata

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.warrenth.domain.entity.PostEntity
import pe.warrenth.presentation.base.extention.loadImage
import pe.warrenth.presentation.base.ui.BaseItem
import pe.warrenth.presentation.base.ui.BaseRecyclerAdapter
import pe.warrenth.presentation.study.recyclerbindingtest.case3.BaseBindingViewHolder
import pe.warrenth.presentation.study.recyclerbindingtest.case3.BaseViewHolder2
import pe.warrenth.presentation.databinding.ItemImageBinding
import pe.warrenth.presentation.databinding.ItemTextBinding
import java.lang.IllegalArgumentException

class FlowSampleAdapter : BaseRecyclerAdapter<BaseItem>() {

    companion object {
        const val TEXT_TYPE = 0
        const val IMAGE_TYPE = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            TEXT_TYPE -> TextViewHolder(ItemTextBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            IMAGE_TYPE -> ImageViewHolder(
                ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val viewHolder : BaseBindingViewHolder<Any> = holder as BaseBindingViewHolder<Any>

        when(getItemViewType(position)) {
            TEXT_TYPE, IMAGE_TYPE -> {
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

    /**
     *  abstract 방식
     */
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

    /**
     * interface 방식
     */
    inner class TextViewHolder2(private val binding: ItemTextBinding) : BaseViewHolder2(binding.root), Binder<PostEntity> {

        override fun bind(data: PostEntity) {
            with(binding) {
                title.text = data?.title
            }
        }

    }

    inner class ImageViewHolder2(private val binding: ItemImageBinding) : BaseViewHolder2(binding.root), Binder<PostEntity> {

        override fun bind(data: PostEntity) {
            with(binding) {
                image.loadImage(data?.thumbnailUrl)
                title.text = data?.title
            }
        }
    }

}