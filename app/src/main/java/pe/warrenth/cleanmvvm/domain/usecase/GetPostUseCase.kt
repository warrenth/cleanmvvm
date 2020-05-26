package pe.warrenth.cleanmvvm.domain.usecase

import io.reactivex.Flowable
import pe.warrenth.cleanmvvm.domain.entity.PostEntity
import pe.warrenth.cleanmvvm.domain.repository.IPostRepository

class GetPostUseCase constructor(private val repositories: IPostRepository) {

    fun getData(): Flowable<List<PostEntity>> =
        repositories.getData()
}