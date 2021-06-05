package com.evgenyrsk.feature.aggregator.domain

import com.evgenyrsk.core.data.ApiResponse
import com.evgenyrsk.feature.aggregator.data.FinVizNetworkModel
import com.evgenyrsk.feature.aggregator.data.NakedShortNetworkModel
import com.evgenyrsk.feature.aggregator.data.ShortSqueezeNetworkModel

/**
 * @author Evgeny Rasskazov
 */
interface AggregatorRepository {

    suspend fun getAllData(companyTicker: String): Result<AggregatorDomainModel>

    suspend fun getNakedShortData(companyTicker: String): ApiResponse<NakedShortNetworkModel>

    suspend fun getFinVizData(companyTicker: String): ApiResponse<FinVizNetworkModel>

    suspend fun getShortSqueezeData(companyTicker: String): ApiResponse<ShortSqueezeNetworkModel>
}
