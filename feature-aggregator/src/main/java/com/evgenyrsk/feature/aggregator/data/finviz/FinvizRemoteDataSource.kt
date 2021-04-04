package com.evgenyrsk.feature.aggregator.data.finviz

import com.evgenyrsk.core.data.ApiResponse
import com.evgenyrsk.feature.aggregator.data.RemoteDataSource

/**
 * @author Evgeny Rasskazov
 */
class FinvizRemoteDataSource : RemoteDataSource<FinvizApiModel> {

    override suspend fun getShortData(companyTicker: String): ApiResponse<FinvizApiModel> {
        TODO("Not yet implemented")
    }
}
