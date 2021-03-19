package pe.warrenth

import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CleanApplication : MultiDexApplication() {

    companion object {
        lateinit var context : CleanApplication
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }

}