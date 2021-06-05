package com.evgenyrsk.feature.aggregator.presentation.indicators.model

import com.evgenyrsk.core.presentation.mvi.UiEffect

/**
 * @author Evgeny Rasskazov
 */
sealed class IndicatorsEffect : UiEffect {
    object ShowSnakeBar : IndicatorsEffect()
    object ShowToast : IndicatorsEffect()
}
