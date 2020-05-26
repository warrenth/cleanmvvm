package pe.warrenth.cleanmvvm.core.net

import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import pe.warrenth.cleanmvvm.CleanApplication
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit


class RetrofitManager (private val retrofit: Retrofit) {


    fun <T> makeRemoteCall(apiSource: Class<out T>): T {

        return retrofit.create(apiSource)

    }

}