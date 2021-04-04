package com.evgenyrsk.feature.aggregator.domain

import com.evgenyrsk.core.data.ApiResponse
import com.evgenyrsk.feature.aggregator.data.AggregatorApiModel

/**
 * @author Evgeny Rasskazov
 */
interface AggregatorRepository {

    suspend fun getShortForkData(companyTicker: String): ApiResponse<AggregatorApiModel>
}
