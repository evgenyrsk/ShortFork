package com.evgenyrsk.core.di

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

    private fun createClient(): OkHttpClient = OkHttpClient.Builder().build()
}

fun <T> Retrofit.Builder.createServiceWithBaseUrl(baseUrl: String, serviceClass: Class<T>): T {
    return baseUrl(baseUrl)
        .build()
        .create(serviceClass)
}
