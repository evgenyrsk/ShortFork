package com.evgenyrsk.feature.aggregator.domain

import com.evgenyrsk.feature.aggregator.domain.model.AggregatorDomainModel
import com.evgenyrsk.feature.aggregator.domain.repository.AggregatorRepository
import javax.inject.Inject

/**
 * @author Evgeny Rasskazov
 */
interface GetShortDataUseCase {
    suspend operator fun invoke(ticker: String): Result<AggregatorDomainModel>
}

class GetShortDataUseCaseImpl @Inject constructor(
    private val repository: AggregatorRepository
) : GetShortDataUseCase {

    override suspend operator fun invoke(
        ticker: String
    ): Result<AggregatorDomainModel> = repository.fetchAllData(ticker)
}
