package com.evgenyrsk.shortfork.di

import android.app.Application
import com.evgenyrsk.core.di.CorePresentationModule
import com.evgenyrsk.core.di.CoreNetworkModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * @author Evgeny Rasskazov
 */
@Singleton
@Component(
    modules = [
        CoreNetworkModule::class,
        CorePresentationModule::class
    ]
)
interface ApplicationComponent {

    fun getApplication(): Application

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}
