package pe.warrenth.cleanmvvm.presentation.splash

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel
import pe.warrenth.cleanmvvm.R
import pe.warrenth.cleanmvvm.databinding.ActivitySplashBinding
import pe.warrenth.cleanmvvm.core.presentation.ui.BaseActivity
import pe.warrenth.cleanmvvm.presentation.main.MainActivity

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {

    private val splashViewModel: SplashViewModel by viewModel()

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun getViewModel(): SplashViewModel {
        return splashViewModel
    }

    override fun setUp(savedInstanceState: Bundle?) {
        if(savedInstanceState == null) {
            splashViewModel.startMainActivity()
        }

        splashViewModel.navigationObservable.observe(this, Observer {
            if(it) {
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
        })
    }


}
