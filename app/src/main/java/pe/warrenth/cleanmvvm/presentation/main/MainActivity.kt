package pe.warrenth.cleanmvvm.presentation.main

import android.os.Bundle
import org.koin.androidx.viewmodel.ext.android.viewModel
import pe.warrenth.cleanmvvm.R
import pe.warrenth.cleanmvvm.core.presentation.ui.BaseActivity
import pe.warrenth.cleanmvvm.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    private val mainViewModel : MainViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.activity_main
    override fun getViewModel(): MainViewModel = mainViewModel

    override fun setUI(savedInstanceState: Bundle?) {

        supportFragmentManager.beginTransaction().add(R.id.layout_root, MainFragment())
            .commit();
    }

}