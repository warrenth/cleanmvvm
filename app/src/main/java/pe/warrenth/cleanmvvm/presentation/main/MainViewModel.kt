package pe.warrenth.cleanmvvm.presentation.main

import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pe.warrenth.cleanmvvm.core.extention.error
import pe.warrenth.cleanmvvm.core.extention.loading
import pe.warrenth.cleanmvvm.core.extention.success
import pe.warrenth.cleanmvvm.core.presentation.ui.BaseViewModel
import pe.warrenth.cleanmvvm.data.model.ResultData
import pe.warrenth.cleanmvvm.data.model.Status
import pe.warrenth.cleanmvvm.domain.entity.PostEntity
import pe.warrenth.cleanmvvm.domain.usecase.GetPostUseCase
import timber.log.Timber

class MainViewModel(private val getPostUseCase: GetPostUseCase) : BaseViewModel() {

    private val responseLiveData = MutableLiveData<ResultData<List<PostEntity>>>()

    fun getTest(): MutableLiveData<ResultData<List<PostEntity>>> {
        return responseLiveData
    }

    fun loadPosts() {
       return addCompositeDisposable(getPostUseCase.getData()
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
           .doOnSubscribe {
               responseLiveData.value = ResultData(
                   status = Status.LOADING
               )
           }
           .subscribe({
               Timber.e("Fetched data: ${it.size}")
               responseLiveData.value = ResultData(
                   status = Status.SUCCESS,
                   data = it
               )
           }, {
               Timber.e("Error fetching data: ${it.localizedMessage}")
               responseLiveData.value = ResultData(
                   status = Status.ERROR,
                   message = it.localizedMessage
               )
           })
       )
    }

}