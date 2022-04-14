@file:Suppress("NonExhaustiveWhenStatementMigration")

package com.evgenyrsk.feature.aggregator.presentation.indicators

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.evgenyrsk.core.presentation.mvi.viewmodel.BaseViewModel
import com.evgenyrsk.feature.aggregator.presentation.indicators.model.IndicatorsEffect
import com.evgenyrsk.feature.aggregator.presentation.indicators.model.IndicatorsEvent
import com.evgenyrsk.feature.aggregator.presentation.indicators.model.IndicatorsInfoState
import com.evgenyrsk.feature.aggregator.presentation.indicators.model.IndicatorsState
import kotlinx.coroutines.launch

/**
 * @author Evgeny Rasskazov
 */
internal class IndicatorsViewModel(
    private val stateHandle: SavedStateHandle
) : BaseViewModel<IndicatorsEvent, IndicatorsState, IndicatorsEffect>() {

    override fun createInitialState(): IndicatorsState = IndicatorsState(IndicatorsInfoState.Idle)

    override fun handleEvent(event: IndicatorsEvent) {
        //when (event) {
            //is IndicatorsEvent.OnSubmitTickerButtonClicked ->
            //is IndicatorsEvent -> loadShortData(event.companyTicker)
        //}
    }

    private fun loadShortData(companyTicker: String) {
        viewModelScope.launch {
            setState { copy(indicatorsInfoState = IndicatorsInfoState.Loading) }
            //            when (val result = getShortDataUseCase.invoke(companyTicker)) {
            //                is Result.Success ->
            //                    setState {
            //                        copy(
            //                            shortInfoState = ShortInfoState.Loaded(
            //                                ShortInfoModel(result.data.mainCompanyInfo.ticker)
            //                            )
            //                        )
            //                    }
            //                is Result.Error -> {
            //                    setState { copy(shortInfoState = ShortInfoState.Idle) }
            //                    setEffect { IndicatorsEffect.ShowToast }
            //                }
            //            }
        }
    }
}
