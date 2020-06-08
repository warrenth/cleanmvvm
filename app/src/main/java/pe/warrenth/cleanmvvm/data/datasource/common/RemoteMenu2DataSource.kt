package pe.warrenth.cleanmvvm.data.datasource.common

import pe.warrenth.cleanmvvm.data.repository.comon.Callback
import pe.warrenth.cleanmvvm.domain.entity.PostEntity
import pe.warrenth.cleanmvvm.domain.usecase.GetMenu2UseCase

/**
 * network 호출
 */
class RemoteMenu2DataSource : Menu2DataSource {

    override fun getData(request: GetMenu2UseCase.Request?, iList: Callback.IList<List<PostEntity>>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}