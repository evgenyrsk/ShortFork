package com.evgenyrsk.feature.aggregator.data

import com.evgenyrsk.core.data.ApiResponse

/**
 * @author Evgeny Rasskazov
 */
interface ShortSqueezeDataSource {

    suspend fun getShortData(companyTicker: String): ApiResponse<ShortSqueezeApiModel>
}
