package com.evgenyrsk.feature.aggregator.domain.repository

import com.evgenyrsk.core.data.ApiResponse
import com.evgenyrsk.feature.aggregator.data.remote.model.TightShortsNetworkModel

/**
 * @author Evgeny Rasskazov
 * Created on 28.11.2021
 */
interface NakedShortRepository {
    suspend fun fetchNakedShortData(companyTicker: String): ApiResponse<TightShortsNetworkModel>
}