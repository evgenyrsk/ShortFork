package com.evgenyrsk.feature.aggregator.presentation.indicators.recycler

import com.evgenyrsk.feature.aggregator.R

/**
 * @author Evgeny Rasskazov
 */
internal enum class IndicatorColor(val code: Int) {
    BEST(R.color.light_green_500),
    NORMAL(R.color.blue_700),
    DANGER(R.color.red_b00020),
    DEFAULT(R.color.text_primary)
}