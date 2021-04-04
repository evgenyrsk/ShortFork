package com.evgenyrsk.feature.aggregator.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Evgeny Rasskazov
 */
interface AggregatorService {

    @GET("/stocks?")
    suspend fun getShortData(
        @Query(value = "ticker") ticker: String
    ): Response<AggregatorApiModel>
}
