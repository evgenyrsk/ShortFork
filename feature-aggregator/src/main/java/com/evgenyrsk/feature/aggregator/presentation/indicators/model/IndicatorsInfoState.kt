package com.evgenyrsk.feature.aggregator.presentation.indicators.model

/**
 * @author Evgeny Rasskazov
 */
internal sealed class IndicatorsInfoState {
    object Idle : IndicatorsInfoState()
    object Loading : IndicatorsInfoState()
    data class Loaded(val model: IndicatorsUiModel) : IndicatorsInfoState()
}