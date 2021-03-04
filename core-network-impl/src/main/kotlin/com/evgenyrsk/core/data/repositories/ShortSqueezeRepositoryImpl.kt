package com.evgenyrsk.core.data.repositories

import com.evgenyrsk.core.data.ShortSqueezeApi
import com.evgenyrsk.core.domain.ShortSqueezeRepository
import com.evgenyrsk.core.models.Response
import com.evgenyrsk.core.models.shortsqueeze.ShortSqueezeApiModel
import javax.inject.Inject

/**
 * @author Evgeny Rasskazov
 */
class ShortSqueezeRepositoryImpl
@Inject constructor(
    private val shortSqueezeApi: ShortSqueezeApi
) : ShortSqueezeRepository {

    override suspend fun getShortSqueezeData(companyTicker: String): Response<ShortSqueezeApiModel> {
        return shortSqueezeApi.getShortData(companyTicker)
    }
}
