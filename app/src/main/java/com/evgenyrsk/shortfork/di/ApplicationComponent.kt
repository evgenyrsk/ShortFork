package com.evgenyrsk.shortfork.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * @author Evgeny Rasskazov
 */
@Singleton
@Component
interface ApplicationComponent {

    fun application(): Application

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}
