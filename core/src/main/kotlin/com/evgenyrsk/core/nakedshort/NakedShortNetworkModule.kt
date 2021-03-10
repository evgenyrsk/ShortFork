package com.evgenyrsk.core.nakedshort

import com.evgenyrsk.core.data.BaseUrls
import com.evgenyrsk.core.di.createServiceWithBaseUrl
import com.evgenyrsk.core.nakedshort.data.NakedShortApi
import com.evgenyrsk.core.nakedshort.data.NakedShortNetworkDataSource
import com.evgenyrsk.core.nakedshort.data.NakedShortService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit

/**
 * @author Evgeny Rasskazov
 */
@Module
class NakedShortNetworkModule {

    @Provides
    @Reusable
    fun provideNakedShortApi(nakedShortService: NakedShortService): NakedShortApi {
        return NakedShortNetworkDataSource(nakedShortService)
    }

    @Provides
    @Reusable
    fun provideNakedShortService(retrofitBuilder: Retrofit.Builder): NakedShortService {
        return retrofitBuilder.createServiceWithBaseUrl(BaseUrls.BASE_NAKED_SHORT_URL, NakedShortService::class.java)
    }
}
