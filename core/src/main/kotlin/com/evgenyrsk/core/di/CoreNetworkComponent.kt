package com.evgenyrsk.core.di

import com.evgenyrsk.core.nakedshort.NakedShortNetworkModule
import com.evgenyrsk.core.shortsqueeze.ShortSqueezeNetworkModule
import dagger.Component
import javax.inject.Singleton

/**
 * @author Evgeny Rasskazov
 */
@Component(
    modules = [
        NetworkModule::class,
        NakedShortNetworkModule::class,
        ShortSqueezeNetworkModule::class
    ]
)
@Singleton
abstract class CoreNetworkComponent : CoreNetworkApi
