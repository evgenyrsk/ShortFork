package com.evgenyrsk.core.shortsqueeze.data

import com.evgenyrsk.core.data.model.Response
import com.evgenyrsk.core.shortsqueeze.model.ShortSqueezeApiModel

/**
 * @author Evgeny Rasskazov
 */
interface ShortSqueezeApi {

    fun getShortData(companyTicker: String): Response<ShortSqueezeApiModel>
}
