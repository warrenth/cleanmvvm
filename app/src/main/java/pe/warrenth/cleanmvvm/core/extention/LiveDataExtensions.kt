package pe.warrenth.cleanmvvm.core.extention

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.shiftweather.core.presentation.Resource
import com.shiftweather.core.presentation.ResourceState


/**
 * LiveData Extensions to load data with its corresponding status
 * */

fun <T> MutableLiveData<Resource<T>>.success(data: T) =
    postValue(
        Resource(
            ResourceState.SUCCESS,
            data
        )
    )

fun <T> MutableLiveData<Resource<T>>.loading() =
    postValue(
        Resource(
            ResourceState.LOADING,
            value?.data
        )
    )

fun <T> MutableLiveData<Resource<T>>.error(message: String? = null) =
    postValue(
        Resource(
            ResourceState.ERROR,
            value?.data,
            message
        )
    )

fun <T, L : LiveData<T>> FragmentActivity.observe(liveData: L, body: (T?) -> Unit) =
    liveData.observe(this, Observer(body))