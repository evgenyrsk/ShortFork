package com.evgenyrsk.feature.aggregator.domain.repository

import com.evgenyrsk.feature.aggregator.domain.model.AggregatorDomainModel
import com.evgenyrsk.feature.aggregator.domain.Result

/**
 * @author Evgeny Rasskazov
 */
interface AggregatorRepository {
    suspend fun fetchAllData(companyTicker: String): Result<AggregatorDomainModel>
}
