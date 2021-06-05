package com.evgenyrsk.feature.aggregator.presentation.model

import com.evgenyrsk.feature.aggregator.presentation.indicators.model.IndicatorItem

/**
 * @author Evgeny Rasskazov
 */
data class IndicatorsModel(
    val ticker: String,
    val indicators: List<IndicatorItem>
)
