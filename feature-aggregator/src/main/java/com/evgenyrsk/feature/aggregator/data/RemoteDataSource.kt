package com.evgenyrsk.feature.aggregator.data

import com.evgenyrsk.core.data.ApiResponse

/**
 * @author Evgeny Rasskazov
 */
interface RemoteDataSource {

    suspend fun getAllShortData(companyTicker: String): ApiResponse<NetworkModel>

    suspend fun getNakedShortData(companyTicker: String): ApiResponse<NakedShortNetworkModel>

    suspend fun getFinVizData(companyTicker: String): ApiResponse<FinVizNetworkModel>

    suspend fun getShortSqueezeData(companyTicker: String): ApiResponse<ShortSqueezeNetworkModel>
}
