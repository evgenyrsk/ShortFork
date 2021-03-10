package com.evgenyrsk.feature.board.data

import com.evgenyrsk.core.data.model.Response
import com.evgenyrsk.core.nakedshort.data.NakedShortApi
import com.evgenyrsk.core.nakedshort.model.NakedShortApiModel
import com.evgenyrsk.core.shortsqueeze.data.ShortSqueezeApi
import com.evgenyrsk.core.shortsqueeze.model.ShortSqueezeApiModel

/**
 * @author Evgeny Rasskazov
 */
class BoardRepository(
    private val nakedShortApi: NakedShortApi,
    private val shortSqueezeApi: ShortSqueezeApi
) {

    suspend fun getShortStockDataHistory(companyTicker: String): Response<NakedShortApiModel> {
        return nakedShortApi.getShortData(companyTicker)
    }

    suspend fun getShortSqueezeData(companyTicker: String): Response<ShortSqueezeApiModel> {
        return shortSqueezeApi.getShortData(companyTicker)
    }
}
