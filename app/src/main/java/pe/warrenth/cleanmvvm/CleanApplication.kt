package pe.warrenth.cleanmvvm

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.multidex.MultiDexApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CleanApplication : MultiDexApplication() {

    companion object {
        lateinit var context : CleanApplication
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        configureDi()
    }

    private fun configureDi() = startKoin {
        // use the Android context given there
        androidContext(this@CleanApplication)
        modules(appModules)
    }

    // test janghak

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



}