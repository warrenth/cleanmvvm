package pe.warrenth.cleanmvvm.core.di

import android.app.Application
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pe.warrenth.cleanmvvm.CleanApplication
import pe.warrenth.cleanmvvm.presentation.main.MainViewModel
import pe.warrenth.cleanmvvm.presentation.splash.SplashViewModel

val viewModelModules = module {
    viewModel { MainViewModel(get())}
    viewModel { SplashViewModel() }
}
