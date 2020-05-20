package pe.warrenth.cleanmvvm

import android.app.Application
import android.content.Context
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

    companion object {
        lateinit var cleanApplication : CleanApplication

        val applicationContext: Context
            get() {
                return cleanApplication.applicationContext
            }
    }

}