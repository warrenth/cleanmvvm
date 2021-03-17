package pe.warrenth

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

class CleanApplication : Application() {

    companion object {
        lateinit var context : CleanApplication
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }

}