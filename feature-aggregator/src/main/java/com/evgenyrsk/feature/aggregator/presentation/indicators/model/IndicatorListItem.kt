package com.evgenyrsk.feature.aggregator.presentation.indicators.model

import com.evgenyrsk.feature.aggregator.R

/**
 * @author Evgeny Rasskazov
 */
data class IndicatorListItem(
    val name: String,
    val value: Any? = null,
    val readableValue: String,
    val color: Color = Color.DEFAULT,
    val hint: Hint
) {

    enum class Color(val colorCode: Int) {
        BEST(R.color.light_green_500),
        NORMAL(R.color.blue_700),
        DANGER(R.color.red_b00020),
        DEFAULT(R.color.blue_100)
    }

    class Hint(
        val title: String,
        val description: String
    )
}
