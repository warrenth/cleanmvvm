package pe.warrenth.cleanmvvm.core.presentation.ui

import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import pe.warrenth.cleanmvvm.data.model.ResultData

abstract class BaseViewHolder<T : ViewDataBinding>(v : View) : RecyclerView.ViewHolder(v)  {

    private var mBinding: T = DataBindingUtil.bind(v)!!

    fun getBinding() = mBinding


}