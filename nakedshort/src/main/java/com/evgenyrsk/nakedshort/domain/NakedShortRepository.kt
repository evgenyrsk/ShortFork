package com.evgenyrsk.nakedshort.domain

import com.evgenyrsk.nakedshort.data.model.ShortStockDataHistoryApiModel

/**
 * @author Evgeny Rasskazov
 */
interface NakedShortRepository {

    suspend fun getShortStockDataHistory(companyTicker: String): ShortStockDataHistoryApiModel
}
