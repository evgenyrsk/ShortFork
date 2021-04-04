package com.evgenyrsk.feature.aggregator.presentation

import com.evgenyrsk.core.presentation.mvi.UiEffect

/**
 * @author Evgeny Rasskazov
 */
sealed class AggregatorEffect : UiEffect {
    object ShowSnakeBar : AggregatorEffect()
    object ShowToast : AggregatorEffect()
}
