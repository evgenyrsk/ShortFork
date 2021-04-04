package com.evgenyrsk.feature.aggregator.di.module

import com.evgenyrsk.core.data.ErrorHandler
import com.evgenyrsk.feature.aggregator.di.AggregatorDependencies
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
