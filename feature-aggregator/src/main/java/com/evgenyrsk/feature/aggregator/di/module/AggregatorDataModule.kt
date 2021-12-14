package com.evgenyrsk.feature.aggregator.di.module

import com.evgenyrsk.core.di.CoreNetworkModule
import com.evgenyrsk.feature.aggregator.data.AggregatorRepositoryImpl
import com.evgenyrsk.feature.aggregator.data.remote.AggregatorRemoteDataSource
import com.evgenyrsk.feature.aggregator.data.remote.RemoteDataSource
import com.evgenyrsk.feature.aggregator.domain.repository.AggregatorRepository
import dagger.Binds
import dagger.Module

/**
 * @author Evgeny Rasskazov
 */
@Module(includes = [CoreNetworkModule::class])
interface AggregatorDataModule {

    @Binds
    fun aggregatorRepository(impl: AggregatorRepositoryImpl): AggregatorRepository

    @Binds
    fun aggregatorRemoteDataSource(impl: AggregatorRemoteDataSource): RemoteDataSource
}
