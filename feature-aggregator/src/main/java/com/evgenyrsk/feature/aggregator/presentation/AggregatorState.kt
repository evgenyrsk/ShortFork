package com.evgenyrsk.feature.aggregator.presentation

import com.evgenyrsk.core.presentation.mvi.UiState
import com.evgenyrsk.feature.aggregator.presentation.model.ShortInfoModel

/**
 * @author Evgeny Rasskazov
 */
data class AggregatorState(
    val shortInfoState: ShortInfoState
) : UiState

sealed class ShortInfoState {
    object Idle : ShortInfoState()
    object Loading : ShortInfoState()
    data class Loaded(val model: ShortInfoModel) : ShortInfoState()
}
