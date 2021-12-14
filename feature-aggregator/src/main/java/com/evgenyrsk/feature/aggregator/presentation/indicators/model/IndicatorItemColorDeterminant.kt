package com.evgenyrsk.feature.aggregator.presentation.indicators.model


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
    ): IndicatorListItem.Color {
        this ?: return IndicatorListItem.Color.DEFAULT
        return when (this) {
            in bestValueRange -> IndicatorListItem.Color.BEST
            in dangerValueRange -> IndicatorListItem.Color.DANGER
            in normalValueRange -> IndicatorListItem.Color.NORMAL
            else -> IndicatorListItem.Color.DEFAULT
        }
    }

    internal fun Boolean?.determineColor(): IndicatorListItem.Color {
        return if (this == true) {
            IndicatorListItem.Color.BEST
        } else {
            IndicatorListItem.Color.DANGER
        }
    }
}

abstract class IndicatorItemColorDeterminant(
    private val bestValueRange: ClosedFloatingPointRange<Double>,
    private val dangerValueRange: ClosedFloatingPointRange<Double>,
    private val normalValueRange: ClosedFloatingPointRange<Double> =
        Double.MAX_VALUE.rangeTo(Double.MAX_VALUE)
) {

    fun determineColor(indicatorValue: Double): IndicatorListItem.Color {
        return when (indicatorValue) {
            in bestValueRange -> IndicatorListItem.Color.BEST
            in dangerValueRange -> IndicatorListItem.Color.DANGER
            in normalValueRange -> IndicatorListItem.Color.NORMAL
            else -> IndicatorListItem.Color.DEFAULT
        }
    }
}