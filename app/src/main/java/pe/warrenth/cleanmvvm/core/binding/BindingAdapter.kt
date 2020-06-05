package pe.warrenth.cleanmvvm.core.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import pe.warrenth.cleanmvvm.core.presentation.ui.BaseRecyclerAdapter
import pe.warrenth.cleanmvvm.data.model.ResultData

@BindingAdapter("items")
fun <T> bindItems(view: RecyclerView, items: ResultData<T>) {
    val adapter = view.adapter as BaseRecyclerAdapter<T>
    adapter?.run {
        adapter.setItems(items.data)
    }
}