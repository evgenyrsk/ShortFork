package com.evgenyrsk.core.domain

import com.evgenyrsk.core.models.Response
import com.evgenyrsk.core.models.nakedshort.NakedShortApiModel

/**
 * @author Evgeny Rasskazov
 */
interface NakedShortRepository {

    suspend fun getShortStockDataHistory(companyTicker: String): Response<NakedShortApiModel>
}
