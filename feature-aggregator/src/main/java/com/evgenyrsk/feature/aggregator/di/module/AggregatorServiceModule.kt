package com.evgenyrsk.feature.aggregator.di.module

import com.evgenyrsk.core.data.ApiConst
import com.evgenyrsk.core.di.createServiceWithBaseUrl
import com.evgenyrsk.feature.aggregator.data.remote.AggregatorService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * @author Evgeny Rasskazov
 */
@Module
class AggregatorServiceModule {

    @Provides
    fun providesAggregatorService(retrofitBuilder: Retrofit.Builder): AggregatorService {
        return retrofitBuilder.createServiceWithBaseUrl(ApiConst.SHORT_FORK_URL, AggregatorService::class.java)
    }
}
