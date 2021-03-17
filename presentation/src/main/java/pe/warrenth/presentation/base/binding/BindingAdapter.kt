package pe.warrenth.presentation.base.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import pe.warrenth.presentation.base.ui.BaseRecyclerAdapter

@BindingAdapter("items")
fun <T> bindItems(view: RecyclerView, items: ResultData<T>) {
    val adapter = view.adapter as BaseRecyclerAdapter<T>
    adapter?.run {
        adapter.setItems(items.data)
    }
}