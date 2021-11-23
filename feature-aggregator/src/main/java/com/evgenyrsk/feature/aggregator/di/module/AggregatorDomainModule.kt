package com.evgenyrsk.feature.aggregator.di.module

import com.evgenyrsk.feature.aggregator.domain.GetShortDataUseCase
import com.evgenyrsk.feature.aggregator.domain.GetShortDataUseCaseImpl
import dagger.Binds
import dagger.Module

/**
 * @author Evgeny Rasskazov
 */
@Module
internal interface AggregatorDomainModule {

    @Binds
    fun getShortDataUseCase(impl: GetShortDataUseCaseImpl): GetShortDataUseCase
}
