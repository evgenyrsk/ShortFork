package com.evgenyrsk.core.data

import com.evgenyrsk.core.models.Response
import com.evgenyrsk.core.models.shortsqueeze.ShortSqueezeApiModel

/**
 * @author Evgeny Rasskazov
 */
interface ShortSqueezeApi {

    fun getShortData(companyTicker: String): Response<ShortSqueezeApiModel>
}
