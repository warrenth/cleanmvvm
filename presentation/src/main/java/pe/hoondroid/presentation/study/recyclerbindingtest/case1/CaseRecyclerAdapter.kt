package pe.hoondroid.presentation.study.recyclerbindingtest.case1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pe.hoondroid.domain.entity.PostEntity
import pe.hoondroid.presentation.base.ui.BaseItem
import pe.hoondroid.presentation.study.recyclerbindingtest.case3.BaseBindingViewHolder
import pe.hoondroid.presentation.study.recyclerbindingtest.case3.BaseViewHolder2
import java.lang.IllegalArgumentException

class CaseRecyclerAdapter : BaseRecyclerAdapter2<BaseItem, BaseViewHolder2>() {

    companion object {
        const val TEXT_TYPE = 0  //const set, getter 없음.
        const val IMAGE_TYPE = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder2 {
        return when(viewType) {
            TEXT_TYPE -> TextViewHolder2(ItemTextBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            IMAGE_TYPE -> ImageViewHolder2(ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder2, position: Int) {
        when(getItemViewType(position)) {
            TEXT_TYPE, IMAGE_TYPE -> {
                (holder as BaseBindingViewHolder<Any>).binding(mItems[position].objects)  //abstract
                (holder as Binder<Any>).bind(mItems[position].objects)  //interface
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
     *  새로만드는 케이스에서
     *  1. findviewById만 안쓰고 싶은사람. (O) 기존코드 영향없음
     *  2. full binding 쓰고싶은사람
     *  3. binding 을 싫어하는사람.
     */


    /**
     *  (1) abstract 방식
     *     BaseBindingViewHolder에 model을 전달하면 복잡도 증가
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
     * (2) interface 방식
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


    /**
     * (3) lazy를 통한 초기화
     */
    inner class TextViewHolder3(private val view: View) : BaseViewHolder2(view), Binder<PostEntity> {

        private val binding : ItemTextBinding by bindings(
            view
        )

        override fun bind(data: PostEntity) {
            with(binding) {
                title.text = data?.title
            }
        }
    }

    inner class ImageViewHolder3(private val view: View) : BaseViewHolder2(view), Binder<PostEntity> {

        private val binding : ItemImageBinding by bindings(
            view
        )

        override fun bind(data: PostEntity) {
            with(binding) {
                image.loadImage(data?.thumbnailUrl)
                title.text = data?.title
            }
        }
    }

}