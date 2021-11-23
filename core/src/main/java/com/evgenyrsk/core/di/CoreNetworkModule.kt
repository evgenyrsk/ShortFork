package com.evgenyrsk.core.di

import com.evgenyrsk.core.data.ApiConst
import com.evgenyrsk.core.data.ApiErrorHandler
import com.evgenyrsk.core.data.ErrorHandler
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
class CoreNetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitBuilder(okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(ApiConst.SHORT_FORK_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Provides
    @Singleton
    fun apiErrorHandler(): ErrorHandler = ApiErrorHandler()
}

fun <T> Retrofit.Builder.createServiceWithBaseUrl(baseUrl: String, serviceClass: Class<T>): T {
    return baseUrl(baseUrl)
        .build()
        .create(serviceClass)
}
