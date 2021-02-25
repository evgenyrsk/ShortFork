package com.evgenyrsk.nakedshort.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Evgeny Rasskazov
 */
class NakedApiClient : ApiClient {

    private val retrofit: Retrofit by lazy { createRetrofit() }

    override fun <T> createService(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    private fun createRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private companion object {
        const val BASE_URL = "https://nakedshortreport.com/"
    }
}

interface ApiClient {

    fun <T> createService(serviceClass: Class<T>): T
}
