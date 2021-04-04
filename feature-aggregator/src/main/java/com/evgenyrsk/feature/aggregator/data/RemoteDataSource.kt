package com.evgenyrsk.feature.aggregator.data

import com.evgenyrsk.core.data.ApiResponse

/**
 * @author Evgeny Rasskazov
 */
interface RemoteDataSource<T> {

    suspend fun getShortData(companyTicker: String): ApiResponse<T>
}
