package pe.hoondroid.presentation.base.ui


import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder> {

    var mItems: List<T> = emptyList()

    constructor() {
        mItems = emptyList()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as Binder<T>).bind(getItem(position))
    }

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