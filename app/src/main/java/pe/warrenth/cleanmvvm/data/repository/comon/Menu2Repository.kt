package pe.warrenth.cleanmvvm.data.repository.comon

import pe.warrenth.cleanmvvm.data.datasource.common.Menu2DataSource
import pe.warrenth.cleanmvvm.domain.entity.PostEntity
import pe.warrenth.cleanmvvm.domain.repository.IMenu2Repository
import pe.warrenth.cleanmvvm.domain.usecase.GetMenu2UseCase

/**
 * data cache
 */
class Menu2Repository(private val remoteResource: Menu2DataSource,
                      private val localResource: Menu2DataSource) : IMenu2Repository {

    override fun getData(request: GetMenu2UseCase.Request?, iList: Callback.IList<List<PostEntity>>) {

        remoteResource.getData(request, object : Callback.IList<List<PostEntity>> {
            override fun onListLoaded(value: List<PostEntity>) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }


}