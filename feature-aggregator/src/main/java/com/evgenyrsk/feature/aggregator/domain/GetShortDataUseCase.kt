package com.evgenyrsk.feature.aggregator.domain

import com.evgenyrsk.core.data.ApiError
import com.evgenyrsk.core.data.ApiResponse
import com.evgenyrsk.core.data.ErrorHandler
import com.evgenyrsk.feature.aggregator.data.NetworkModel
import javax.inject.Inject

/**
 * @author Evgeny Rasskazov
 */
interface GetShortDataUseCase {
    suspend operator fun invoke(ticker: String): Result<AggregatorDomainModel>
}

class GetShortDataUseCaseImpl @Inject constructor(
    private val repository: AggregatorRepository,
    private val errorHandler: ErrorHandler
) : GetShortDataUseCase {

    private val mapper: AggregatorModelMapper by lazy { AggregatorModelMapper() }

    override suspend operator fun invoke(ticker: String): Result<AggregatorDomainModel> {
        return when (val result = repository.getAllData(ticker)) {
            is ApiResponse.Success<NetworkModel> -> Result.Success(mapper.toDomainModel(result.data))
            is ApiResponse.Error -> Result.Error(errorHandler.getError(result.exception))
            else -> Result.Error(ApiError.Unknown)
        }
    }
}
