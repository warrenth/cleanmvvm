package pe.warrenth.cleanmvvm.presentation

import android.os.Bundle
import android.view.View
import org.koin.androidx.viewmodel.ext.android.viewModel
import pe.warrenth.cleanmvvm.R
import pe.warrenth.cleanmvvm.core.presentation.ui.BaseActivity
import pe.warrenth.cleanmvvm.databinding.ActivityMainBinding
import pe.warrenth.cleanmvvm.presentation.leftmenu.LeftMenuFragment
import pe.warrenth.cleanmvvm.presentation.main.MainFragment
import pe.warrenth.cleanmvvm.presentation.main.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    private val mainViewModel : MainViewModel by viewModel()

    interface OnMainCallback {
        fun onLeftBunttonClicked(view: View?)
    }

    override fun getLayoutId(): Int = R.layout.activity_main
    override fun getViewModel(): MainViewModel = mainViewModel

    override fun setUI(savedInstanceState: Bundle?) {
        //databinding에 리스너 연결(1)
        getViewDataBinding().activity = this
        //databinding 리스너 연결(2)
        getViewDataBinding().setHandler(mainCallback)

        supportFragmentManager.beginTransaction().setCustomAnimations(
            R.anim.fragment_enter,
            R.anim.fragment_exit,
            R.anim.fragment_pop_enter,
            R.anim.fragment_pop_exit)
            .add(R.id.layout_root,
                MainFragment()
            ).commit();
    }

    fun onLeftMenuButtonClicked(view : View) {
        goLeftMenu()
    }

    private fun goLeftMenu() {
        supportFragmentManager.beginTransaction().setCustomAnimations(
            R.anim.fragment_enter,
            R.anim.fragment_exit,
            R.anim.fragment_pop_enter,
            R.anim.fragment_pop_exit
        )
            .add(
                R.id.layout_root,
                LeftMenuFragment()
            ).addToBackStack(null).commit();
    }

    var mainCallback: OnMainCallback = object : OnMainCallback {
        override fun onLeftBunttonClicked(view: View?) {
            goLeftMenu()
        }
    }



}