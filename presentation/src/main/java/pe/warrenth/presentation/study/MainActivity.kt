package pe.warrenth.presentation.study

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent
import pe.warrenth.presentation.R
import pe.warrenth.presentation.base.ui.BaseActivity
import pe.warrenth.presentation.databinding.ActivityMainBinding
import pe.warrenth.presentation.study.main.leftmenu.LeftMenuFragment
import pe.warrenth.presentation.study.main.main.MainFragment
import pe.warrenth.presentation.study.main.main.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    private val mainViewModel : MainViewModel by viewModels()

    interface OnMainCallback {
        fun onLeftBunttonClicked(view: View?)
    }

    override fun getLayoutId(): Int = R.layout.activity_main
    override fun getViewModel(): MainViewModel = mainViewModel

    override fun setUI(savedInstanceState: Bundle?) {
        // Ways to connect listener to databinding
        getViewDataBinding().activity = this
        getViewDataBinding().handler = mainCallback

        supportFragmentManager.beginTransaction().setCustomAnimations(
            R.anim.fragment_enter,
            R.anim.fragment_exit,
            R.anim.fragment_pop_enter,
            R.anim.fragment_pop_exit)
            .add(R.id.layout_root,
                MainFragment()
            ).commit()
    }

    fun onLeftMenuButtonClicked(v : View) {
        goLeftMenu()
    }

    fun onLeftMenu2ButtonClicked(v : View) {
        goLeftMenu2()
    }

    private fun goLeftMenu2() {
        supportFragmentManager.beginTransaction().setCustomAnimations(
            R.anim.fragment_enter,
            R.anim.fragment_exit,
            R.anim.fragment_pop_enter,
            R.anim.fragment_pop_exit)
            .add(R.id.layout_root, LeftMenuFragment())
            .addToBackStack(null).commit()
    }

    private fun goLeftMenu() {
        supportFragmentManager.beginTransaction().setCustomAnimations(
            R.anim.fragment_enter,
            R.anim.fragment_exit,
            R.anim.fragment_pop_enter,
            R.anim.fragment_pop_exit)
            .add(R.id.layout_root, LeftMenuFragment())
            .addToBackStack(null).commit()
    }

    var mainCallback: OnMainCallback = object : OnMainCallback {
        override fun onLeftBunttonClicked(view: View?) {
            goLeftMenu()
        }
    }

}