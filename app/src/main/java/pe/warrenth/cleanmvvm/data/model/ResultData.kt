package pe.warrenth.cleanmvvm.data.model


data class ResultData<R> constructor(
    var status: Status,
    var data: R? = null,
    var message: String? = null
)

enum class Status {
    LOADING,
    SUCCESS,
    ERROR
}