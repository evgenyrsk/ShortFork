package com.evgenyrsk.shortfork.core

import android.app.Application
import com.evgenyrsk.shortfork.di.ApplicationComponent
import com.evgenyrsk.shortfork.di.DaggerApplicationComponent

/**
 * @author Evgeny Rasskazov
 */
class ShortForkApplication : Application() {

    private val appComponent: ApplicationComponent = DaggerApplicationComponent.builder()
        .application(this)
        .build()
}
