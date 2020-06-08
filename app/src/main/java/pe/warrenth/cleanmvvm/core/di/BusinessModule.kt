package pe.warrenth.cleanmvvm.core.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import pe.warrenth.cleanmvvm.data.datasource.rx.PostDataSource
import pe.warrenth.cleanmvvm.data.datasource.rx.PostDataStoreFactory
import pe.warrenth.cleanmvvm.data.datasource.rx.local.PostLocalDataSource
import pe.warrenth.cleanmvvm.data.datasource.rx.remote.PostRemoteDataSource
import pe.warrenth.cleanmvvm.data.datasource.rx.mapper.PostEntityMapper
import pe.warrenth.cleanmvvm.data.repository.rx.LeftMenuRepository
import pe.warrenth.cleanmvvm.data.repository.rx.PostRepository
import pe.warrenth.cleanmvvm.domain.repository.ILeftMenuRepository
import pe.warrenth.cleanmvvm.domain.repository.IPostRepository
import pe.warrenth.cleanmvvm.domain.usecase.GetLeftMenu
import pe.warrenth.cleanmvvm.domain.usecase.GetPostUseCase

val domainModule = module {
    factory {
        PostDataStoreFactory(
            get(named("local")),
            get(named("remote"))
        )
    }

    //sample
    factory<IPostRepository> {
        PostRepository(
            get()
        )
    }
    factory { GetPostUseCase(get()) }

    //leftmenu
    factory<ILeftMenuRepository> {
        LeftMenuRepository(
            get()
        )
    }
    factory { GetLeftMenu(get()) }
}

val dataModule = module {
    factory {
        PostEntityMapper()
    }


    factory<PostDataSource>(named("remote")) {
        PostRemoteDataSource(get(), get())
    }
    factory<PostDataSource>(named("local")) {
        PostLocalDataSource(get(), get())
    }
}