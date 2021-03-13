package pe.hoondroid.presentation.base.ui

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T : ViewDataBinding>(v : View) : RecyclerView.ViewHolder(v)  {

    private var mBinding: T = DataBindingUtil.bind(v)!!

    fun getBinding() = mBinding


}