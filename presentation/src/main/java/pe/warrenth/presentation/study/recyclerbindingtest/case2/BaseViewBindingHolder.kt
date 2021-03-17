package pe.warrenth.presentation.study.recyclerbindingtest.case2

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.databinding.library.baseAdapters.BR

open class BaseViewBindingHolder<VB : ViewDataBinding>(view: View) : RecyclerView.ViewHolder(view) {

    val binding by lazy {
            requireNotNull(DataBindingUtil.bind<VB>(view)) { "cannot find the matched view to layout." }
        }

    fun bindData(data: Any) {
        //binding?.setVariable(BR.item, data)
        //binding?.setVariable(BR.holder, this)
        
        binding?.executePendingBindings() //bind 즉시 실행
    }
}