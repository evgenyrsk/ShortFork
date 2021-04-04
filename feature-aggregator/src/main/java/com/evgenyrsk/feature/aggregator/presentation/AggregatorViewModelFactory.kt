package com.evgenyrsk.feature.aggregator.presentation

import androidx.lifecycle.SavedStateHandle
import com.evgenyrsk.core.presentation.mvi.viewmodel.ViewModelAssistedFactory
import com.evgenyrsk.feature.aggregator.domain.GetShortDataUseCaseImpl
import javax.inject.Inject

/**
 * @author Evgeny Rasskazov
 */
class AggregatorViewModelFactory @Inject constructor(
    private val getShortDataUseCase: GetShortDataUseCaseImpl
) : ViewModelAssistedFactory<AggregatorViewModel> {

    override fun create(handle: SavedStateHandle): AggregatorViewModel {
        return AggregatorViewModel(getShortDataUseCase, handle)
    }
}
