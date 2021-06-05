package com.evgenyrsk.feature.aggregator.presentation.indicators.model

import com.evgenyrsk.core.presentation.mvi.UiEvent

/**
 * @author Evgeny Rasskazov
 */
sealed class IndicatorsEvent : UiEvent {
    class OnSubmitTickerButtonClicked(val companyTicker: String) : IndicatorsEvent()
}
