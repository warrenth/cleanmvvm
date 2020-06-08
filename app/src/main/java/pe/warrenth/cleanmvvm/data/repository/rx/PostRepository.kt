package pe.warrenth.cleanmvvm.data.repository.rx

import io.reactivex.Flowable
import pe.warrenth.cleanmvvm.data.datasource.rx.PostDataStoreFactory
import pe.warrenth.cleanmvvm.domain.entity.PostEntity
import pe.warrenth.cleanmvvm.domain.repository.IPostRepository


class PostRepository (private val factory: PostDataStoreFactory) : IPostRepository {

    override fun getData(): Flowable<List<PostEntity>> {
        return factory.getLocalDataStore().isCached()
            .flatMap {
                factory.getDataStore(it).getData()
            }

    }
}