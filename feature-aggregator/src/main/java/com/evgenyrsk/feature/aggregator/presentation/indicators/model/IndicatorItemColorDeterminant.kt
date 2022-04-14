package com.evgenyrsk.feature.aggregator.presentation.indicators.model

import com.evgenyrsk.feature.aggregator.presentation.indicators.recycler.IndicatorColor


/**
 * @author Evgeny Rasskazov
 * Created on 05.12.2021
 *
 * Determines a color for an item which is dependent on an indicator's value and its ranges.
 */
object IndicatorItemHelper {

    internal fun Double?.determineColor(
        bestValueRange: ClosedFloatingPointRange<Double>,
        dangerValueRange: ClosedFloatingPointRange<Double>,
        normalValueRange: ClosedFloatingPointRange<Double> =
            Double.MAX_VALUE.rangeTo(Double.MAX_VALUE)
    ): IndicatorColor {
        this ?: return IndicatorColor.DEFAULT
        return when (this) {
            in bestValueRange -> IndicatorColor.BEST
            in dangerValueRange -> IndicatorColor.DANGER
            in normalValueRange -> IndicatorColor.NORMAL
            else -> IndicatorColor.DEFAULT
        }
    }

    internal fun Boolean?.determineColor(): IndicatorColor {
        return if (this == true) {
            IndicatorColor.BEST
        } else {
            IndicatorColor.DANGER
        }
    }
}