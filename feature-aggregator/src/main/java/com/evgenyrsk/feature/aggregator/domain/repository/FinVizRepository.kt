package com.evgenyrsk.feature.aggregator.domain.repository

import com.evgenyrsk.core.data.ApiResponse
import com.evgenyrsk.feature.aggregator.data.remote.model.FinVizNetworkModel

/**
 * @author Evgeny Rasskazov
 * Created on 28.11.2021
 */
interface FinVizRepository {
    suspend fun fetchFinVizData(companyTicker: String): ApiResponse<FinVizNetworkModel>
}