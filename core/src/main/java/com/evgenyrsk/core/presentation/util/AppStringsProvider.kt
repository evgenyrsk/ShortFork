package com.evgenyrsk.core.presentation.util

import android.app.Application
import android.content.Context
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes
import javax.inject.Inject

internal class AppStringsProvider @Inject constructor(
    private val application: Application
) : StringsProvider {

    override fun getString(@StringRes id: Int): String {
        return application.getString(id)
    }

    override fun getString(@StringRes id: Int, vararg args: Any): String {
        return application.getString(id, args)
    }

    override fun getQuantityString(@PluralsRes id: Int, quantity: Int): String {
        return application.resources.getQuantityString(id, quantity)
    }

    override fun getQuantityString(
        @PluralsRes id: Int,
        quantity: Int,
        vararg formatArgs: Any
    ): String {
        return application.resources.getQuantityString(id, quantity, formatArgs)
    }
}