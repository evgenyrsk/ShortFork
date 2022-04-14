package com.evgenyrsk.feature.aggregator.presentation.indicators

import androidx.lifecycle.SavedStateHandle
import com.evgenyrsk.core.presentation.mvi.viewmodel.ViewModelAssistedFactory
import javax.inject.Inject

/**
 * @author Evgeny Rasskazov
 */
internal class IndicatorsViewModelFactory @Inject constructor() : ViewModelAssistedFactory<IndicatorsViewModel> {

    override fun create(handle: SavedStateHandle): IndicatorsViewModel = IndicatorsViewModel(handle)
}
