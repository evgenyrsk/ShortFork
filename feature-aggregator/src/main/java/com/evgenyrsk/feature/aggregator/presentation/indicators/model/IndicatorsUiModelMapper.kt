package com.evgenyrsk.feature.aggregator.presentation.indicators.model

import androidx.annotation.StringRes
import com.evgenyrsk.core.presentation.util.StringsProvider
import com.evgenyrsk.feature.aggregator.R
import com.evgenyrsk.feature.aggregator.domain.model.AggregatorDomainModel
import com.evgenyrsk.feature.aggregator.domain.model.MainCompanyInfoDomainModel
import com.evgenyrsk.feature.aggregator.domain.model.TechnicalIndicatorsDomainModel
import com.evgenyrsk.feature.aggregator.presentation.indicators.model.IndicatorItemHelper.determineColor
import javax.inject.Inject

/**
 * @author Evgeny Rasskazov
 * Created on 14.12.2021
 */
class IndicatorsUiModelMapper @Inject constructor(
    private val stringsProvider: StringsProvider
) : (AggregatorDomainModel) -> IndicatorsUiModel {

    override fun invoke(domainModel: AggregatorDomainModel): IndicatorsUiModel =
        with(domainModel) {
            IndicatorsUiModel(
                companyInfo = mainCompanyInfo.toUi(),
                indicators = technicalIndicators.toIndicatorListItems()
            )
        }

    private fun MainCompanyInfoDomainModel.toUi(): CompanyInfoUiModel =
        CompanyInfoUiModel(
            ticker = ticker,
            name = name,
            siteUrl = siteUrl
        )

    private fun TechnicalIndicatorsDomainModel.toIndicatorListItems(): List<IndicatorListItem> {
        return mutableListOf<IndicatorListItem>().apply {
            add(
                IndicatorListItem(
                    name = getString(R.string.indicator_price_net_income),
                    value = pe,
                    readableValue = getHumanizedValue(pe),
                    color = pe.determineColor(
                        bestValueRange = 0.0.rangeTo(15.0),
                        dangerValueRange = 25.0.rangeTo(Double.POSITIVE_INFINITY)
                    ),
                    hint = IndicatorListItem.Hint(
                        title = getString(R.string.indicator_price_net_income_hint_title),
                        description = getString(R.string.indicator_price_net_income_hint_text)
                    )
                )
            )
            add(
                IndicatorListItem(
                    name = getString(R.string.indicator_forward_price_net_income),
                    value = forwardPe,
                    readableValue = getHumanizedValue(forwardPe),
                    color = forwardPe.determineColor(
                        bestValueRange = 0.0.rangeTo(15.0),
                        dangerValueRange = 25.0.rangeTo(Double.POSITIVE_INFINITY)
                    ),
                    hint = IndicatorListItem.Hint(
                        title = getString(R.string.indicator_forward_price_net_income_hint_title),
                        description = getString(R.string.indicator_forward_price_net_income_hint_text)
                    )
                )
            )
            add(
                IndicatorListItem(
                    name = getString(R.string.indicator_price_sales_ratio),
                    value = ps,
                    readableValue = getHumanizedValue(ps),
                    color = ps.determineColor(
                        bestValueRange = 0.0.rangeTo(1.0),
                        dangerValueRange = 3.0.rangeTo(Double.POSITIVE_INFINITY)
                    ),
                    hint = IndicatorListItem.Hint(
                        title = getString(R.string.indicator_price_sales_ratio_hint_title),
                        description = getString(R.string.indicator_price_sales_ratio_hint_text)
                    )
                )
            )
            add(
                IndicatorListItem(
                    name = getString(R.string.indicator_price_book_ratio),
                    value = pb,
                    readableValue = getHumanizedValue(pb),
                    color = pb.determineColor(
                        bestValueRange = 0.0.rangeTo(1.0),
                        dangerValueRange = 4.0.rangeTo(Double.POSITIVE_INFINITY)
                    ),
                    hint = IndicatorListItem.Hint(
                        title = getString(R.string.indicator_price_book_ratio_hint_title),
                        description = getString(R.string.indicator_price_book_ratio_hint_text)
                    )
                )
            )
            add(
                IndicatorListItem(
                    name = getString(R.string.indicator_price_to_earnings_growth),
                    value = peg,
                    readableValue = getHumanizedValue(peg),
                    color = peg.determineColor(
                        bestValueRange = 0.0.rangeTo(1.0),
                        dangerValueRange = 3.0.rangeTo(Double.POSITIVE_INFINITY)
                    ),
                    hint = IndicatorListItem.Hint(
                        title = getString(R.string.indicator_price_net_income_hint_title),
                        description = getString(R.string.indicator_price_net_income_hint_text)
                    )
                )
            )
            add(
                IndicatorListItem(
                    name = getString(R.string.indicator_return_on_equity),
                    value = roe,
                    readableValue = getHumanizedValue(
                        value = roe,
                        postfix = "%"
                    ),
                    color = roe.determineColor(
                        bestValueRange = 0.0.rangeTo(40.0),
                        normalValueRange = 40.0.rangeTo(100.0),
                        dangerValueRange = Double.NEGATIVE_INFINITY.rangeTo(0.0)
                    ),
                    hint = IndicatorListItem.Hint(
                        title = getString(R.string.indicator_return_on_equity_hint_title),
                        description = getString(R.string.indicator_return_on_equity_hint_text)
                    )
                )
            )
            add(
                IndicatorListItem(
                    name = getString(R.string.indicator_return_on_assets),
                    value = roa,
                    readableValue = getHumanizedValue(
                        value = roa,
                        postfix = "%"
                    ),
                    color = roa.determineColor(
                        bestValueRange = 0.0.rangeTo(100.0),
                        dangerValueRange = Double.NEGATIVE_INFINITY.rangeTo(0.0)
                    ),
                    hint = IndicatorListItem.Hint(
                        title = getString(R.string.indicator_return_on_assets_hint_title),
                        description = getString(R.string.indicator_return_on_assets_hint_text)
                    )
                )
            )
            add(
                IndicatorListItem(
                    name = getString(R.string.indicator_debt_to_equity_ratio),
                    value = debtEq,
                    readableValue = getHumanizedValue(debtEq),
                    color = debtEq.determineColor(
                        bestValueRange = 0.0.rangeTo(0.4),
                        dangerValueRange = 1.0.rangeTo(Double.POSITIVE_INFINITY)
                    ),
                    hint = IndicatorListItem.Hint(
                        title = getString(R.string.indicator_debt_to_equity_ratio_hint_title),
                        description = getString(R.string.indicator_debt_to_equity_ratio_hint_text)
                    )
                )
            )
            add(
                IndicatorListItem(
                    name = getString(R.string.indicator_inst_own),
                    value = instOwn,
                    readableValue = getHumanizedValue(
                        value = instOwn,
                        postfix = "%"
                    ),
                    hint = IndicatorListItem.Hint(
                        title = getString(R.string.indicator_inst_own_hint_title),
                        description = getString(R.string.indicator_inst_own_hint_text)
                    )
                )
            )
            add(
                IndicatorListItem(
                    name = getString(R.string.indicator_insider_own),
                    value = insiderOwn,
                    readableValue = getHumanizedValue(
                        value = insiderOwn,
                        postfix = "%"
                    ),
                    hint = IndicatorListItem.Hint(
                        title = getString(R.string.indicator_insider_own_hint_title),
                        description = getString(R.string.indicator_insider_own_hint_text)
                    )
                )
            )
            add(
                IndicatorListItem(
                    name = getString(R.string.indicator_price),
                    value = priceInDollars,
                    readableValue = getHumanizedValue(
                        value = priceInDollars,
                        prefix = "$"
                    ),
                    hint = IndicatorListItem.Hint(
                        title = getString(R.string.indicator_price_hint_title),
                        description = getString(R.string.indicator_price_hint_text)
                    )
                )
            )
            add(
                IndicatorListItem(
                    name = getString(R.string.indicator_dividend),
                    value = dividendsPercent,
                    readableValue = getHumanizedValue(
                        value = dividendsPercent,
                        postfix = "%"
                    ),
                    hint = IndicatorListItem.Hint(
                        title = getString(R.string.indicator_dividend_hint_title),
                        description = getString(R.string.indicator_dividend_hint_text)
                    )
                )
            )
            add(
                IndicatorListItem(
                    name = getString(R.string.indicator_beta),
                    value = beta,
                    readableValue = getHumanizedValue(beta),
                    hint = IndicatorListItem.Hint(
                        title = getString(R.string.indicator_beta_hint_title),
                        description = getString(R.string.indicator_beta_hint_text)
                    )
                )
            )
            add(
                IndicatorListItem(
                    name = getString(R.string.indicator_short_volume),
                    value = tightShortVolume,
                    readableValue = getHumanizedValue(
                        tightShortVolume,
                        postfix = "%"
                    ),
                    hint = IndicatorListItem.Hint(
                        title = getString(R.string.indicator_short_volume_hint_title),
                        description = getString(R.string.indicator_short_volume_hint_text)
                    )
                )
            )
            add(
                IndicatorListItem(
                    name = getString(R.string.indicator_squeeze_short_float),
                    value = squeezeShortFloat,
                    readableValue = getHumanizedValue(
                        squeezeShortFloat,
                        postfix = "%"
                    ),
                    color = squeezeShortFloat.determineColor(
                        bestValueRange = 0.0.rangeTo(3.0),
                        dangerValueRange = 20.0.rangeTo(Double.POSITIVE_INFINITY)
                    ),
                    hint = IndicatorListItem.Hint(
                        title = getString(R.string.indicator_squeeze_short_float_hint_title),
                        description = getString(R.string.indicator_squeeze_short_float_hint_text)
                    )
                )
            )
            add(
                IndicatorListItem(
                    name = getString(R.string.indicator_finviz_short_float),
                    value = finVizShortFloat,
                    readableValue = getHumanizedValue(
                        finVizShortFloat,
                        postfix = "%"
                    ),
                    color = finVizShortFloat.determineColor(
                        bestValueRange = 0.0.rangeTo(3.0),
                        dangerValueRange = 20.0.rangeTo(Double.POSITIVE_INFINITY)
                    ),
                    hint = IndicatorListItem.Hint(
                        title = getString(R.string.indicator_finviz_short_float_hint_title),
                        description = getString(R.string.indicator_finviz_short_float_hint_text)
                    )
                )
            )
            add(
                IndicatorListItem(
                    name = getString(R.string.indicator_short_interest_ratio),
                    value = shortInterestRatio,
                    readableValue = getHumanizedValue(
                        value = shortInterestRatio,
                        postfix = " дн."
                    ),
                    hint = IndicatorListItem.Hint(
                        title = getString(R.string.indicator_short_interest_ratio_hint_title),
                        description = getString(R.string.indicator_short_interest_ratio_hint_text)
                    )
                )
            )
            val targetAndCurrentPriceDifference =
                priceInDollars?.let { currentPrice ->
                    targetPriceUpside?.let { targetPrice ->
                        (targetPrice / currentPrice - 1.0) * 100.0
                        // TODO move this calculations to domain layer?
                    }
                }
            add(
                IndicatorListItem(
                    name = getString(R.string.indicator_is_in_tinkoff),
                    value = isAvailableOnTinkoff,
                    readableValue = getHumanizedValue(isAvailableOnTinkoff),
                    color = isAvailableOnTinkoff.determineColor(),
                    hint = IndicatorListItem.Hint(
                        title = getString(R.string.indicator_is_in_tinkoff_hint_title),
                        description = getString(R.string.indicator_is_in_tinkoff_hint_text)
                    )
                )
            )
            add(
                IndicatorListItem(
                    name = getString(R.string.indicator_target_price),
                    value = targetPriceUpside,
                    readableValue = getHumanizedValue(
                        value = targetAndCurrentPriceDifference,
                        postfix = "%"
                    ),
                    color = targetPriceUpside.determineColor(
                        bestValueRange = 0.0.rangeTo(Double.POSITIVE_INFINITY),
                        dangerValueRange = Double.NEGATIVE_INFINITY.rangeTo(0.0)
                    ),
                    hint = IndicatorListItem.Hint(
                        title = getString(R.string.indicator_target_price_hint_title),
                        description = getString(R.string.indicator_target_price_hint_text)
                    )
                )
            )
            add(
                IndicatorListItem(
                    name = getString(R.string.indicator_relative_strength_index),
                    value = rsi,
                    readableValue = getHumanizedValue(rsi),
                    color = rsi.determineColor(
                        bestValueRange = 0.0.rangeTo(30.0),
                        dangerValueRange = 70.0.rangeTo(Double.POSITIVE_INFINITY)
                    ),
                    hint = IndicatorListItem.Hint(
                        title = getString(R.string.indicator_relative_strength_index_hint_title),
                        description = getString(R.string.indicator_relative_strength_index_hint_text)
                    )
                )
            )
        }
    }

    private fun getHumanizedValue(
        value: Double?,
        prefix: String = "",
        postfix: String = ""
    ): String =
        value?.let {
            StringBuilder(prefix)
                .append(String.format("%.2f", it))
                .append(postfix)
                .toString()
        } ?: "-"

    private fun getHumanizedValue(value: Boolean): String = if (value) "Есть" else "Нет"

    private fun getString(@StringRes id: Int) = stringsProvider.getString(id)
}