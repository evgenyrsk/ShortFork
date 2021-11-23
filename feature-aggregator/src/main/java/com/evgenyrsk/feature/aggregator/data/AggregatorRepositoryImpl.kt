package com.evgenyrsk.feature.aggregator.data

import com.evgenyrsk.core.data.ApiResponse
import com.evgenyrsk.core.data.ErrorHandler
import com.evgenyrsk.feature.aggregator.data.remote.*
import com.evgenyrsk.feature.aggregator.domain.AggregatorDomainModel
import com.evgenyrsk.feature.aggregator.domain.AggregatorRepository
import com.evgenyrsk.feature.aggregator.domain.Result
import javax.inject.Inject

/**
 * @author Evgeny Rasskazov
 */
class AggregatorRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val apiErrorHandler: ErrorHandler
) : AggregatorRepository {

    override suspend fun getAllData(companyTicker: String): Result<AggregatorDomainModel> {
        return when (val response = remoteDataSource.getAllShortData(companyTicker)) {
            is ApiResponse.Success -> Result.Success(response.data.toDomainModel())
            is ApiResponse.Error -> Result.Error(apiErrorHandler.getError(response.exception))
        }
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
