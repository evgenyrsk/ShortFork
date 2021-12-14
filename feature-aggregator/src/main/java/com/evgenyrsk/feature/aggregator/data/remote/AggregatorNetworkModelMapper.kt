package com.evgenyrsk.feature.aggregator.data.remote

import com.evgenyrsk.feature.aggregator.data.remote.model.AggregatorNetworkModel
import com.evgenyrsk.feature.aggregator.domain.model.AggregatorDomainModel
import com.evgenyrsk.feature.aggregator.domain.model.ChartDataDomainModel
import com.evgenyrsk.feature.aggregator.domain.model.MainCompanyInfoDomainModel
import com.evgenyrsk.feature.aggregator.domain.model.TechnicalIndicatorsDomainModel

/**
 * @author Evgeny Rasskazov
 */
fun AggregatorNetworkModel.toDomainModel(): AggregatorDomainModel {
    return AggregatorDomainModel(
        mainCompanyInfo = MainCompanyInfoDomainModel(
            ticker = ticker,
            name = finViz?.name,
            siteUrl = finViz?.site
        ),
        chartData = tightShort?.chart
            ?.first()
            ?.let { chart ->
                ChartDataDomainModel(
                    overallVolumes = chart.regularVolumes,
                    shortVolumes = chart.shortVolumes,
                    dates = chart.dates
                )
            },
        technicalIndicators = TechnicalIndicatorsDomainModel(
            pe = finViz?.pe,
            forwardPe = finViz?.forwardPe,
            ps = finViz?.ps,
            pb = finViz?.pb,
            peg = finViz?.peg,
            roe = finViz?.roe,
            roa = finViz?.roa,
            debtEq = finViz?.debtEq,
            instOwn = finViz?.instOwn,
            insiderOwn = finViz?.insiderOwn,
            priceInDollars = finViz?.price,
            dividendsPercent = finViz?.dividendPercent,
            beta = finViz?.beta,
            tightShortVolume = tightShort?.currentShortVolume,
            squeezeShortFloat = shortSqueeze?.shortFlow,
            finVizShortFloat = finViz?.shortFlow,
            shortInterestRatio = finViz?.shortRatio,
            isAvailableOnTinkoff = isAvailableInTinkoff ?: false,
            finVizRecommendation = finViz?.recommendation,
            targetPriceUpside = finViz?.targetPrice,
            rsi = finViz?.rsi
        )
    )
}