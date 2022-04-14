package com.evgenyrsk.feature.aggregator.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.evgenyrsk.core.presentation.mvi.viewmodel.BaseViewModel
import com.evgenyrsk.feature.aggregator.domain.GetShortDataUseCase
import com.evgenyrsk.feature.aggregator.domain.Result
import com.evgenyrsk.feature.aggregator.presentation.indicators.model.IndicatorsInfoState
import com.evgenyrsk.feature.aggregator.presentation.indicators.model.IndicatorsUiModelMapper
import kotlinx.coroutines.launch

/**
 * @author Evgeny Rasskazov
 */
internal class AggregatorViewModel(
    private val getShortDataUseCase: GetShortDataUseCase,
    private val savedStateHandle: SavedStateHandle,
    private val mapToUiModel: IndicatorsUiModelMapper
) : BaseViewModel<AggregatorEvent, AggregatorState, AggregatorEffect>() {

    override fun createInitialState(): AggregatorState = AggregatorState(IndicatorsInfoState.Idle)

    override fun handleEvent(event: AggregatorEvent) {
        when (event) {
            is AggregatorEvent.OnSubmitTickerButtonClicked -> loadShortData(event.companyTicker)
            is AggregatorEvent.OnIndicatorItemClicked -> setEffect {
                AggregatorEffect.ShowToast(
                    event.hint.description
                )
            }
        }
    }

    private fun loadShortData(companyTicker: String) {
        viewModelScope.launch {
            setState { copy(indicatorsInfoState = IndicatorsInfoState.Loading) }
            when (val result = getShortDataUseCase.invoke(companyTicker)) {
                is Result.Success ->
                    setState {
                        copy(
                            indicatorsInfoState = IndicatorsInfoState.Loaded(
                                mapToUiModel(result.data)
                            )
                        )
                    }
                is Result.Error -> {
                    setState { copy(indicatorsInfoState = IndicatorsInfoState.Idle) }
                    setEffect { AggregatorEffect.ShowToast(result.exception.toString()) }
                }
            }
        }
    }
}
