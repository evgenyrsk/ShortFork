package com.evgenyrsk.core.domain

import com.evgenyrsk.core.models.Response
import com.evgenyrsk.core.models.shortsqueeze.ShortSqueezeApiModel

/**
 * @author Evgeny Rasskazov
 */
interface ShortSqueezeRepository {

    suspend fun getShortSqueezeData(companyTicker: String): Response<ShortSqueezeApiModel>
}
