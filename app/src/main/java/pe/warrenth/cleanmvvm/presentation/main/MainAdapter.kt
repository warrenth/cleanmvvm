package pe.warrenth.cleanmvvm.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.warrenth.cleanmvvm.R
import pe.warrenth.cleanmvvm.core.extention.exhaustive
import pe.warrenth.cleanmvvm.core.extention.loadImage
import pe.warrenth.cleanmvvm.core.presentation.ui.BaseItem
import pe.warrenth.cleanmvvm.core.presentation.ui.BaseRecyclerAdapter
import pe.warrenth.cleanmvvm.core.presentation.ui.BaseViewHolder
import pe.warrenth.cleanmvvm.databinding.ItemImageBinding
import pe.warrenth.cleanmvvm.databinding.ItemTextBinding
import pe.warrenth.cleanmvvm.domain.entity.PostEntity
import java.lang.IllegalArgumentException

class MainAdapter<T> : BaseRecyclerAdapter<T>() {

    companion object {
        const val TEXT_TYPE = 0  //const set, getter 없음.
        const val IMAGE_TYPE = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holder : RecyclerView.ViewHolder

        when(viewType) {
            TEXT_TYPE -> holder = TextViewHolder(parent)
            IMAGE_TYPE -> holder = ImageViewHolder(parent)
            else -> throw IllegalArgumentException("Invalid view type")
        }.exhaustive

        return holder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        //TODO 수정필요.
        (holder as Binder<T>).bind(mItems[position])
    }



//    fun setItems(data: List<BaseItem>) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }


    class TextViewHolder : BaseViewHolder<ItemTextBinding>, Binder<PostEntity> {

        constructor(parent : ViewGroup) : super(LayoutInflater.from(parent.context).inflate(R.layout.item_text, parent, false))

        override fun bind(data: PostEntity) {
            with(getBinding()) {
                title.text = post?.title
            }
        }
    }

    class ImageViewHolder : BaseViewHolder<ItemImageBinding>, Binder<PostEntity> {

        constructor(parent : ViewGroup) : super(LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false))

        override fun bind(data: PostEntity) {
            with(getBinding()) {
                image.loadImage(post?.thumbnailUrl)
                title.text = post?.title
            }
        }
    }

}