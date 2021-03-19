package pe.warrenth.presentation.study.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent
import pe.warrenth.presentation.R
import pe.warrenth.presentation.base.ui.BaseActivity
import pe.warrenth.presentation.databinding.ActivitySplashBinding

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {

    private lateinit var mViewDataBinding :  ActivitySplashBinding

    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun getViewModel(): SplashViewModel {
        return splashViewModel
    }

    override fun setUI(savedInstanceState: Bundle?) {
        if(savedInstanceState == null) {
            splashViewModel.startMainActivity()
        }

        splashViewModel.navigation.observe(this, Observer {
            if(it) {
                val intent = Intent(this@SplashActivity, pe.warrenth.presentation.study.MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
        })
    }
}
