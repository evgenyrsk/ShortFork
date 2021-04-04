package com.evgenyrsk.feature.aggregator.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.evgenyrsk.core.presentation.mvi.viewmodel.BaseViewModel
import com.evgenyrsk.feature.aggregator.domain.GetShortDataUseCaseImpl
import com.evgenyrsk.feature.aggregator.domain.Result
import com.evgenyrsk.feature.aggregator.presentation.model.ShortInfoModel
import kotlinx.coroutines.launch

/**
 * @author Evgeny Rasskazov
 */
class AggregatorViewModel(
    private val getShortDataUseCase: GetShortDataUseCaseImpl,
    private val savedStateHandle: SavedStateHandle
) : BaseViewModel<AggregatorEvent, AggregatorState, AggregatorEffect>() {

    override fun createInitialState(): AggregatorState = AggregatorState(ShortInfoState.Idle)

    override fun handleEvent(event: AggregatorEvent) {
        when (event) {
            is AggregatorEvent.OnShowButtonClicked -> loadShortData(event.companyTicker)
        }
    }

    private fun loadShortData(companyTicker: String) {
        viewModelScope.launch {
            setState { copy(shortInfoState = ShortInfoState.Loading) }
            when (val result = getShortDataUseCase(companyTicker)) {
                is Result.Success ->
                    setState {
                        copy(
                            shortInfoState = ShortInfoState.Loaded(
                                ShortInfoModel(result.data.mainCompanyInfo.ticker)
                            )
                        )
                    }
                is Result.Error -> {
                    setState { copy(shortInfoState = ShortInfoState.Idle) }
                    setEffect { AggregatorEffect.ShowToast }
                }
            }
        }
    }
}
