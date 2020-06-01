package pe.warrenth.cleanmvvm.core.presentation.ui2

import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseBindingViewHolder<B : ViewDataBinding, ITEM> (v : View) : RecyclerView.ViewHolder(v){

    protected val binding: B = DataBindingUtil.bind(v)!!

    abstract fun binding(item: ITEM)

}