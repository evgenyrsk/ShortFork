package com.evgenyrsk.feature.aggregator.presentation.indicators.model

import com.evgenyrsk.feature.aggregator.R

/**
 * @author Evgeny Rasskazov
 */
data class IndicatorItem(
    val name: String,
    val value: Any? = null,
    val readableValue: String,
    val colouredValueIndicator: Color = Color.NEUTRAL
) {

    enum class Color(val colorCode: Int) {
        GOOD(R.color.light_green_500),
        NEUTRAL(R.color.blue_700),
        BAD(R.color.red_b00020)
    }
}
