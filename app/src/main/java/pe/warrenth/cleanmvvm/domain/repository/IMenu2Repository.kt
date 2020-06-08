package pe.warrenth.cleanmvvm.domain.repository

import pe.warrenth.cleanmvvm.data.repository.comon.Callback
import pe.warrenth.cleanmvvm.domain.entity.PostEntity
import pe.warrenth.cleanmvvm.domain.usecase.GetMenu2UseCase

interface IMenu2Repository {

    fun getData(request: GetMenu2UseCase.Request?, iList: Callback.IList<List<PostEntity>>)

}