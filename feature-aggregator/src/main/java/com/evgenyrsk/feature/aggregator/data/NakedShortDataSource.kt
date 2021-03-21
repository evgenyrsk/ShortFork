package com.evgenyrsk.feature.aggregator.data

import com.evgenyrsk.core.data.ApiResponse

/**
 * @author Evgeny Rasskazov
 */
interface NakedShortDataSource {

    suspend fun getShortData(companyTicker: String): ApiResponse<NakedShortApiModel>
}
