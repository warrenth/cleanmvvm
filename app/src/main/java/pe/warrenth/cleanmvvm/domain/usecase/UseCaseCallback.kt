package pe.warrenth.cleanmvvm.domain.usecase

public interface UseCaseCallback<Response> {

    fun onSuccess(response: Response)

    fun onFailure(response: Response)
}