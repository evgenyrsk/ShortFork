package com.evgenyrsk.feature.aggregator.di

import com.evgenyrsk.core.data.ErrorHandler
import retrofit2.Retrofit

/**
 * @author Evgeny Rasskazov
 */
interface AggregatorDependencies {

    fun retrofitBuilder(): Retrofit.Builder

    fun errorHandler(): ErrorHandler
}
