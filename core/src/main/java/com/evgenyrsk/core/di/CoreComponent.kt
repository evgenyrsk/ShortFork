package com.evgenyrsk.core.di

import com.evgenyrsk.core.data.ErrorHandler
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @author Evgeny Rasskazov
 */
@Component(modules = [CoreNetworkModule::class, CoreMiscModule::class])
@Singleton
interface CoreComponent {

    fun getRetrofitBuilder(): Retrofit.Builder

    fun getErrorHandler(): ErrorHandler
}
