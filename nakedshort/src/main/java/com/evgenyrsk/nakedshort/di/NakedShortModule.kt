package com.evgenyrsk.nakedshort.di

import com.evgenyrsk.nakedshort.data.api.ApiClient
import com.evgenyrsk.nakedshort.data.api.NakedApiClient
import com.evgenyrsk.nakedshort.data.api.NakedShortService
import com.evgenyrsk.nakedshort.data.api.NakedShortServiceHelper
import com.evgenyrsk.nakedshort.data.repository.NakedShortDefaultRepository
import dagger.Module
import dagger.Provides
import dagger.Reusable

/**
 * @author Evgeny Rasskazov
 */
@Module
class NakedShortModule {

    @Provides
    @Reusable
    fun provideApiClient(): ApiClient {
        return NakedApiClient()
    }

    @Provides
    @Reusable
    fun provideNakedShortService(apiClient: ApiClient): NakedShortService {
        return apiClient.createService(NakedShortService::class.java)
    }

    @Provides
    @Reusable
    fun provideNakedShortServiceHelper(nakedShortService: NakedShortService): NakedShortServiceHelper {
        return NakedShortServiceHelper(nakedShortService)
    }

    @Provides
    @Reusable
    fun provideRepository(nakedShortServiceHelper: NakedShortServiceHelper): NakedShortDefaultRepository {
        return NakedShortDefaultRepository(nakedShortServiceHelper)
    }
}
