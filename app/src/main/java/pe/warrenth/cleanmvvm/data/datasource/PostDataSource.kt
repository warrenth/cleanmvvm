package pe.warrenth.cleanmvvm.data.datasource

import io.reactivex.Flowable
import io.reactivex.Single
import pe.warrenth.cleanmvvm.data.model.PostModel
import pe.warrenth.cleanmvvm.domain.entity.PostEntity

interface PostDataSource {

    fun isCached(): Flowable<Boolean> = Flowable.just(false)

    fun getData(): Flowable<List<PostEntity>>
}