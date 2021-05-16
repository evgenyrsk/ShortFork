package com.evgenyrsk.feature.aggregator.domain

import com.evgenyrsk.feature.aggregator.data.NetworkModel

/**
 * @author Evgeny Rasskazov
 */
class AggregatorModelMapper {

    fun toDomainModel(networkModel: NetworkModel): AggregatorDomainModel = with(networkModel) {
        AggregatorDomainModel(
            mainCompanyInfo = AggregatorDomainModel.MainCompanyInfo(
                ticker = ticker,
                name = finViz.name,
                siteUrl = finViz.site
            ),
            chartData = with(nakedShort.chart.first()) {
                AggregatorDomainModel.ChartData(
                    overallVolumes = regularVolumes,
                    shortVolumes = shortVolumes,
                    dates = dates
                )
            },
            technicalIndicators = AggregatorDomainModel.TechnicalIndicators(
                priceInDollars = finViz.price,
                pe = finViz.pe,
                ps = finViz.ps,
                pb = finViz.pb,
                roe = finViz.roe,
                rsi = finViz.rsi,
                debtEq = finViz.debtEq,
                currentNakedShortVolume = nakedShort.currentShortVolume,
                squeezeShortFloat = shortSqueeze.shortFlow,
                finVizShortFloat = finViz.shortFlow,
                finVizRecommendation = finViz.recommendation,
                isAvailableOnTinkoff = isAvailableInTinkoff,
                targetPriceUpside = finViz.targetPrice
            )
        )
    }
}
