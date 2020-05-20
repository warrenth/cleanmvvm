package pe.warrenth.cleanmvvm.presentation.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.androidx.viewmodel.ext.android.viewModel
import pe.warrenth.cleanmvvm.R
import pe.warrenth.cleanmvvm.databinding.ActivityMainBinding
import pe.warrenth.cleanmvvm.presentation.BaseActivity

class SplashActivity : BaseActivity<ActivityMainBinding, SplashViewModel>() {

    private val splashViewModel: SplashViewModel by viewModel()

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getViewModel(): SplashViewModel {
        return splashViewModel
    }

    override fun setUp(savedInstanceState: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
