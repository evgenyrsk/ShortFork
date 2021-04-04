package com.evgenyrsk.feature.aggregator.domain

import com.evgenyrsk.feature.aggregator.data.AggregatorApiModel

/**
 * @author Evgeny Rasskazov
 */
class AggregatorModelMapper {

    fun toDomainModel(
        apiModel: AggregatorApiModel
    ): AggregatorDomainModel = with(apiModel) {
        AggregatorDomainModel(
            mainCompanyInfo = AggregatorDomainModel.MainCompanyInfo(
                ticker = ticker,
                name = name,
                siteUrl = siteUrl
            ),
            chartData = AggregatorDomainModel.ChartData(
                overallVolumes = nakedChart.regularVolumes,
                shortVolumes = nakedChart.shortVolumes,
                dates = nakedChart.dates
            ),
            technicalIndicators = AggregatorDomainModel.TechnicalIndicators(
                priceInDollars = price,
                pe = pe,
                ps = ps,
                pb = pb,
                roe = roe,
                rsi = rsi,
                debtEq = debtEq,
                currentNakedShortVolume = nakedCurrentShortVolume,
                squeezeShortFloat = squeezeShortFloat,
                finVizShortFloat = finVizShortFloat,
                finVizRecommendation = finVizRecommendation,
                isAvailableOnTinkoff = isAvailableOnTinkoff,
                targetPriceUpside = targetPrice
            )
        )
    }
}
