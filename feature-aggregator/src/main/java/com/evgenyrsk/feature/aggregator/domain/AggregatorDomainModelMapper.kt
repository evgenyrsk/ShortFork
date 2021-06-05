package com.evgenyrsk.feature.aggregator.domain

/**
 * @author Evgeny Rasskazov
 */
fun interface AggregatorDomainModelMapper<NetworkModel> {
    fun map(networkModel: NetworkModel): AggregatorDomainModel
}
