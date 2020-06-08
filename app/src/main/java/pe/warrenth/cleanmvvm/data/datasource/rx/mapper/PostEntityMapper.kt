package pe.warrenth.cleanmvvm.data.datasource.rx.mapper

import pe.warrenth.cleanmvvm.data.model.PostModel
import pe.warrenth.cleanmvvm.domain.entity.PostEntity

class PostEntityMapper : EntityRemoteMapper<PostModel, PostEntity> {

    override fun mapFromRemote(type: PostModel): PostEntity {
        return PostEntity(
            id = type.id,
            albumId = type.albumId,
            title = type.title,
            url = type.url,
            thumbnailUrl = type.thumbnailUrl
        )
    }
}