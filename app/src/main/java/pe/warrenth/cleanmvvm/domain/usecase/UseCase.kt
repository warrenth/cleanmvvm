package pe.warrenth.cleanmvvm.domain.usecase

import androidx.annotation.WorkerThread

abstract class UseCase<Request, Response> {

    private var callback: UseCaseCallback<Response>? = null
    private var request: Request? = null

    @WorkerThread
    protected abstract fun onExecute()

    open fun getRequest(): Request? {
        return request
    }

    open fun getCallback() : UseCaseCallback<Response>? = callback

    open fun setRequest(request: Request) {
        this.request = request
    }

    open fun setCallback(callback: UseCaseCallback<Response>?) {
        this.callback = callback
    }

    open fun loadData(callback: UseCaseCallback<Response>) {
        setCallback(callback)
    }

    open fun loadData(request: Request, callback: UseCaseCallback<Response>) {
        setRequest(request)
        setCallback(callback)
    }

}