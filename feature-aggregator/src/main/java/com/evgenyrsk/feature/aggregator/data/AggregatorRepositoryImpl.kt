package com.evgenyrsk.feature.aggregator.data

import com.evgenyrsk.core.data.ApiResponse
import com.evgenyrsk.core.data.ErrorHandler
import com.evgenyrsk.feature.aggregator.data.remote.*
import com.evgenyrsk.feature.aggregator.data.remote.model.FinVizNetworkModel
import com.evgenyrsk.feature.aggregator.data.remote.model.TightShortsNetworkModel
import com.evgenyrsk.feature.aggregator.data.remote.model.ShortSqueezeNetworkModel
import com.evgenyrsk.feature.aggregator.domain.model.AggregatorDomainModel
import com.evgenyrsk.feature.aggregator.domain.Result
import com.evgenyrsk.feature.aggregator.domain.repository.AggregatorRepository
import com.evgenyrsk.feature.aggregator.domain.repository.FinVizRepository
import com.evgenyrsk.feature.aggregator.domain.repository.NakedShortRepository
import com.evgenyrsk.feature.aggregator.domain.repository.ShortSqueezeRepository
import javax.inject.Inject

/**
 * @author Evgeny Rasskazov
 */
class AggregatorRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val apiErrorHandler: ErrorHandler
) : AggregatorRepository, FinVizRepository, NakedShortRepository, ShortSqueezeRepository {

    override suspend fun fetchAllData(companyTicker: String): Result<AggregatorDomainModel> {
        return when (val response = remoteDataSource.getAllShortData(companyTicker)) {
            is ApiResponse.Success -> Result.Success(response.data.toDomainModel())
            is ApiResponse.Error -> Result.Error(apiErrorHandler.getError(response.exception))
        }
    }

    // TODO make it in the same way as above method
    override suspend fun fetchNakedShortData(
        companyTicker: String
    ): ApiResponse<TightShortsNetworkModel> = remoteDataSource.getNakedShortData(companyTicker)

    override suspend fun fetchFinVizData(
        companyTicker: String
    ): ApiResponse<FinVizNetworkModel> = remoteDataSource.getFinVizData(companyTicker)

    override suspend fun fetchShortSqueezeData(
        companyTicker: String
    ): ApiResponse<ShortSqueezeNetworkModel> = remoteDataSource.getShortSqueezeData(companyTicker)
}
