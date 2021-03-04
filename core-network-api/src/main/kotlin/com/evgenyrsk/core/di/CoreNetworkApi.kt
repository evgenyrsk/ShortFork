package com.evgenyrsk.core.di

import com.evgenyrsk.core.data.NakedShortApi
import com.evgenyrsk.core.data.ShortSqueezeApi

/**
 * @author Evgeny Rasskazov
 */
interface CoreNetworkApi {

    fun nakedShortApi(): NakedShortApi

    fun shortSqueezeApi(): ShortSqueezeApi
}
