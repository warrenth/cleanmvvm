package pe.warrenth.cleanmvvm.data.datasource.rx.local


import io.reactivex.Flowable
import pe.warrenth.cleanmvvm.data.datasource.rx.PostDataSource
import pe.warrenth.cleanmvvm.data.datasource.rx.remote.ApiPostService
import pe.warrenth.cleanmvvm.data.datasource.rx.mapper.PostEntityMapper
import pe.warrenth.cleanmvvm.domain.entity.PostEntity


class PostLocalDataSource (
    private val service: ApiPostService,
    private val mapper: PostEntityMapper
) : PostDataSource {

    override fun getData(): Flowable<List<PostEntity>> {
        return service.getData()
            .toFlowable()
            .map {
                val entitles = mutableListOf<PostEntity>()
                it.forEach { item -> entitles.add(mapper.mapFromRemote(item)) }
                entitles
            }
    }

}