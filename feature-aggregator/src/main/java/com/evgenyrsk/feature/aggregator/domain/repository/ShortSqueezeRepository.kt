package com.evgenyrsk.feature.aggregator.domain.repository

import com.evgenyrsk.core.data.ApiResponse
import com.evgenyrsk.feature.aggregator.data.remote.model.ShortSqueezeNetworkModel

/**
 * @author Evgeny Rasskazov
 * Created on 28.11.2021
 */
interface ShortSqueezeRepository {
    suspend fun fetchShortSqueezeData(companyTicker: String): ApiResponse<ShortSqueezeNetworkModel>
}