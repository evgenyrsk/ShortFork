package com.evgenyrsk.feature.aggregator.presentation.indicators.model

import com.evgenyrsk.core.presentation.mvi.UiState

/**
 * @author Evgeny Rasskazov
 */
internal data class IndicatorsState(
    val indicatorsInfoState: IndicatorsInfoState
) : UiState
