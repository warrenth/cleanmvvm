package pe.hoondroid.presentation.study.main.main

import android.os.Bundle
import android.security.identity.ResultData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import pe.hoondroid.presentation.base.ui.BaseFragment
import pe.hoondroid.presentation.base.ui.BaseItem

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {

    private val mainViewModel : MainViewModel by viewModel()

    private lateinit var mainAdapter: MainAdapter
    override fun getLayoutId(): Int = R.layout.fragment_main
    override fun getViewModel(): MainViewModel = mainViewModel

    //ktx fragmentmanager 사용.
    override fun setUI(savedInstanceState: Bundle?) {
        mainAdapter = MainAdapter()
        getBinding().recyclerview.layoutManager = LinearLayoutManager(activity)
        getBinding().recyclerview.adapter = mainAdapter
        getBinding().recyclerview.setHasFixedSize(true)
        getBinding().viewModel = mainViewModel;
    }

    override fun setViewModel() {
        mainViewModel.getTest().observe(this, Observer<ResultData<List<BaseItem>>> {
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