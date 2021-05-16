package com.evgenyrsk.feature.aggregator.data

import com.evgenyrsk.core.data.ApiResponse
import com.evgenyrsk.feature.aggregator.domain.AggregatorRepository
import javax.inject.Inject

/**
 * @author Evgeny Rasskazov
 */
class AggregatorRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : AggregatorRepository {

    override suspend fun getAllData(companyTicker: String): ApiResponse<NetworkModel> {
        return remoteDataSource.getAllShortData(companyTicker)
    }

    override suspend fun getNakedShortData(companyTicker: String): ApiResponse<NakedShortNetworkModel> {
        return remoteDataSource.getNakedShortData(companyTicker)
    }

    override suspend fun getFinVizData(companyTicker: String): ApiResponse<FinVizNetworkModel> {
        return remoteDataSource.getFinVizData(companyTicker)
    }

    override suspend fun getShortSqueezeData(companyTicker: String): ApiResponse<ShortSqueezeNetworkModel> {
        return remoteDataSource.getShortSqueezeData(companyTicker)
    }
}
