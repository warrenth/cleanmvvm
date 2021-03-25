package pe.warrenth.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class KakaoRemoteModule {

    //@Binds
    //abstract fun providesRecipeRemote(impl: RecipeRemoteImpl): RecipeRemote
}