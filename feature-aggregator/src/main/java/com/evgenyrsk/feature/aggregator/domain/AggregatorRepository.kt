package com.evgenyrsk.feature.aggregator.domain

import com.evgenyrsk.core.data.ApiResponse
import com.evgenyrsk.feature.aggregator.data.NakedShortApiModel
import com.evgenyrsk.feature.aggregator.data.ShortSqueezeApiModel

/**
 * @author Evgeny Rasskazov
 */
interface AggregatorRepository {

    suspend fun getShortStockDataHistory(companyTicker: String): ApiResponse<NakedShortApiModel>

    suspend fun getShortSqueezeData(companyTicker: String): ApiResponse<ShortSqueezeApiModel>
}
