package pe.warrenth.presentation.study.recyclerbindingtest.case3

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseBindingViewHolder<ITEM> (v : View) : RecyclerView.ViewHolder(v){

    abstract fun binding(item: ITEM)

}