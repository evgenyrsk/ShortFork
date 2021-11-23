package com.evgenyrsk.feature.aggregator.di.module

import com.evgenyrsk.core.presentation.mvi.viewmodel.ViewModelAssistedFactory
import com.evgenyrsk.feature.aggregator.presentation.AggregatorViewModel
import com.evgenyrsk.feature.aggregator.presentation.AggregatorViewModelFactory
import com.evgenyrsk.feature.aggregator.presentation.indicators.IndicatorsViewModel
import com.evgenyrsk.feature.aggregator.presentation.indicators.IndicatorsViewModelFactory
import dagger.Binds
import dagger.Module
import javax.inject.Qualifier

/**
 * @author Evgeny Rasskazov
 */
@Module
interface AggregatorViewModelModule {

//    @Binds
//    @Indicators
//    fun indicatorsViewModelFactory(
//        factory: IndicatorsViewModelFactory
//    ): ViewModelAssistedFactory<IndicatorsViewModel>

    @Binds
    fun aggregatorViewModelFactory(
        factory: AggregatorViewModelFactory
    ): ViewModelAssistedFactory<AggregatorViewModel>
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Aggregator

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Indicators
