package com.evgenyrsk.feature.aggregator.presentation

import com.evgenyrsk.core.presentation.mvi.UiEffect

/**
 * @author Evgeny Rasskazov
 */
internal sealed class AggregatorEffect : UiEffect {
    class ShowToast(val text: String) : AggregatorEffect()
}
