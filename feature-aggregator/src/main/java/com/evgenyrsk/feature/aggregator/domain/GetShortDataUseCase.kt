package com.evgenyrsk.feature.aggregator.domain

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

    override suspend operator fun invoke(ticker: String): Result<AggregatorDomainModel> {
        return repository.getAllData(ticker)
    }
}
