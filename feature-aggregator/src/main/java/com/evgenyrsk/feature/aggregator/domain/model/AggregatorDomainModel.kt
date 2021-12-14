package com.evgenyrsk.feature.aggregator.domain.model

/**
 * @author Evgeny Rasskazov
 */
data class AggregatorDomainModel(
    val mainCompanyInfo: MainCompanyInfoDomainModel,
    val chartData: ChartDataDomainModel? = null,
    val technicalIndicators: TechnicalIndicatorsDomainModel
)
