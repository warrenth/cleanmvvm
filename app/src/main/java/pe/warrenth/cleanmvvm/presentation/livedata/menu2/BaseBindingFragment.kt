package pe.warrenth.cleanmvvm.presentation.livedata.menu2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import pe.warrenth.cleanmvvm.core.presentation.ui.BaseViewModel

/**
 * setVariable 사용
 */
abstract class BaseBindingFragment<VB : ViewDataBinding, VM : BaseViewModel> : Fragment() {

    protected lateinit var mBinding: VB
    protected lateinit var mViewModel: VM

    abstract fun getLayoutId(): Int
    abstract fun getViewModel(): VM
    abstract fun getBindingVariable() : Int
    abstract fun setUI(savedInstanceState: Bundle?)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(
            inflater, getLayoutId(), container, false)
        setUI(savedInstanceState)
        performDataBinding()
        return mBinding.root
    }

    private fun performDataBinding() {
        mBinding.lifecycleOwner = this
        mBinding.setVariable(getBindingVariable(), getViewModel())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun getBinding(): VB {
        return mBinding;
    }
}