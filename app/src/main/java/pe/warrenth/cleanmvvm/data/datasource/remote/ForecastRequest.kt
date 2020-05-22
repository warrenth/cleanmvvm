package com.shiftweather.datasource.remote.forecast

import pe.warrenth.cleanmvvm.data.datasource.entity.ForecastsEntity
import io.reactivex.Single
import pe.warrenth.cleanmvvm.core.net.BaseNetworkRequest


/**
 * A class used to make remote api requests
 *
 * */
class ForecastRequest : BaseNetworkRequest<ForecastApi>(ForecastApi::class.java) {


    fun getForecastData(): Single<ForecastsEntity> {
        return makeRequest().getForecasts()
    }

}