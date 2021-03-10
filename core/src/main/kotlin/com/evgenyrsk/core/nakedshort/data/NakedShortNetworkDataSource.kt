package com.evgenyrsk.core.nakedshort.data

import com.evgenyrsk.core.data.model.Response
import com.evgenyrsk.core.nakedshort.model.NakedShortApiModel
import javax.inject.Inject

/**
 * @author Evgeny Rasskazov
 */
class NakedShortNetworkDataSource
@Inject constructor(
    private val nakedShortService: NakedShortService
) : NakedShortApi {

    override fun getShortData(companyTicker: String): Response<NakedShortApiModel> {
        return nakedShortService.getShortData(companyTicker)
    }
}
