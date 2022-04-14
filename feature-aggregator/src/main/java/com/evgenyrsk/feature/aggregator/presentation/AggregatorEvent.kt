package com.evgenyrsk.feature.aggregator.presentation

import com.evgenyrsk.core.presentation.mvi.UiEvent
import com.evgenyrsk.feature.aggregator.presentation.indicators.recycler.IndicatorHint

/**
 * @author Evgeny Rasskazov
 */
internal sealed class AggregatorEvent : UiEvent {
    class OnSubmitTickerButtonClicked(val companyTicker: String) : AggregatorEvent()
    class OnIndicatorItemClicked(val hint: IndicatorHint) : AggregatorEvent()
}
