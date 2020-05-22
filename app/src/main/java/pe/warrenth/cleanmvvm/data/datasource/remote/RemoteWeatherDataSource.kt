package pe.warrenth.cleanmvvm.data.datasource.remote

import pe.warrenth.cleanmvvm.data.datasource.entity.mapToDomain
import com.shiftweather.datasource.remote.forecast.ForecastRequest
import io.reactivex.Single
import pe.warrenth.cleanmvvm.data.datasource.PostsDataSource

class RemoteWeatherDataSource constructor(private val request: ForecastRequest) : PostsDataSource {


    override fun get(): Single<Forecasts> {
        return request.getForecastData().map { it.mapToDomain() }
    }

}