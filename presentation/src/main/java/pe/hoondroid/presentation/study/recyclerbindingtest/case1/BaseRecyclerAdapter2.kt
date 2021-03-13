package pe.hoondroid.presentation.study.recyclerbindingtest.case1


import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*

abstract class BaseRecyclerAdapter2<T, VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH> {

    var mItems: List<T>

    constructor() {
        mItems = Collections.emptyList()
    }

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    abstract override fun onBindViewHolder(holder: VH, position: Int)

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun getItem(position : Int) : T {
        return mItems[position]
    }

    open fun setItems(items: List<T>) {
        this.mItems = items
        notifyDataSetChanged()
    }

    open fun setItems(items: T?) {
        this.mItems = items as List<T>
        notifyDataSetChanged()
    }

    internal interface Binder<T> {
        fun bind(data: T)
    }
}