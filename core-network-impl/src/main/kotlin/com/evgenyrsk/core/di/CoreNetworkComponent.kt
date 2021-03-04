package com.evgenyrsk.core.di

import dagger.Component
import javax.inject.Singleton

/**
 * @author Evgeny Rasskazov
 */
@Component(modules = [NetworkModule::class])
@Singleton
abstract class CoreNetworkComponent : CoreNetworkApi
