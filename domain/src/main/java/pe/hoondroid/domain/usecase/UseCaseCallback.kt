package pe.hoondroid.domain.usecase

public interface UseCaseCallback<Response> {

    fun onSuccess(response: Response)

    fun onFailure(response: Response)
}