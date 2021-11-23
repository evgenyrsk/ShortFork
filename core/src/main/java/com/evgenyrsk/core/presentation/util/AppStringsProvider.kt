package com.evgenyrsk.core.presentation.util

import android.app.Application
import android.content.Context
import androidx.annotation.StringRes

internal class AppStringsProvider(
    private val application: Application
) : StringsProvider {

    override fun getString(@StringRes id: Int): String = application.getString(id)
}