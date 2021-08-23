package com.evgenyrsk.feature.aggregator.presentation

import com.evgenyrsk.core.presentation.mvi.UiState
import com.evgenyrsk.feature.aggregator.presentation.indicators.model.IndicatorsModel

/**
 * @author Evgeny Rasskazov
 */
data class AggregatorState(
    val indicatorsInfoState: IndicatorsInfoState
) : UiState

sealed class IndicatorsInfoState {
    object Idle : IndicatorsInfoState()
    object Loading : IndicatorsInfoState()
    data class Loaded(val model: IndicatorsModel) : IndicatorsInfoState()
}
