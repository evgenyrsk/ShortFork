package com.evgenyrsk.feature.aggregator.di

import com.evgenyrsk.feature.aggregator.di.module.AggregatorDataModule
import com.evgenyrsk.feature.aggregator.di.module.AggregatorDomainModule
import com.evgenyrsk.feature.aggregator.di.module.AggregatorServiceModule
import com.evgenyrsk.feature.aggregator.di.module.AggregatorViewModelModule
import com.evgenyrsk.feature.aggregator.presentation.AggregatorActivity
import com.evgenyrsk.feature.aggregator.presentation.indicators.IndicatorsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AggregatorDataModule::class,
        AggregatorDomainModule::class,
        AggregatorServiceModule::class,
        AggregatorViewModelModule::class
    ]
)
internal interface AggregatorComponent {

    fun inject(activity: AggregatorActivity)

    fun inject(fragment: IndicatorsFragment)

    @Component.Factory
    interface Factory {
        fun create(): AggregatorComponent
    }
}