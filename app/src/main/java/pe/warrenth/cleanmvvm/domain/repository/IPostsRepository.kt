package pe.warrenth.cleanmvvm.domain.repository

import io.reactivex.Single
import pe.warrenth.cleanmvvm.data.datasource.entity.Post

interface IPostsRepository {

    fun getPosts(): Single<List<Post>>

}