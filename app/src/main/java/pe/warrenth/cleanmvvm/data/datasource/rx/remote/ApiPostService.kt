package pe.warrenth.cleanmvvm.data.datasource.rx.remote

import io.reactivex.Single
import pe.warrenth.cleanmvvm.data.model.PostModel
import retrofit2.http.GET

interface ApiPostService {

    @GET("photos")
    fun getData(): Single<List<PostModel>>

}