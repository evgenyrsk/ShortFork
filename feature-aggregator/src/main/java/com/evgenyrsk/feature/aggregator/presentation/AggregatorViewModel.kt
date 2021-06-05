package com.evgenyrsk.feature.aggregator.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.evgenyrsk.core.presentation.mvi.viewmodel.BaseViewModel
import com.evgenyrsk.feature.aggregator.domain.GetShortDataUseCase
import com.evgenyrsk.feature.aggregator.domain.Result
import com.evgenyrsk.feature.aggregator.presentation.indicators.model.IndicatorsModelMapper
import kotlinx.coroutines.launch

/**
 * @author Evgeny Rasskazov
 */
class AggregatorViewModel(
    private val getShortDataUseCase: GetShortDataUseCase,
    private val savedStateHandle: SavedStateHandle
) : BaseViewModel<AggregatorEvent, AggregatorState, AggregatorEffect>() {

    private val mapper: IndicatorsModelMapper = IndicatorsModelMapper()

    override fun createInitialState(): AggregatorState = AggregatorState(IndicatorsInfoState.Idle)

    override fun handleEvent(event: AggregatorEvent) {
        when (event) {
            is AggregatorEvent.OnSubmitTickerButtonClicked -> loadShortData(event.companyTicker)
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
                                mapper.toUiModel(companyTicker, result.data.technicalIndicators)
                            )
                        )
                    }
                is Result.Error -> {
                    setState { copy(indicatorsInfoState = IndicatorsInfoState.Idle) }
                    setEffect { AggregatorEffect.ShowToast }
                }
            }
        }
    }
}
