package com.evgenyrsk.feature.aggregator.di.module

import com.evgenyrsk.feature.aggregator.domain.GetShortDataUseCase
import com.evgenyrsk.feature.aggregator.domain.GetShortDataUseCaseImpl
import dagger.Binds
import dagger.Module

/**
 * @author Evgeny Rasskazov
 */
@Module
interface AggregatorDomainModule {

    @Binds
    fun bindGetShortDataUseCase(impl: GetShortDataUseCaseImpl): GetShortDataUseCase
}
