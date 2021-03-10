package com.evgenyrsk.core.di

import com.evgenyrsk.core.nakedshort.data.NakedShortApi
import com.evgenyrsk.core.shortsqueeze.data.ShortSqueezeApi

/**
 * @author Evgeny Rasskazov
 */
interface CoreNetworkApi {

    fun nakedShortApi(): NakedShortApi

    fun shortSqueezeApi(): ShortSqueezeApi
}
