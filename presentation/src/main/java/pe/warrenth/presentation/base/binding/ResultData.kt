package pe.warrenth.presentation.base.binding

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