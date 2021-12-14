package com.evgenyrsk.shortfork.di

import android.app.Application
import com.evgenyrsk.core.di.CoreDependencies

internal class AppCoreDependencies(
    private val application: Application
) : CoreDependencies {

    override fun application(): Application = application
}