package com.evgenyrsk.feature.aggregator.presentation

import com.evgenyrsk.core.presentation.mvi.UiEvent

/**
 * @author Evgeny Rasskazov
 */
sealed class AggregatorEvent : UiEvent {
    class OnShowButtonClicked(val companyTicker: String) : AggregatorEvent()
}
