package com.evgenyrsk.core.data.repositories

import com.evgenyrsk.core.data.NakedShortApi
import com.evgenyrsk.core.domain.NakedShortRepository
import com.evgenyrsk.core.models.Response
import com.evgenyrsk.core.models.nakedshort.NakedShortApiModel
import javax.inject.Inject

/**
 * @author Evgeny Rasskazov
 */
class NakedShortRepositoryImpl
@Inject
constructor(
    private val nakedShortApi: NakedShortApi
) : NakedShortRepository {

    override suspend fun getShortStockDataHistory(companyTicker: String): Response<NakedShortApiModel> {
        return nakedShortApi.getShortData(companyTicker)
    }
}
