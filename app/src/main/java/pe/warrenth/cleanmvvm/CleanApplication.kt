package pe.warrenth.cleanmvvm

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CleanApplication : Application() {

    init {
        cleanApplication = this;
    }

    override fun onCreate() {
        super.onCreate()
        //
        startKoin { androidContext(this@CleanApplication) }
    }

    fun hasNetwork(): Boolean {
        return isNetworkAvailable()
    }

    private fun isNetworkAvailable(): Boolean {
        var isConnected = false
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        if (activeNetwork != null && activeNetwork.isConnected)
            isConnected = true
        return isConnected
    }

    companion object {
        lateinit var cleanApplication : CleanApplication

        val applicationContext: Context
            get() {
                return cleanApplication.applicationContext
            }
    }

}