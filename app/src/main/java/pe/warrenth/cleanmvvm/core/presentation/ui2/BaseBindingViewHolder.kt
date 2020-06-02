package pe.warrenth.cleanmvvm.core.presentation.ui2

import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseBindingViewHolder<ITEM> (v : View) : RecyclerView.ViewHolder(v){

    abstract fun binding(item: ITEM)

}