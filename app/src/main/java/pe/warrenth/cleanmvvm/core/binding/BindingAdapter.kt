package pe.warrenth.cleanmvvm.core.binding

import android.widget.BaseAdapter
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import pe.warrenth.cleanmvvm.core.presentation.ui.BaseRecyclerAdapter
import pe.warrenth.cleanmvvm.data.model.ResultData
import pe.warrenth.cleanmvvm.presentation.main.MainAdapter

@BindingAdapter("items")
fun <T> bindItems(view: RecyclerView, items: ResultData<T>) {
    val adapter = view.adapter as BaseRecyclerAdapter<T>
    adapter?.run {
        adapter.setItems(items.data)
    }
}