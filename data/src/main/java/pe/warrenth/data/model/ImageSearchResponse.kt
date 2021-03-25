package pe.warrenth.data.model


data class ImageSearchResponse(
    val documents : List<ImageItem>?
)

data class ImageItem(
    val title : String?,
    val contents : String?,
    val thumbnail_url : String?,
    val image_url : String,
    val datetime : String?
)
