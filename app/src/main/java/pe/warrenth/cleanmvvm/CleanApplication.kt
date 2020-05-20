package pe.warrenth.cleanmvvm

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CleanApplication : Application() {

    init {

    }

    override fun onCreate() {
        super.onCreate()
        //
        startKoin { androidContext(this@CleanApplication) }
    }
}