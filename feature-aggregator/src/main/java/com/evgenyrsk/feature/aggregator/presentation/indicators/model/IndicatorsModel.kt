package com.evgenyrsk.feature.aggregator.presentation.indicators.model

/**
 * @author Evgeny Rasskazov
 */
data class IndicatorsModel(
    val ticker: String,
    val companyName: String,
    val companySiteUrl: String,
    val indicators: List<IndicatorItem>
)
