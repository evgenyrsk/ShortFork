package com.evgenyrsk.core.presentation.util

import androidx.annotation.StringRes

interface StringsProvider {
    fun getString(@StringRes id: Int): String
}