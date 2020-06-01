package pe.warrenth.cleanmvvm.presentation.leftmenu

import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pe.warrenth.cleanmvvm.core.presentation.ui.BaseItem
import pe.warrenth.cleanmvvm.core.presentation.ui.BaseViewHolder
import pe.warrenth.cleanmvvm.core.presentation.ui.BaseViewModel
import pe.warrenth.cleanmvvm.data.model.ResultData
import pe.warrenth.cleanmvvm.data.model.Status
import pe.warrenth.cleanmvvm.domain.usecase.GetLeftMenu
import pe.warrenth.cleanmvvm.presentation.main.MainAdapter
import timber.log.Timber

class LeftMenuViewModel(private val getLeftMenu: GetLeftMenu) : BaseViewModel() {

    val responseLiveData = MutableLiveData<ResultData<List<BaseItem>>>()

    init {
        loadLeftMenu()
    }

    fun getData() : MutableLiveData<ResultData<List<BaseItem>>> {
        return responseLiveData
    }

    private fun loadLeftMenu() {

            addCompositeDisposable(getLeftMenu.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    //TODO 구조 변경 필요
                    responseLiveData.value = ResultData(
                        status = Status.LOADING
                    )
                }
                .subscribe({
                    Timber.e("Fetched data: ${it.size}")

                    val baseItemList : ArrayList<BaseItem> = ArrayList()
                    var baseItem : BaseItem

                    for (i in it.indices) {
                        if(i % 2 == 0) {
                            baseItem = BaseItem(MainAdapter.TEXT_TYPE, it[i])
                        } else  {
                            baseItem = BaseItem(MainAdapter.IMAGE_TYPE, it[i])
                        }
                        baseItemList.add(baseItem)
                    }
                    responseLiveData.value = ResultData(
                        status = Status.SUCCESS,
                        data = baseItemList
                    )
                }, {
                    Timber.e("Error fetching data: ${it.localizedMessage}")
                    //responseLiveData.value = ResultData(
                    //    status = Status.ERROR,
                    //    message = it.localizedMessage
                    //)
                })
            )
    }
}