package com.evgenyrsk.feature.aggregator.di.module

import com.evgenyrsk.feature.aggregator.data.AggregatorRemoteDataSource
import com.evgenyrsk.feature.aggregator.data.AggregatorRepositoryImpl
import com.evgenyrsk.feature.aggregator.data.RemoteDataSource
import com.evgenyrsk.feature.aggregator.domain.AggregatorRepository
import dagger.Binds
import dagger.Module

/**
 * @author Evgeny Rasskazov
 */
@Module
interface AggregatorDataModule {

    @Binds
    fun bindAggregatorRepository(impl: AggregatorRepositoryImpl): AggregatorRepository

    @Binds
    fun bindAggregatorRemoteDataSource(impl: AggregatorRemoteDataSource): RemoteDataSource
}
