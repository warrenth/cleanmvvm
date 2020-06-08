package pe.warrenth.cleanmvvm.presentation.leftmenu1

import androidx.lifecycle.MutableLiveData
import pe.warrenth.cleanmvvm.core.presentation.ui.BaseItem
import pe.warrenth.cleanmvvm.core.presentation.ui.BaseViewModel
import pe.warrenth.cleanmvvm.data.model.ResultData
import pe.warrenth.cleanmvvm.domain.usecase.GetMenu2UseCase
import pe.warrenth.cleanmvvm.domain.usecase.UseCaseCallback

class Menu2LiveDataViewModel(private val getMenu2UseCase: GetMenu2UseCase) : BaseViewModel() {

    val responseLiveData = MutableLiveData<ResultData<List<BaseItem>>>()

    init {
        loadLeftMenu()
    }

    fun getData() : MutableLiveData<ResultData<List<BaseItem>>> {
        return responseLiveData
    }

    private fun loadLeftMenu() {
        val params = GetMenu2UseCase.Request()
        params.menuId = "aaa"

        getMenu2UseCase.loadData(params, object : UseCaseCallback<List<BaseItem>> {
            override fun onSuccess(response: List<BaseItem>) {

            }

            override fun onFailure(response: List<BaseItem>) {

            }

        })
    }

}