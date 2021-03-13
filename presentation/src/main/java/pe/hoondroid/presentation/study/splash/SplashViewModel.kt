package pe.hoondroid.presentation.study.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.Observable
import pe.hoondroid.presentation.base.ui.BaseViewModel
import java.util.concurrent.TimeUnit

class SplashViewModel : BaseViewModel() {

    private val _navigation = MutableLiveData<Boolean>()
    var navigation : LiveData<Boolean> = _navigation

    fun startMainActivity() {
        //지정한 시간만큼 지연 후 값 출력
        addCompositeDisposable(Observable.timer(1, TimeUnit.SECONDS)
            .subscribe{
                _navigation.postValue(true)
            })
    }

}