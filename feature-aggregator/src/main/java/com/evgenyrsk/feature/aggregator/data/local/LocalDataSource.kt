package com.evgenyrsk.feature.aggregator.data.local

import com.evgenyrsk.core.data.ApiResponse

/**
 * @author Evgeny Rasskazov
 */
interface LocalDataSource {

    suspend fun getAllShortData(companyTicker: String): ApiResponse<AggregatorDbModel>

    suspend fun getNakedShortData(companyTicker: String): ApiResponse<NakedShortDbModel>

    suspend fun getFinVizData(companyTicker: String): ApiResponse<FinVizDbModel>

    suspend fun getShortSqueezeData(companyTicker: String): ApiResponse<ShortSqueezeDbModel>
}
