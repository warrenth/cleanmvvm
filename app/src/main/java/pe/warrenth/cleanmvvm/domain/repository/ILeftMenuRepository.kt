package pe.warrenth.cleanmvvm.domain.repository

import io.reactivex.Flowable
import io.reactivex.Observable
import pe.warrenth.cleanmvvm.data.model.PostModel
import pe.warrenth.cleanmvvm.domain.entity.PostEntity

interface ILeftMenuRepository {

    fun getData(): Flowable<List<PostEntity>>
}