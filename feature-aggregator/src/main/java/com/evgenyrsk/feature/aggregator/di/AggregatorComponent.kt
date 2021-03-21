package com.evgenyrsk.feature.aggregator.di

import com.evgenyrsk.core.dagger.FeatureScope
import com.evgenyrsk.feature.aggregator.presentation.AggregatorFragment
import dagger.Component

/**
 * @author Evgeny Rasskazov
 */
@FeatureScope
@Component(
    modules = [
        AggregatorRepositoryModule::class,
        AggregatorDataSourceModule::class,
        AggregatorServiceModule::class,
        AggregatorViewModelModule::class
    ],
    dependencies = [
        AggregatorDependencies::class
    ]
)
interface AggregatorComponent {

    fun inject(fragment: AggregatorFragment)
}
