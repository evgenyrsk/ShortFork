package com.evgenyrsk.feature.aggregator.presentation

import androidx.lifecycle.SavedStateHandle
import com.evgenyrsk.core.presentation.mvi.viewmodel.ViewModelAssistedFactory
import com.evgenyrsk.feature.aggregator.domain.GetShortDataUseCase
import com.evgenyrsk.feature.aggregator.presentation.indicators.model.IndicatorsUiModelMapper
import javax.inject.Inject

/**
 * @author Evgeny Rasskazov
 */
class AggregatorViewModelFactory @Inject constructor(
    private val getShortDataUseCase: GetShortDataUseCase,
    private val mapToUiModel: IndicatorsUiModelMapper
) : ViewModelAssistedFactory<AggregatorViewModel> {

    override fun create(handle: SavedStateHandle): AggregatorViewModel =
        AggregatorViewModel(getShortDataUseCase, handle, mapToUiModel)
}
