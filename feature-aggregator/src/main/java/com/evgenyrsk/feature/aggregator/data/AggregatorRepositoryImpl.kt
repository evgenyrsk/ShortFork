package com.evgenyrsk.feature.aggregator.data

import com.evgenyrsk.core.data.ApiResponse
import com.evgenyrsk.feature.aggregator.domain.AggregatorRepository
import javax.inject.Inject

/**
 * @author Evgeny Rasskazov
 */
class AggregatorRepositoryImpl @Inject constructor(
    private val nakedShortDataSource: NakedShortDataSource,
    private val shortSqueezeDataSource: ShortSqueezeDataSource
) : AggregatorRepository {

    override suspend fun getShortStockDataHistory(companyTicker: String): ApiResponse<NakedShortApiModel> {
        return nakedShortDataSource.getShortData(companyTicker)
    }

    override suspend fun getShortSqueezeData(companyTicker: String): ApiResponse<ShortSqueezeApiModel> {
        return shortSqueezeDataSource.getShortData(companyTicker)
    }
}
