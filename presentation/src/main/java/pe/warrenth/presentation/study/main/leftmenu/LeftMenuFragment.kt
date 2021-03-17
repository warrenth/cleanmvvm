package pe.warrenth.presentation.study.main.leftmenu

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import pe.warrenth.presentation.R
import pe.warrenth.presentation.base.ui.BaseFragment
import pe.warrenth.presentation.databinding.FragmentLeftmenuBinding

/**
 * RxJava
 */
class LeftMenuFragment : BaseFragment<FragmentLeftmenuBinding, LeftMenuViewModel>() {

    private val leftMenuViewModel : LeftMenuViewModel by viewModels()

    private lateinit var leftMenuAdapter: LeftMenuAdapter

    override fun getLayoutId(): Int {
        return R.layout.fragment_leftmenu
    }

    override fun getViewModel(): LeftMenuViewModel {
       return leftMenuViewModel
    }

    override fun setupUi(savedInstanceState: Bundle?) {
        leftMenuAdapter = LeftMenuAdapter()
        getBinding().recyclerview.layoutManager = LinearLayoutManager(activity)
        getBinding().recyclerview.adapter = leftMenuAdapter
        getBinding().recyclerview.setHasFixedSize(true)
    }

    override fun subscribeUi() {

    }

}