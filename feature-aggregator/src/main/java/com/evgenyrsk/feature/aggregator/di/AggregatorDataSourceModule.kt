package com.evgenyrsk.feature.aggregator.di

import com.evgenyrsk.core.data.ApiConst
import com.evgenyrsk.feature.aggregator.data.NakedShortDataSource
import com.evgenyrsk.feature.aggregator.data.NakedShortNetworkDataSource
import com.evgenyrsk.feature.aggregator.data.NakedShortService
import com.evgenyrsk.feature.aggregator.data.ShortSqueezeDataSource
import com.evgenyrsk.feature.aggregator.data.ShortSqueezeHtmlDocumentParser
import com.evgenyrsk.feature.aggregator.data.ShortSqueezeNetworkDataSource
import dagger.Module
import dagger.Provides

/**
 * @author Evgeny Rasskazov
 */
@Module
class AggregatorDataSourceModule {

    @Provides
    fun provideNakedShortApi(nakedShortService: NakedShortService): NakedShortDataSource {
        return NakedShortNetworkDataSource(nakedShortService)
    }

    @Provides
    fun provideShortSqueezeApi(responseParser: ShortSqueezeHtmlDocumentParser): ShortSqueezeDataSource {
        return ShortSqueezeNetworkDataSource(ApiConst.SHORT_SQUEEZE_URL, responseParser)
    }
}
