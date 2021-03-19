package pe.warrenth.presentation.study.main.main

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import pe.warrenth.presentation.R
import pe.warrenth.presentation.base.binding.ResultData
import pe.warrenth.presentation.base.binding.Status
import pe.warrenth.presentation.base.extention.gone
import pe.warrenth.presentation.base.extention.visible
import pe.warrenth.presentation.base.ui.BaseFragment
import pe.warrenth.presentation.base.ui.BaseItem
import pe.warrenth.presentation.databinding.FragmentMainBinding
import timber.log.Timber

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {

    private val mainViewModel : MainViewModel by viewModels ()

    private lateinit var mainAdapter: MainAdapter
    override fun getLayoutId(): Int = R.layout.fragment_main
    override fun getViewModel(): MainViewModel = mainViewModel


    override fun setupUi(savedInstanceState: Bundle?) {
        mainAdapter = MainAdapter()
        getBinding().recyclerview.layoutManager = LinearLayoutManager(activity)
        getBinding().recyclerview.adapter = mainAdapter
        getBinding().recyclerview.setHasFixedSize(true)
        getBinding().viewModel = mainViewModel;
    }

    override fun subscribeUi() {

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
                resultData.data?.let { mainAdapter.setItems(it) }
            }

            Status.ERROR -> {
                Timber.e("Error fetching data")
                getBinding().loading.gone()
                getBinding().error.visible()
            }
        }
    }

}