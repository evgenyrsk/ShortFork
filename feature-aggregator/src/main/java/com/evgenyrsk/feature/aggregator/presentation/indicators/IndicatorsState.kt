package com.evgenyrsk.feature.aggregator.presentation.indicators

import com.evgenyrsk.core.presentation.mvi.UiState
import com.evgenyrsk.feature.aggregator.presentation.ShortInfoState

/**
 * @author Evgeny Rasskazov
 */
data class IndicatorsState(
    val shortInfoState: ShortInfoState
) : UiState
