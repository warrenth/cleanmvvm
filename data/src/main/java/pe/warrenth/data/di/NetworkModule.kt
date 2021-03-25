package pe.warrenth.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pe.warrenth.data.KakaoApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@InstallIn(ApplicationComponent::class)
@Module
interface NetworkModule {

    companion object {
        @Provides
        fun providesOkHttpClient(): OkHttpClient {
            val chainInterceptor = { chain: Interceptor.Chain ->
                chain.proceed(
                    chain.request().newBuilder()
                        .header("Content-Type", "application/json")
                        .header("Accept", "application/json")
                        .build()
                )
            }
            return OkHttpClient.Builder()
                .addInterceptor(chainInterceptor)
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .readTimeout(120, TimeUnit.SECONDS)
                .connectTimeout(120, TimeUnit.SECONDS)
                .build()
        }


        @Provides
        fun providesRetrofitBuilder(client: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://dapi.kakao.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        @Provides
        fun providesApiService(retrofit: Retrofit): KakaoApiService {
            return retrofit.create(KakaoApiService::class.java)
        }
    }


}