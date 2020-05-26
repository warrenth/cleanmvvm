package pe.warrenth.cleanmvvm.domain.entity


data class PostEntity(
    val id: Int,
    val albumId: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)