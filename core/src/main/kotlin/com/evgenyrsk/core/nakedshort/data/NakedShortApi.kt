package com.evgenyrsk.core.nakedshort.data

import com.evgenyrsk.core.data.model.Response
import com.evgenyrsk.core.nakedshort.model.NakedShortApiModel

/**
 * @author Evgeny Rasskazov
 */
interface NakedShortApi {

    fun getShortData(companyTicker: String): Response<NakedShortApiModel>
}
