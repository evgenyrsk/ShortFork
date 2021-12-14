package com.evgenyrsk.feature.aggregator.presentation.indicators.model

/**
 * @author Evgeny Rasskazov
 */
data class IndicatorsUiModel(
    val companyInfo: CompanyInfoUiModel,
    val indicators: List<IndicatorListItem>
)

data class CompanyInfoUiModel(
    val ticker: String,
    val name: String?,
    val siteUrl: String?,
)
