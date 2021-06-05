package com.evgenyrsk.feature.aggregator.presentation.indicators.model

/**
 * @author Evgeny Rasskazov
 */
data class IndicatorItem(
    val name: String,
    val value: Any? = null,
    val readableValue: String,
    val colouredValueIndicator: ColoredIndicator = ColoredIndicator.NEUTRAL
) {

    enum class ColoredIndicator {
        GOOD,
        NEUTRAL,
        BAD
    }
}
