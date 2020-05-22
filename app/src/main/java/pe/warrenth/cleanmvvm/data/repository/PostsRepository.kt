package pe.warrenth.cleanmvvm.data.repository

import io.reactivex.Observable
import io.reactivex.Single
import pe.warrenth.cleanmvvm.data.datasource.PostsDataSource
import pe.warrenth.cleanmvvm.data.datasource.entity.Post
import pe.warrenth.cleanmvvm.domain.repository.IPostsRepository
import timber.log.Timber

class PostsRepository constructor(private val datasource : PostsDataSource) : IPostsRepository {


    fun getPosts(): Single<List<Post>> {
        return Observable.concatArray(
            fetchPostsFromRoom()
                .materialize()
                .filter { !it.isOnError }
                .dematerialize<List<Post>>()
        )
    }


    private fun fetchPostsFromRoom(): Observable<List<Post>> {
        return postsDao.getPosts().filter { it.isNotEmpty() }
            .toObservable()
            .doOnNext {
                Timber.e("Fetched from DB: ${it.size}")
            }
   =
}