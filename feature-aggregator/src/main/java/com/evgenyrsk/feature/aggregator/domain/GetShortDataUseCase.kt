package com.evgenyrsk.feature.aggregator.domain

import com.evgenyrsk.core.data.ApiError
import com.evgenyrsk.core.data.ApiResponse
import com.evgenyrsk.core.data.ErrorHandler
import com.evgenyrsk.feature.aggregator.data.ShortSqueezeApiModel
import javax.inject.Inject

/**
 * @author Evgeny Rasskazov
 */
class GetShortDataUseCase @Inject constructor(
    private val repository: AggregatorRepository,
    private val errorHandler: ErrorHandler
) {

    private val mapper: AggregatorModelMapper by lazy { AggregatorModelMapper() }

    suspend operator fun invoke(ticker: String): Result<AggregatorDomainModel> {
        return when (val result = repository.getShortSqueezeData(ticker)) {
            is ApiResponse.Success<ShortSqueezeApiModel> -> Result.Success(mapper.toDomainModel(result.data))
            is ApiResponse.Error -> Result.Error(errorHandler.getError(result.exception))
            else -> Result.Error(ApiError.Unknown)
        }
    }
}
