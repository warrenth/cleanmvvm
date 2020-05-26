package pe.warrenth.cleanmvvm.data.mapper

/**
 * Created by Qifan on 2019-07-14.
 */

interface EntityMapper<M, E>

interface EntityRemoteMapper<M, E> : EntityMapper<M, E> {
    fun mapFromRemote(type: M): E
}

interface EntityLocalMapper<M, E> : EntityMapper<M, E> {
    fun mapFromLocal(type: M): E
    fun mapToLocal(type: E): M
}