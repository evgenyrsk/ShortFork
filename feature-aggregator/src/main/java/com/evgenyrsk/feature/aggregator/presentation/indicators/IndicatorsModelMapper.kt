package com.evgenyrsk.feature.aggregator.presentation.indicators

import com.evgenyrsk.feature.aggregator.domain.AggregatorDomainModel
import com.evgenyrsk.feature.aggregator.presentation.model.IndicatorsModel

/**
 * @author Evgeny Rasskazov
 */
class IndicatorsModelMapper {

    fun toUiModel(ticker: String, domainModel: AggregatorDomainModel.TechnicalIndicators): IndicatorsModel {
        return with(domainModel) {
            IndicatorsModel(
                ticker = ticker,
                pe = pe,
                forwardPE = null,
                ps = ps,
                pb = pb,
                peg = peg,
                roe = roe,
                roa = roa,
                debtEq = debtEq,
                marketPrice = priceInDollars,
                dividends = dividendsPercent,
                shortVolumeFromTightShort = null,
                shortFloatFromShortSqueeze = squeezeShortFloat,
                shortFloatFromFinViz = finVizShortFloat,
                isAvailableOnTinkoff = isAvailableOnTinkoff,
                targetPrice = targetPriceUpside,
                rsi = rsi
            )
        }
    }
}
