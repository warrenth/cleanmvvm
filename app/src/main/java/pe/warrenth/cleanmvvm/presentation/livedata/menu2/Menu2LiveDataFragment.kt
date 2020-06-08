package pe.warrenth.cleanmvvm.presentation.leftmenu1

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import pe.warrenth.cleanmvvm.BR
import pe.warrenth.cleanmvvm.R
import pe.warrenth.cleanmvvm.databinding.FragmentLeftmenuBinding
import pe.warrenth.cleanmvvm.presentation.livedata.menu2.BaseBindingFragment

/**
 * None RxJava. use LiveData
 *
 * - LiveData Test
 * 1. dabinding(view) --> viewModel
 * 2. viewModel -> Domain(UseCase) -> Repository
 * 3. Repository -> Domain ->  ViewModel -(LiveData+Databinding)-> View
 *
 */
class Menu2LiveDataFragment : BaseBindingFragment<FragmentLeftmenuBinding, Menu2LiveDataViewModel>() {

    private val menu2LiveDataViewModel : Menu2LiveDataViewModel by viewModel()

    private lateinit var menu2LiveDataAdapter2: Menu2LiveDataAdapter

    override fun getLayoutId(): Int {
        return R.layout.fragment_leftmenu_livedata
    }

    override fun getViewModel(): Menu2LiveDataViewModel {
       return menu2LiveDataViewModel
    }

    override fun getBindingVariable(): Int {
       return BR.viewModel
    }

    override fun setUI(savedInstanceState: Bundle?) {
        menu2LiveDataAdapter2 = Menu2LiveDataAdapter()
        with(mBinding) {
            recyclerview.run {
                layoutManager = LinearLayoutManager(activity)
                adapter = menu2LiveDataAdapter2
                setHasFixedSize(true)
            }
        }
    }


}