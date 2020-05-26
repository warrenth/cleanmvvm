package pe.warrenth.cleanmvvm.presentation.splash

import android.app.Application
import androidx.lifecycle.MutableLiveData
import io.reactivex.Observable
import pe.warrenth.cleanmvvm.core.presentation.ui.BaseViewModel
import java.util.concurrent.TimeUnit

class SplashViewModel : BaseViewModel() {

    val navigationObservable = MutableLiveData<Boolean>()

    fun startMainActivity() {
        addCompositeDisposable(Observable.timer(3, TimeUnit.SECONDS)
            .subscribe{
                navigationObservable.postValue(true)
            })
    }

}