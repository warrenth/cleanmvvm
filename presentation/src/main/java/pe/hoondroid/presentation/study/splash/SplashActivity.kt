package pe.hoondroid.presentation.study.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import pe.hoondroid.presentation.R
import pe.hoondroid.presentation.base.ui.BaseActivity
import pe.hoondroid.presentation.databinding.ActivitySplashBinding

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {

    private val splashViewModel: SplashViewModel by viewModels()

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
                val intent = Intent(this@SplashActivity, pe.hoondroid.presentation.study.MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
        })
    }
}
