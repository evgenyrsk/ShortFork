package com.evgenyrsk.nakedshort.data.api

import com.evgenyrsk.nakedshort.data.model.ShortStockDataHistoryApiModel

/**
 * @author Evgeny Rasskazov
 */
class NakedShortServiceHelper(
    private val nakedShortService: NakedShortService
) {

    fun getUsers(
        companyTicker: String
    ): ShortStockDataHistoryApiModel = nakedShortService.getShortStockDataHistory(companyTicker = companyTicker)
}
