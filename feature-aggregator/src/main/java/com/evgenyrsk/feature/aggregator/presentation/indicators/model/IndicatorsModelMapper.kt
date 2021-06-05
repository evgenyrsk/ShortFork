package com.evgenyrsk.feature.aggregator.presentation.indicators.model

import com.evgenyrsk.feature.aggregator.domain.AggregatorDomainModel
import com.evgenyrsk.feature.aggregator.presentation.model.IndicatorsModel

/**
 * @author Evgeny Rasskazov
 */
class IndicatorsModelMapper {

    fun toUiModel(ticker: String, domainModel: AggregatorDomainModel.TechnicalIndicators): IndicatorsModel {
        return IndicatorsModel(ticker, toIndicatorItems(domainModel))
    }

    private fun toIndicatorItems(domainModel: AggregatorDomainModel.TechnicalIndicators): List<IndicatorItem> {
        val itemsList = mutableListOf<IndicatorItem>()
        with(domainModel) {
            itemsList.add(IndicatorItem(name = "P/E", value = pe, readableValue = getReadableValueOf(pe)))
            itemsList.add(IndicatorItem(name = "Forward P/E", value = null, readableValue = "-"))
            itemsList.add(IndicatorItem(name = "P/S", value = ps, readableValue = getReadableValueOf(ps)))
            itemsList.add(IndicatorItem(name = "P/B", value = pb, readableValue = getReadableValueOf(pb)))
            itemsList.add(IndicatorItem(name = "PEG", value = peg, readableValue = getReadableValueOf(peg)))
            itemsList.add(
                IndicatorItem(
                    name = "ROE",
                    value = roe,
                    readableValue = getReadableValueOf(roe, postfix = "%")
                )
            )
            itemsList.add(
                IndicatorItem(
                    name = "ROA",
                    value = roa,
                    readableValue = getReadableValueOf(roa, postfix = "%")
                )
            )
            itemsList.add(IndicatorItem(name = "Debt / Eq", value = debtEq, readableValue = getReadableValueOf(debtEq)))
            itemsList.add(
                IndicatorItem(
                    name = "Price",
                    value = priceInDollars,
                    readableValue = getReadableValueOf(priceInDollars, prefix = "$")
                )
            )
            itemsList.add(
                IndicatorItem(
                    name = "Dividend",
                    value = dividendsPercent,
                    readableValue = getReadableValueOf(dividendsPercent, postfix = "%")
                )
            )
            itemsList.add(
                IndicatorItem(
                    name = "Short Vol T",
                    value = currentNakedShortVolume,
                    readableValue = getReadableValueOf(currentNakedShortVolume, postfix = "%")
                )
            )
            itemsList.add(
                IndicatorItem(
                    name = "Short Float S",
                    value = squeezeShortFloat,
                    readableValue = getReadableValueOf(squeezeShortFloat, postfix = "%")
                )
            )
            itemsList.add(
                IndicatorItem(
                    name = "Short Float F",
                    value = finVizShortFloat,
                    readableValue = getReadableValueOf(finVizShortFloat, postfix = "%")
                )
            )
            itemsList.add(
                IndicatorItem(
                    name = "Tinkoff Investments",
                    value = isAvailableOnTinkoff,
                    readableValue = getReadableValueOf(isAvailableOnTinkoff)
                )
            )
            itemsList.add(
                IndicatorItem(
                    name = "Target",
                    value = targetPriceUpside,
                    readableValue = getReadableValueOf(targetPriceUpside, postfix = "%")
                )
            )
            itemsList.add(IndicatorItem(name = "RSI (14 days)", value = rsi, readableValue = getReadableValueOf(rsi)))
        }
        return itemsList
    }

    private fun getReadableValueOf(value: Double?, prefix: String = "", postfix: String = ""): String =
        value?.let {
            StringBuilder(prefix)
                .append(it.toString())
                .append(postfix)
                .toString()
        } ?: "-"

    private fun getReadableValueOf(value: Boolean): String = if (value) "ON" else "OFF"
}
