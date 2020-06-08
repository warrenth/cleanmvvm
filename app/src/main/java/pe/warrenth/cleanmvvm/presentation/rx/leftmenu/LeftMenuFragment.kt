package pe.warrenth.cleanmvvm.presentation.rx.leftmenu

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
import pe.warrenth.cleanmvvm.presentation.leftmenu1.Menu2LiveDataAdapter
import pe.warrenth.cleanmvvm.presentation.leftmenu1.Menu2LiveDataViewModel
import timber.log.Timber

/**
 * RxJava
 */
class LeftMenuFragment : BaseFragment<FragmentLeftmenuBinding, Menu2LiveDataViewModel>() {

    private val leftMenuViewModel : Menu2LiveDataViewModel by viewModel()

    private lateinit var leftMenuAdapter: Menu2LiveDataAdapter

    override fun getLayoutId(): Int {
        return R.layout.fragment_leftmenu
    }

    override fun getViewModel(): Menu2LiveDataViewModel {
       return leftMenuViewModel
    }

    override fun setUI(savedInstanceState: Bundle?) {
        leftMenuAdapter =
            Menu2LiveDataAdapter()
        getBinding().recyclerview.layoutManager = LinearLayoutManager(activity)
        getBinding().recyclerview.adapter = leftMenuAdapter
        getBinding().recyclerview.setHasFixedSize(true)
        getBinding().viewModel = leftMenuViewModel;
    }

    override fun setViewModel() {
        leftMenuViewModel.getData().observe(this, Observer<ResultData<List<BaseItem>>> {
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
                resultData.data?.let { leftMenuAdapter.setItems(it) }
            }

            Status.ERROR -> {
                Timber.e("Error fetching data")
                getBinding().loading.gone()
                getBinding().error.visible()
            }
        }
    }

}