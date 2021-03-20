package pe.warrenth.presentation.study.menulist.livedata

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import pe.warrenth.presentation.R
import pe.warrenth.presentation.base.ui.BaseFragment
import pe.warrenth.presentation.databinding.FragmentLeftmenuBinding

/**
 * RxJava
 */
class LiveDataSampleFragment : BaseFragment<FragmentLeftmenuBinding, FlowSampleViewModel>() {

    private val liveDataSampleViewModel : FlowSampleViewModel by viewModels()

    private lateinit var flowSampleAdapter: FlowSampleAdapter

    override fun getLayoutId(): Int {
        return R.layout.fragment_leftmenu
    }

    override fun getViewModel(): FlowSampleViewModel {
       return liveDataSampleViewModel
    }

    override fun setupUi(savedInstanceState: Bundle?) {
        flowSampleAdapter = FlowSampleAdapter()
        getBinding().recyclerview.layoutManager = LinearLayoutManager(activity)
        getBinding().recyclerview.adapter = flowSampleAdapter
        getBinding().recyclerview.setHasFixedSize(true)
    }

    override fun subscribeUi() {

    }

}