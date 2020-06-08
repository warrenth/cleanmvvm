package pe.warrenth.cleanmvvm.domain.usecase

import pe.warrenth.cleanmvvm.core.presentation.ui.BaseItem
import pe.warrenth.cleanmvvm.data.repository.comon.Callback
import pe.warrenth.cleanmvvm.domain.entity.PostEntity
import pe.warrenth.cleanmvvm.domain.repository.IMenu2Repository

/**
 * BaseItem 을 만든다.
 */
class GetMenu2UseCase constructor(private val repositories: IMenu2Repository) :
    UseCase<GetMenu2UseCase.Request, List<BaseItem>>() {


    override fun onExecute() {
        repositories.getData(getRequest(), object : Callback.IList<List<PostEntity>> {
            override fun onListLoaded(value: List<PostEntity>) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                //getCallback().onSuccess(null)
            }

        })
    }


    class Request {
        var menuId :String = ""
    }
}