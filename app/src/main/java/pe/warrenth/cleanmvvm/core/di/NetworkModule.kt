package pe.warrenth.cleanmvvm.core.di

import com.google.gson.GsonBuilder
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import pe.warrenth.cleanmvvm.BuildConfig
import pe.warrenth.cleanmvvm.data.datasource.remote.ApiPostService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModules = module {
    single { Cache(androidApplication().cacheDir, OK_HTTP_CACHE_SIZE) }

    single { GsonBuilder().create() }

    single {
        OkHttpClient.Builder().apply {
            cache(get())
            addInterceptor(HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            })
        }.build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(get()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(get())
            .build()
    }

    single<ApiPostService> {
        get<Retrofit>().create(ApiPostService::class.java)
    }
}

const val BASE_URL = "http://jsonplaceholder.typicode.com/"
const val OK_HTTP_CACHE_SIZE = 10L * 1024 * 1024