package pe.warrenth.presentation.study.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.warrenth.domain.entity.PostEntity
import pe.warrenth.presentation.R
import pe.warrenth.presentation.base.extention.loadImage
import pe.warrenth.presentation.base.ui.BaseItem
import pe.warrenth.presentation.base.ui.BaseRecyclerAdapter
import pe.warrenth.presentation.base.ui.BaseViewHolder
import pe.warrenth.presentation.databinding.ItemImageBinding
import pe.warrenth.presentation.databinding.ItemTextBinding
import java.lang.IllegalArgumentException

class MainAdapter : BaseRecyclerAdapter<BaseItem>() {

    companion object {
        const val TEXT_TYPE = 0  //const set, getter 없음.
        const val IMAGE_TYPE = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when(viewType) {
            TEXT_TYPE -> TextViewHolder(parent)
            IMAGE_TYPE -> ImageViewHolder(parent)
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder:Binder<Any> = (holder as Binder<Any>)

        when(getItemViewType(position)) {
            TEXT_TYPE -> {
                viewHolder.run { bind(mItems[position].objects as PostEntity) }
            }
            IMAGE_TYPE -> {
                viewHolder.run { bind(mItems[position].objects as PostEntity) }
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

    class TextViewHolder : BaseViewHolder<ItemTextBinding>, Binder<PostEntity> {

        constructor(parent : ViewGroup) : super(LayoutInflater.from(parent.context).inflate(R.layout.item_text, parent, false))

        override fun bind(data: PostEntity) {
            with(getBinding()) {
                title.text = data?.title
            }
        }
    }

    class ImageViewHolder : BaseViewHolder<ItemImageBinding>, Binder<PostEntity> {

        constructor(parent : ViewGroup) : super(LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false))

        override fun bind(data: PostEntity) {
            with(getBinding()) {
                image.loadImage(data?.thumbnailUrl)
                title.text = data?.title
            }
        }
    }


}