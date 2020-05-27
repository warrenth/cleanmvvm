package pe.warrenth.cleanmvvm.presentation.main

import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pe.warrenth.cleanmvvm.core.presentation.ui.BaseViewModel
import pe.warrenth.cleanmvvm.data.model.PostsResponse
import pe.warrenth.cleanmvvm.domain.usecase.GetPostUseCase
import timber.log.Timber

class MainViewModel(private val getPostUseCase: GetPostUseCase) : BaseViewModel() {

    private val responseLiveData = MutableLiveData<PostsResponse>()

    fun getTest(): MutableLiveData<PostsResponse> {
        return responseLiveData
    }

    fun loadPosts() {
       return addCompositeDisposable(getPostUseCase.getData()
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
           .doOnSubscribe { responseLiveData.value = PostsResponse.loading() }
           .subscribe({
               Timber.e("Fetched posts: ${it.size}")
               responseLiveData.value = PostsResponse.success(it)
           }, {
               Timber.e("Error fetching posts: ${it.localizedMessage}")
               responseLiveData.value = PostsResponse.error(it)
           })
       )
        //upstream test
    }

}