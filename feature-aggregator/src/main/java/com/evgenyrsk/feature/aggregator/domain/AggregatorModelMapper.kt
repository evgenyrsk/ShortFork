package com.evgenyrsk.feature.aggregator.domain

import com.evgenyrsk.feature.aggregator.data.ShortSqueezeApiModel

/**
 * @author Evgeny Rasskazov
 */
class AggregatorModelMapper {

    fun toDomainModel(
        shortSqueezeApiModel: ShortSqueezeApiModel
    ): AggregatorDomainModel = AggregatorDomainModel(shortSqueezeApiModel.ticker)
}
