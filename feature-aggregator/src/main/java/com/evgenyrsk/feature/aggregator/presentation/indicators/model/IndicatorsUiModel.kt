package com.evgenyrsk.feature.aggregator.presentation.indicators.model

import com.evgenyrsk.feature.aggregator.presentation.indicators.recycler.IndicatorListItem

/**
 * @author Evgeny Rasskazov
 */
internal data class IndicatorsUiModel(
    val companyInfo: CompanyInfoUiModel,
    val indicators: List<IndicatorListItem>
)

internal data class CompanyInfoUiModel(
    val ticker: String,
    val name: String?,
    val siteUrl: String?,
)
