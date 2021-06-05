package com.evgenyrsk.feature.aggregator.data

import com.evgenyrsk.feature.aggregator.domain.AggregatorDomainModel
import com.evgenyrsk.feature.aggregator.domain.AggregatorDomainModelMapper

/**
 * @author Evgeny Rasskazov
 */
class AggregatorDomainModelMapperImpl : AggregatorDomainModelMapper<NetworkModel> {

    override fun map(networkModel: NetworkModel): AggregatorDomainModel = with(networkModel) {
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
                peg = finViz.peg,
                roe = finViz.roe,
                roa = finViz.roa,
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
