package com.evgenyrsk.feature.aggregator.data.remote

import com.evgenyrsk.feature.aggregator.data.remote.model.AggregatorNetworkModel
import com.evgenyrsk.feature.aggregator.data.remote.model.FinVizNetworkModel
import com.evgenyrsk.feature.aggregator.data.remote.model.TightShortsNetworkModel
import com.evgenyrsk.feature.aggregator.data.remote.model.ShortSqueezeNetworkModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Evgeny Rasskazov
 */
interface AggregatorService {

    @GET("/stocks")
    suspend fun getAllData(
        @Query(value = "ticker") ticker: String
    ): Response<AggregatorNetworkModel>

    @GET("/stocks/nakedshort")
    suspend fun getNakedShortData(
        @Query(value = "ticker") ticker: String
    ): Response<TightShortsNetworkModel>

    @GET("/stocks/finviz")
    suspend fun getFinVizData(
        @Query(value = "ticker") ticker: String
    ): Response<FinVizNetworkModel>

    @GET("/stocks/shortsqueeze")
    suspend fun getShortSqueezeData(
        @Query(value = "ticker") ticker: String
    ): Response<ShortSqueezeNetworkModel>
}
