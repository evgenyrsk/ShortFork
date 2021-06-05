package com.evgenyrsk.feature.aggregator.presentation.indicators.model

import com.evgenyrsk.core.presentation.mvi.UiState
import com.evgenyrsk.feature.aggregator.presentation.IndicatorsInfoState

/**
 * @author Evgeny Rasskazov
 */
data class IndicatorsState(
    val indicatorsInfoState: IndicatorsInfoState
) : UiState
