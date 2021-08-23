package com.evgenyrsk.feature.aggregator.presentation.indicators.model

import com.evgenyrsk.feature.aggregator.domain.AggregatorDomainModel

/**
 * @author Evgeny Rasskazov
 */
// TODO rewrite mappers as objects with extension functions
class IndicatorsModelMapper {

    fun toUiModel(
        ticker: String,
        mainCompanyInfo: AggregatorDomainModel.MainCompanyInfo,
        domainModel: AggregatorDomainModel.TechnicalIndicators
    ): IndicatorsModel {
        return IndicatorsModel(
            ticker = ticker,
            companyName = mainCompanyInfo.name,
            companySiteUrl = mainCompanyInfo.siteUrl,
            indicators = toIndicatorItems(domainModel)
        )
    }

    private fun toIndicatorItems(domainModel: AggregatorDomainModel.TechnicalIndicators): List<IndicatorItem> {
        val itemsList = mutableListOf<IndicatorItem>()
        with(domainModel) {
            itemsList.add(
                IndicatorItem(
                    name = "P/E",
                    value = pe,
                    readableValue = getReadableValueOf(pe),
                    colouredValueIndicator = getColorForIndicatorValue(pe)
                )
            )
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

            val targetAndCurrentPriceDifference = priceInDollars?.let { currentPrice ->
                targetPriceUpside?.let { targetPrice ->
                    (targetPrice / currentPrice - 1.0) * 100.0
                    // TODO move this calculations to domain mapper?
                }
            }
            itemsList.add(
                IndicatorItem(
                    name = "Target Price Upside",
                    value = targetPriceUpside,
                    readableValue = getReadableValueOf(targetAndCurrentPriceDifference, postfix = "%")
                )
            )
            itemsList.add(IndicatorItem(name = "RSI (14 days)", value = rsi, readableValue = getReadableValueOf(rsi)))
        }
        return itemsList
    }

    private fun getReadableValueOf(value: Double?, prefix: String = "", postfix: String = ""): String =
        value?.let {
            StringBuilder(prefix)
                .append(String.format("%.2f", it))
                .append(postfix)
                .toString()
        } ?: "-"

    private fun getReadableValueOf(value: Boolean): String = if (value) "ON" else "OFF"

    private fun getColorForIndicatorValue(value: Double?): IndicatorItem.Color {
        return value?.let {
            when {
                it < 0.0 -> IndicatorItem.Color.BAD
                it in 0.0..20.0 -> IndicatorItem.Color.NEUTRAL
                else -> IndicatorItem.Color.GOOD
            }
        } ?: IndicatorItem.Color.NEUTRAL
    }
}
