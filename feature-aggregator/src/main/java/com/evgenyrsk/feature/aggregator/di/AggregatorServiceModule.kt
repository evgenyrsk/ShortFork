package com.evgenyrsk.feature.aggregator.di

import com.evgenyrsk.core.data.ApiConst
import com.evgenyrsk.core.di.createServiceWithBaseUrl
import com.evgenyrsk.feature.aggregator.data.NakedShortService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * @author Evgeny Rasskazov
 */
@Module
class AggregatorServiceModule {

    @Provides
    fun provideNakedShortService(retrofitBuilder: Retrofit.Builder): NakedShortService {
        return retrofitBuilder.createServiceWithBaseUrl(ApiConst.NAKED_SHORT_URL, NakedShortService::class.java)
    }
}
