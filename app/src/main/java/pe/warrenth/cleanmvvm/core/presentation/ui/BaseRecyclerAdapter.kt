package pe.warrenth.cleanmvvm.core.presentation.ui


import androidx.recyclerview.widget.RecyclerView
import pe.warrenth.cleanmvvm.core.extention.exhaustive

abstract class BaseRecyclerAdapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder> {

    var mItems: List<T> = emptyList()

    constructor() {
        mItems = emptyList()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //(holder as Binder<T>).bind(mItems[position])
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun getItem(position : Int) : T {
        return mItems[position]
    }

    fun setItems(items: List<T>) {
        this.mItems = items
        notifyDataSetChanged()
    }

    fun setItems(items: T?) {
        this.mItems = items as List<T>
        notifyDataSetChanged()
    }

    internal interface Binder<T> {
        fun bind(data: T)
    }
}