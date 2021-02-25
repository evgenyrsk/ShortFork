package com.evgenyrsk.nakedshort.data.repository

import com.evgenyrsk.nakedshort.data.api.NakedShortServiceHelper
import com.evgenyrsk.nakedshort.data.model.ShortStockDataHistoryApiModel
import com.evgenyrsk.nakedshort.domain.NakedShortRepository
import javax.inject.Inject

/**
 * @author Evgeny Rasskazov
 */
class NakedShortDefaultRepository @Inject constructor(
    private val nakedShortServiceHelper: NakedShortServiceHelper
) : NakedShortRepository {

    override suspend fun getShortStockDataHistory(
        companyTicker: String
    ): ShortStockDataHistoryApiModel = nakedShortServiceHelper.getUsers(companyTicker)
}
