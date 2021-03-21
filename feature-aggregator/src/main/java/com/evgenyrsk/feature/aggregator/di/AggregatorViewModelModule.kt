package com.evgenyrsk.feature.aggregator.di

import com.evgenyrsk.core.presentation.mvi.viewmodel.ViewModelAssistedFactory
import com.evgenyrsk.feature.aggregator.presentation.AggregatorViewModel
import com.evgenyrsk.feature.aggregator.presentation.AggregatorViewModelFactory
import dagger.Binds
import dagger.Module

/**
 * @author Evgeny Rasskazov
 */
@Module
interface AggregatorViewModelModule {

    @Binds
    fun bindViewModelFactory(
        viewModelFactory: AggregatorViewModelFactory
    ): ViewModelAssistedFactory<AggregatorViewModel>
}
