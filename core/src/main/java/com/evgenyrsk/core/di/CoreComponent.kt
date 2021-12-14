package com.evgenyrsk.core.di

import android.app.Application
import com.evgenyrsk.core.data.ErrorHandler
import com.evgenyrsk.core.presentation.util.StringsProvider
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @author Evgeny Rasskazov
 * Created on 14.12.2021
 */
@Singleton
@Component(
    modules = [
        CoreNetworkModule::class,
        CorePresentationModule::class
    ],
    dependencies = [
        CoreDependencies::class
    ]
)
interface CoreComponent {

    fun apiErrorHandler(): ErrorHandler

    fun retrofitBuilder(): Retrofit.Builder

    fun stringsProvider(): StringsProvider

    fun application(): Application

    @Component.Factory
    interface Factory {

        fun create(
            dependencies: CoreDependencies
        ): CoreComponent
    }
}