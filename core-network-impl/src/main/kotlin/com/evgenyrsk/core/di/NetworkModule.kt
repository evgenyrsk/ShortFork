package com.evgenyrsk.core.di

import com.evgenyrsk.core.data.NakedShortApi
import com.evgenyrsk.core.data.ShortSqueezeApi
import com.evgenyrsk.core.data.api.BaseUrls.BASE_NAKED_SHORT_URL
import com.evgenyrsk.core.data.api.BaseUrls.BASE_SHORT_SQUEEZE_URL
import com.evgenyrsk.core.data.api.ShortSqueezeApiService
import com.evgenyrsk.core.data.api.ShortSqueezeHtmlDocumentParser
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author Evgeny Rasskazov
 */
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder()
            .client(createClient())
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Provides
    @Singleton
    fun provideNakedShortApi(retrofitBuilder: Retrofit.Builder): NakedShortApi {
        return retrofitBuilder.createServiceWithBaseUrl(BASE_NAKED_SHORT_URL, NakedShortApi::class.java)
    }

    @Provides
    @Singleton
    fun provideShortSqueezeApi(
        retrofitBuilder: Retrofit.Builder,
        responseParser: ShortSqueezeHtmlDocumentParser
    ): ShortSqueezeApi {
        return ShortSqueezeApiService(BASE_SHORT_SQUEEZE_URL, responseParser)
    }

    private fun createClient(): OkHttpClient = OkHttpClient.Builder().build()
}

private fun <T> Retrofit.Builder.createServiceWithBaseUrl(baseUrl: String, serviceClass: Class<T>): T {
    return baseUrl(baseUrl)
        .build()
        .create(serviceClass)
}
