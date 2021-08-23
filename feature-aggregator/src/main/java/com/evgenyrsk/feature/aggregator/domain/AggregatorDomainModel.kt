package com.evgenyrsk.feature.aggregator.domain

/**
 * @author Evgeny Rasskazov
 */
data class AggregatorDomainModel(
    val mainCompanyInfo: MainCompanyInfo,
    val chartData: ChartData? = null,
    val technicalIndicators: TechnicalIndicators
) {

    data class MainCompanyInfo(
        val ticker: String,
        val name: String,
        val siteUrl: String
    )

    data class ChartData(
        val overallVolumes: List<Int>,
        val shortVolumes: List<Int>,
        val dates: List<String>
    )

    data class TechnicalIndicators(
        val priceInDollars: Double?,
        val pe: Double?,
        val ps: Double?,
        val pb: Double?,
        val peg: Double?,
        val roe: Double?,
        val roa: Double?,
        val debtEq: Double?,
        val dividendsPercent: Double?,
        val currentNakedShortVolume: Double?,
        val squeezeShortFloat: Double?,
        val finVizShortFloat: Double?,
        val isAvailableOnTinkoff: Boolean,
        val targetPriceUpside: Double?,
        val rsi: Double?,
        val finVizRecommendation: Double?
    )
}
