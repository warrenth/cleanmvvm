package pe.warrenth.cleanmvvm.presentation.leftmenu1

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import pe.warrenth.cleanmvvm.R
import pe.warrenth.cleanmvvm.core.extention.gone
import pe.warrenth.cleanmvvm.core.extention.visible
import pe.warrenth.cleanmvvm.core.presentation.ui.BaseFragment
import pe.warrenth.cleanmvvm.core.presentation.ui.BaseItem
import pe.warrenth.cleanmvvm.data.model.ResultData
import pe.warrenth.cleanmvvm.data.model.Status
import pe.warrenth.cleanmvvm.databinding.FragmentLeftmenuBinding
import timber.log.Timber

/**
 * None RxJava. use LiveData
 */
class LeftMenuLiveDataFragment : BaseFragment<FragmentLeftmenuBinding, LeftMenuLiveDataViewModel>() {

    private val leftMenuLiveDataViewModel : LeftMenuLiveDataViewModel by viewModel()

    private lateinit var leftMenuLiveDataAdapter2: LeftMenuLiveDataAdapter

    override fun getLayoutId(): Int {
        return R.layout.fragment_leftmenu
    }

    override fun getViewModel(): LeftMenuLiveDataViewModel {
       return leftMenuLiveDataViewModel
    }

    override fun setUI(savedInstanceState: Bundle?) {
        leftMenuLiveDataAdapter2 = LeftMenuLiveDataAdapter()
        getBinding().recyclerview.layoutManager = LinearLayoutManager(activity)
        getBinding().recyclerview.adapter = leftMenuLiveDataAdapter2
        getBinding().recyclerview.setHasFixedSize(true)
        getBinding().viewModel = leftMenuLiveDataViewModel;
    }

    override fun setViewModel() {
        leftMenuLiveDataViewModel.getData().observe(this, Observer<ResultData<List<BaseItem>>> {
            handleResponse(it)
        })
    }

    private fun handleResponse(resultData: ResultData<List<BaseItem>>) {
        when(resultData.status) {
            Status.LOADING -> {
                Timber.e("Loading data...")
                getBinding().loading.visible()
            }

            Status.SUCCESS -> {
                Timber.e("Fetched data")
                getBinding().loading.gone()
                //TODO 수정필요
                resultData.data?.let { leftMenuLiveDataAdapter2.setItems(it) }
            }

            Status.ERROR -> {
                Timber.e("Error fetching data")
                getBinding().loading.gone()
                getBinding().error.visible()
            }
        }
    }

}