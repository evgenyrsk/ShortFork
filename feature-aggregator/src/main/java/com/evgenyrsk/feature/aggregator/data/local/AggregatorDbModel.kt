package com.evgenyrsk.feature.aggregator.data.local

/**
 * @author Evgeny Rasskazov
 */
data class AggregatorDbModel(
    val ticker: String,
    val isAvailableInTinkoff: Int
)
