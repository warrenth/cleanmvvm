package pe.warrenth.cleanmvvm.domain.usecase

import io.reactivex.Single
import pe.warrenth.cleanmvvm.data.datasource.entity.Post
import pe.warrenth.cleanmvvm.domain.repository.IPostsRepository

class GetPostsUseCase constructor(private val postsRepository: IPostsRepository) {

    fun get():Single<List<Post>> =
        postsRepository.get()
}