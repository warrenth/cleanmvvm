package pe.warrenth.sample

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CleanApplication : Application() {

    companion object {
        lateinit var context : CleanApplication
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }

}