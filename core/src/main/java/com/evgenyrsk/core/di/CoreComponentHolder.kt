package com.evgenyrsk.core.di

import android.app.Application

/**
 * @author Evgeny Rasskazov
 * Created on 15.12.2021
 */
object CoreComponentHolder : DataComponentHolder<CoreComponent, CoreDependencies>() {

    override fun createComponent(data: CoreDependencies): CoreComponent =
        DaggerCoreComponent.factory()
            .create(data)
}

class CoreData(val application: Application)