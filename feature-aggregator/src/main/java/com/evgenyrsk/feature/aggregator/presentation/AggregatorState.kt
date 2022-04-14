package com.evgenyrsk.feature.aggregator.presentation

import com.evgenyrsk.core.presentation.mvi.UiState
import com.evgenyrsk.feature.aggregator.presentation.indicators.model.IndicatorsInfoState

/**
 * @author Evgeny Rasskazov
 */
internal data class AggregatorState(
    val indicatorsInfoState: IndicatorsInfoState
) : UiState


