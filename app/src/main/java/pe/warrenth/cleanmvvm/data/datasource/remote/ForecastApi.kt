package com.shiftweather.datasource.remote.forecast

import pe.warrenth.cleanmvvm.data.datasource.entity.ForecastsEntity
import io.reactivex.Single
import retrofit2.http.GET

interface ForecastApi {

    @GET("forecast")
    fun getForecasts(): Single<ForecastsEntity>


}