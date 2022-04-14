package com.evgenyrsk.feature.aggregator.presentation.indicators.model

import androidx.annotation.StringRes
import com.evgenyrsk.core.presentation.util.StringsProvider
import com.evgenyrsk.feature.aggregator.R
import com.evgenyrsk.feature.aggregator.domain.model.AggregatorDomainModel
import com.evgenyrsk.feature.aggregator.domain.model.MainCompanyInfoDomainModel
import com.evgenyrsk.feature.aggregator.domain.model.TechnicalIndicatorsDomainModel
import com.evgenyrsk.feature.aggregator.presentation.indicators.model.IndicatorItemHelper.determineColor
import com.evgenyrsk.feature.aggregator.presentation.indicators.recycler.*
import javax.inject.Inject

/**
 * @author Evgeny Rasskazov
 * Created on 14.12.2021
 */
internal class IndicatorsUiModelMapper @Inject constructor(
    private val stringsProvider: StringsProvider
) : (AggregatorDomainModel) -> IndicatorsUiModel {

    override fun invoke(domainModel: AggregatorDomainModel): IndicatorsUiModel =
        with(domainModel) {
            IndicatorsUiModel(
                companyInfo = mainCompanyInfo.toUi(),
                indicators = technicalIndicators.toIndicatorListItems()
            )
        }

    private fun MainCompanyInfoDomainModel.toUi(): CompanyInfoUiModel = CompanyInfoUiModel(
        ticker = ticker,
        name = name,
        siteUrl = siteUrl
    )

    // extract the business logic to domain entities
    private fun Double?.toIndicatorValue(
        color: IndicatorColor = IndicatorColor.DEFAULT,
        valueDecorator: Value.Decorator = Value.Decorator()
    ): Value = this?.let {
        NumberValue(
            value = it,
            color = color,
            decorator = valueDecorator
        )
    } ?: EmptyValue(color)

    private fun Boolean.toIndicatorValue(
        color: IndicatorColor = IndicatorColor.DEFAULT
    ): Value = BooleanValue(
        value = this,
        color = color
    )

    private fun TechnicalIndicatorsDomainModel.toIndicatorListItems(): List<IndicatorListItem> {
        val targetAndCurrentPriceDifference =
            priceInDollars?.let { currentPrice ->
                targetPriceUpside?.let { targetPrice ->
                    (targetPrice / currentPrice - 1.0) * 100.0
                    // TODO move this calculations to domain layer?
                }
            }
        return mutableListOf<IndicatorListItem>(
            IndicatorListItem(
                name = getString(R.string.indicator_price_net_income),
                value = pe.toIndicatorValue(
                    color = pe.determineColor(
                        bestValueRange = 0.0.rangeTo(15.0),
                        dangerValueRange = 25.0.rangeTo(Double.POSITIVE_INFINITY)
                    )
                ),
                hint = IndicatorHint(
                    title = getString(R.string.indicator_price_net_income_hint_title),
                    description = getString(R.string.indicator_price_net_income_hint_text)
                )
            ),
            IndicatorListItem(
                name = getString(R.string.indicator_forward_price_net_income),
                value = forwardPe.toIndicatorValue(
                    color = forwardPe.determineColor(
                        bestValueRange = 0.0.rangeTo(15.0),
                        dangerValueRange = 25.0.rangeTo(Double.POSITIVE_INFINITY)
                    )
                ),
                hint = IndicatorHint(
                    title = getString(R.string.indicator_forward_price_net_income_hint_title),
                    description = getString(R.string.indicator_forward_price_net_income_hint_text)
                )
            ),
            IndicatorListItem(
                name = getString(R.string.indicator_price_sales_ratio),
                value = ps.toIndicatorValue(
                    color = ps.determineColor(
                        bestValueRange = 0.0.rangeTo(1.0),
                        dangerValueRange = 3.0.rangeTo(Double.POSITIVE_INFINITY)
                    )
                ),
                hint = IndicatorHint(
                    title = getString(R.string.indicator_price_sales_ratio_hint_title),
                    description = getString(R.string.indicator_price_sales_ratio_hint_text)
                )
            ),
            IndicatorListItem(
                name = getString(R.string.indicator_price_book_ratio),
                value = pb.toIndicatorValue(
                    color = pb.determineColor(
                        bestValueRange = 0.0.rangeTo(1.0),
                        dangerValueRange = 4.0.rangeTo(Double.POSITIVE_INFINITY)
                    )
                ),
                hint = IndicatorHint(
                    title = getString(R.string.indicator_price_book_ratio_hint_title),
                    description = getString(R.string.indicator_price_book_ratio_hint_text)
                )
            ),
            IndicatorListItem(
                name = getString(R.string.indicator_price_to_earnings_growth),
                value = peg.toIndicatorValue(
                    color = peg.determineColor(
                        bestValueRange = 0.0.rangeTo(1.0),
                        dangerValueRange = 3.0.rangeTo(Double.POSITIVE_INFINITY)
                    )
                ),
                hint = IndicatorHint(
                    title = getString(R.string.indicator_price_net_income_hint_title),
                    description = getString(R.string.indicator_price_net_income_hint_text)
                )
            ),
            IndicatorListItem(
                name = getString(R.string.indicator_return_on_equity),
                value = roe.toIndicatorValue(
                    color = roe.determineColor(
                        bestValueRange = 0.0.rangeTo(40.0),
                        normalValueRange = 40.0.rangeTo(100.0),
                        dangerValueRange = Double.NEGATIVE_INFINITY.rangeTo(0.0)
                    ),
                    valueDecorator = Value.Decorator(postfix = "%")
                ),
                hint = IndicatorHint(
                    title = getString(R.string.indicator_return_on_equity_hint_title),
                    description = getString(R.string.indicator_return_on_equity_hint_text)
                )
            ),
            IndicatorListItem(
                name = getString(R.string.indicator_return_on_assets),
                value = roa.toIndicatorValue(
                    color = roa.determineColor(
                        bestValueRange = 0.0.rangeTo(100.0),
                        dangerValueRange = Double.NEGATIVE_INFINITY.rangeTo(0.0)
                    ),
                    valueDecorator = Value.Decorator(postfix = "%")
                ),
                hint = IndicatorHint(
                    title = getString(R.string.indicator_return_on_assets_hint_title),
                    description = getString(R.string.indicator_return_on_assets_hint_text)
                )
            ),
            IndicatorListItem(
                name = getString(R.string.indicator_debt_to_equity_ratio),
                value = debtEq.toIndicatorValue(
                    color = debtEq.determineColor(
                        bestValueRange = 0.0.rangeTo(0.4),
                        dangerValueRange = 1.0.rangeTo(Double.POSITIVE_INFINITY)
                    )
                ),
                hint = IndicatorHint(
                    title = getString(R.string.indicator_debt_to_equity_ratio_hint_title),
                    description = getString(R.string.indicator_debt_to_equity_ratio_hint_text)
                )
            ),
            IndicatorListItem(
                name = getString(R.string.indicator_inst_own),
                value = instOwn.toIndicatorValue(
                    valueDecorator = Value.Decorator(postfix = "%")
                ),
                hint = IndicatorHint(
                    title = getString(R.string.indicator_inst_own_hint_title),
                    description = getString(R.string.indicator_inst_own_hint_text)
                )
            ),
            IndicatorListItem(
                name = getString(R.string.indicator_insider_own),
                value = insiderOwn.toIndicatorValue(
                    valueDecorator = Value.Decorator(postfix = "%")
                ),
                hint = IndicatorHint(
                    title = getString(R.string.indicator_insider_own_hint_title),
                    description = getString(R.string.indicator_insider_own_hint_text)
                )
            ),
            IndicatorListItem(
                name = getString(R.string.indicator_price),
                value = priceInDollars.toIndicatorValue(
                    valueDecorator = Value.Decorator(prefix = "$")
                ),
                hint = IndicatorHint(
                    title = getString(R.string.indicator_price_hint_title),
                    description = getString(R.string.indicator_price_hint_text)
                )
            ),
            IndicatorListItem(
                name = getString(R.string.indicator_dividend),
                value = dividendsPercent.toIndicatorValue(
                    valueDecorator = Value.Decorator(postfix = "%")
                ),
                hint = IndicatorHint(
                    title = getString(R.string.indicator_dividend_hint_title),
                    description = getString(R.string.indicator_dividend_hint_text)
                )
            ),
            IndicatorListItem(
                name = getString(R.string.indicator_beta),
                value = beta.toIndicatorValue(),
                hint = IndicatorHint(
                    title = getString(R.string.indicator_beta_hint_title),
                    description = getString(R.string.indicator_beta_hint_text)
                )
            ),
            IndicatorListItem(
                name = getString(R.string.indicator_short_volume),
                value = tightShortVolume.toIndicatorValue(
                    valueDecorator = Value.Decorator(postfix = "%")
                ),
                hint = IndicatorHint(
                    title = getString(R.string.indicator_short_volume_hint_title),
                    description = getString(R.string.indicator_short_volume_hint_text)
                )
            ),
            IndicatorListItem(
                name = getString(R.string.indicator_squeeze_short_float),
                value = squeezeShortFloat.toIndicatorValue(
                    color = squeezeShortFloat.determineColor(
                        bestValueRange = 0.0.rangeTo(3.0),
                        dangerValueRange = 20.0.rangeTo(Double.POSITIVE_INFINITY)
                    ),
                    valueDecorator = Value.Decorator(postfix = "%")
                ),
                hint = IndicatorHint(
                    title = getString(R.string.indicator_squeeze_short_float_hint_title),
                    description = getString(R.string.indicator_squeeze_short_float_hint_text)
                )
            ),
            IndicatorListItem(
                name = getString(R.string.indicator_finviz_short_float),
                value = finVizShortFloat.toIndicatorValue(
                    color = finVizShortFloat.determineColor(
                        bestValueRange = 0.0.rangeTo(3.0),
                        dangerValueRange = 20.0.rangeTo(Double.POSITIVE_INFINITY)
                    ),
                    valueDecorator = Value.Decorator(postfix = "%")
                ),
                hint = IndicatorHint(
                    title = getString(R.string.indicator_finviz_short_float_hint_title),
                    description = getString(R.string.indicator_finviz_short_float_hint_text)
                )
            ),
            IndicatorListItem(
                name = getString(R.string.indicator_short_interest_ratio),
                value = shortInterestRatio.toIndicatorValue(
                    valueDecorator = Value.Decorator(postfix = " дн.")
                ),
                hint = IndicatorHint(
                    title = getString(R.string.indicator_short_interest_ratio_hint_title),
                    description = getString(R.string.indicator_short_interest_ratio_hint_text)
                )
            ),
            IndicatorListItem(
                name = getString(R.string.indicator_is_in_tinkoff),
                value = isAvailableOnTinkoff.toIndicatorValue(
                    color = isAvailableOnTinkoff.determineColor()
                ),
                hint = IndicatorHint(
                    title = getString(R.string.indicator_is_in_tinkoff_hint_title),
                    description = getString(R.string.indicator_is_in_tinkoff_hint_text)
                )
            ),
            IndicatorListItem(
                name = getString(R.string.indicator_target_price),
                value = targetAndCurrentPriceDifference.toIndicatorValue(
                    color = targetAndCurrentPriceDifference.determineColor(
                        bestValueRange = 0.0.rangeTo(Double.POSITIVE_INFINITY),
                        dangerValueRange = Double.NEGATIVE_INFINITY.rangeTo(0.0)
                    ),
                    valueDecorator = Value.Decorator(postfix = "%")
                ),
                hint = IndicatorHint(
                    title = getString(R.string.indicator_target_price_hint_title),
                    description = getString(R.string.indicator_target_price_hint_text)
                )
            ),
            IndicatorListItem(
                name = getString(R.string.indicator_relative_strength_index),
                value = rsi.toIndicatorValue(
                    color = rsi.determineColor(
                        bestValueRange = 0.0.rangeTo(30.0),
                        dangerValueRange = 70.0.rangeTo(Double.POSITIVE_INFINITY)
                    )
                ),
                hint = IndicatorHint(
                    title = getString(R.string.indicator_relative_strength_index_hint_title),
                    description = getString(R.string.indicator_relative_strength_index_hint_text)
                )
            )
        )
    }

    private fun getString(@StringRes id: Int) = stringsProvider.getString(id)
}