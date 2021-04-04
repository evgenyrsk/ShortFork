package com.evgenyrsk.feature.aggregator.data

import com.evgenyrsk.core.data.ApiResponse
import com.evgenyrsk.feature.aggregator.domain.AggregatorRepository
import javax.inject.Inject

/**
 * @author Evgeny Rasskazov
 */
class AggregatorRepositoryImpl @Inject constructor(
    private val aggregatorRemoteDataSource: RemoteDataSource<AggregatorApiModel>
) : AggregatorRepository {

    override suspend fun getShortForkData(companyTicker: String): ApiResponse<AggregatorApiModel> {
        return aggregatorRemoteDataSource.getShortData(companyTicker)
    }
}
