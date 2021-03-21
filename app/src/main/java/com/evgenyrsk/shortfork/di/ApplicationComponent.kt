package com.evgenyrsk.shortfork.di

import android.app.Application
import com.evgenyrsk.core.di.CoreMiscModule
import com.evgenyrsk.core.di.CoreNetworkModule
import com.evgenyrsk.feature.aggregator.di.AggregatorDependencies
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * @author Evgeny Rasskazov
 */
@Component(modules = [CoreNetworkModule::class, CoreMiscModule::class])
@Singleton
interface ApplicationComponent : AggregatorDependencies {

    fun getApplication(): Application

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}
