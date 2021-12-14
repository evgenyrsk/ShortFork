package com.evgenyrsk.core.presentation.util

import androidx.annotation.PluralsRes
import androidx.annotation.StringRes

interface StringsProvider {

    fun getString(@StringRes id: Int): String

    fun getString(@StringRes id: Int, vararg args: Any): String

    fun getQuantityString(@PluralsRes id: Int, quantity: Int): String

    fun getQuantityString(@PluralsRes id: Int, quantity: Int, vararg formatArgs: Any): String
}