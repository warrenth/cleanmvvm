package pe.warrenth.cleanmvvm.data.datasource.local


import io.reactivex.Flowable
import pe.warrenth.cleanmvvm.data.datasource.PostDataSource
import pe.warrenth.cleanmvvm.data.datasource.remote.ApiPostService
import pe.warrenth.cleanmvvm.data.mapper.PostEntityMapper
import pe.warrenth.cleanmvvm.domain.entity.PostEntity
import pe.warrenth.cleanmvvm.domain.repository.IPostRepository


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