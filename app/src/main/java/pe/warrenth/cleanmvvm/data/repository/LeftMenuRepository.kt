package pe.warrenth.cleanmvvm.data.repository

import android.preference.PreferenceDataStore
import io.reactivex.Completable
import io.reactivex.Flowable
import pe.warrenth.cleanmvvm.data.datasource.PostDataStoreFactory
import pe.warrenth.cleanmvvm.data.datasource.remote.ApiPostService
import pe.warrenth.cleanmvvm.data.mapper.PostEntityMapper
import pe.warrenth.cleanmvvm.domain.entity.PostEntity
import pe.warrenth.cleanmvvm.domain.repository.ILeftMenuRepository
import pe.warrenth.cleanmvvm.domain.repository.IPostRepository


class LeftMenuRepository (private val factory: PostDataStoreFactory) : ILeftMenuRepository {

    override fun getData(): Flowable<List<PostEntity>> {
        return factory.getLocalDataStore().isCached()
            .flatMap {
                factory.getDataStore(it).getData()
            }

    }
}