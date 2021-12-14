package com.evgenyrsk.feature.aggregator.data.remote

import com.evgenyrsk.core.data.ApiResponse
import com.evgenyrsk.feature.aggregator.data.remote.model.AggregatorNetworkModel
import com.evgenyrsk.feature.aggregator.data.remote.model.FinVizNetworkModel
import com.evgenyrsk.feature.aggregator.data.remote.model.TightShortsNetworkModel
import com.evgenyrsk.feature.aggregator.data.remote.model.ShortSqueezeNetworkModel

/**
 * @author Evgeny Rasskazov
 */
interface RemoteDataSource {

    suspend fun getAllShortData(companyTicker: String): ApiResponse<AggregatorNetworkModel>

    suspend fun getNakedShortData(companyTicker: String): ApiResponse<TightShortsNetworkModel>

    suspend fun getFinVizData(companyTicker: String): ApiResponse<FinVizNetworkModel>

    suspend fun getShortSqueezeData(companyTicker: String): ApiResponse<ShortSqueezeNetworkModel>
}
