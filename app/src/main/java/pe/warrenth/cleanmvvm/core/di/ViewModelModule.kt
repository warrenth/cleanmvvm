package pe.warrenth.cleanmvvm.core.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pe.warrenth.cleanmvvm.presentation.leftmenu1.LeftMenuLiveDataViewModel
import pe.warrenth.cleanmvvm.presentation.rx.main.MainViewModel
import pe.warrenth.cleanmvvm.presentation.rx.splash.SplashViewModel

val viewModelModules = module {
    /**
     * Case 1
     * by sharedViewModel() get same instance in fragments.
     *
     * Case 2
     * by ViewModel() get instance of ViewModel
     *
     */
    viewModel { LeftMenuLiveDataViewModel(get())}
    viewModel { MainViewModel(get())}
    viewModel { SplashViewModel() }
}

