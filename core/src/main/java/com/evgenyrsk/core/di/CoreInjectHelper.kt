package com.evgenyrsk.core.di

import android.content.Context

/**
 * @author Evgeny Rasskazov
 */
object CoreInjectHelper {

    fun provideCoreComponent(applicationContext: Context): CoreComponent {
        return (applicationContext as? CoreComponentProvider)?.get()
            ?: throw IllegalStateException(
                "The application context you have passed does not implement CoreComponentProvider"
            )
    }
}
