package com.evgenyrsk.feature.aggregator.di

import com.evgenyrsk.core.data.ErrorHandler
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit

/**
 * @author Evgeny Rasskazov
 */
@Module
class AggregatorDependenciesModule {

    @Provides
    @Reusable
    fun providesDependencies(
        retrofitBuilder: Retrofit.Builder,
        errorHandler: ErrorHandler
    ): AggregatorDependencies {
        return object : AggregatorDependencies {
            override fun retrofitBuilder(): Retrofit.Builder = retrofitBuilder
            override fun errorHandler(): ErrorHandler = errorHandler
        }
    }
}
