package com.evgenyrsk.feature.aggregator.di

import com.evgenyrsk.core.dagger.FeatureScope
import com.evgenyrsk.feature.aggregator.di.module.AggregatorDataModule
import com.evgenyrsk.feature.aggregator.di.module.AggregatorDomainModule
import com.evgenyrsk.feature.aggregator.di.module.AggregatorServiceModule
import com.evgenyrsk.feature.aggregator.di.module.AggregatorViewModelModule
import com.evgenyrsk.feature.aggregator.presentation.AggregatorActivity
import com.evgenyrsk.feature.aggregator.presentation.indicators.IndicatorsFragment
import dagger.Component

/**
 * @author Evgeny Rasskazov
 */
@FeatureScope
@Component(
    modules = [
        AggregatorDataModule::class,
        AggregatorServiceModule::class,
        AggregatorDomainModule::class,
        AggregatorViewModelModule::class
    ],
    dependencies = [
        AggregatorDependencies::class
    ]
)
interface AggregatorComponent {

    fun inject(activity: AggregatorActivity)

    fun inject(fragment: IndicatorsFragment)
}
