package pe.warrenth.cleanmvvm

import pe.warrenth.cleanmvvm.core.di.*

/**
 * 변수로 얻어오는 방식
 */
val appModules = listOf(
    viewModelModules, domainModule, dataModule, networkModules
)

/**
 * 객체로 얻어오는 방식
 */
object AppModules {
    fun get() = listOf(viewModelModules, domainModule, dataModule, networkModules)
}
