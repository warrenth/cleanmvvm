package pe.warrenth.cleanmvvm.data.datasource

import io.reactivex.Single
import pe.warrenth.cleanmvvm.data.datasource.entity.Post

interface PostsDataSource {
    fun get(): Single<Post>
}