package pe.warrenth.cleanmvvm.presentation.main

import android.app.Application
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pe.warrenth.cleanmvvm.core.presentation.ui.BaseViewModel
import pe.warrenth.cleanmvvm.data.datasource.entity.PostsResponse
import pe.warrenth.cleanmvvm.domain.usecase.GetPostsUseCase
import timber.log.Timber

class MainViewModel(application: Application,
                    private val getPostsUseCase: GetPostsUseCase) : BaseViewModel(application) {

    private val responseLiveData = MutableLiveData<PostsResponse>()

    fun getPosts(): MutableLiveData<PostsResponse> {
        return responseLiveData
    }

    fun loadPosts() {
       return addCompositeDisposable(getPostsUseCase.get()
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
    }

}