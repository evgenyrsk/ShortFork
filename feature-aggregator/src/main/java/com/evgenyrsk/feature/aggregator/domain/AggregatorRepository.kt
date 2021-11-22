package com.evgenyrsk.feature.aggregator.domain

import com.evgenyrsk.core.data.ApiResponse
import com.evgenyrsk.feature.aggregator.data.remote.FinVizNetworkModel
import com.evgenyrsk.feature.aggregator.data.remote.NakedShortNetworkModel
import com.evgenyrsk.feature.aggregator.data.remote.ShortSqueezeNetworkModel

/**
 * @author Evgeny Rasskazov
 */
interface AggregatorRepository {

    suspend fun getAllData(companyTicker: String): Result<AggregatorDomainModel>

    suspend fun getNakedShortData(companyTicker: String): ApiResponse<NakedShortNetworkModel>

    suspend fun getFinVizData(companyTicker: String): ApiResponse<FinVizNetworkModel>

    suspend fun getShortSqueezeData(companyTicker: String): ApiResponse<ShortSqueezeNetworkModel>
}
