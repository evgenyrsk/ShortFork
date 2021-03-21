package com.evgenyrsk.feature.aggregator.di

import com.evgenyrsk.core.dagger.ComponentProvider
import javax.inject.Inject

/**
 * @author Evgeny Rasskazov
 */
class AggregatorComponentProvider @Inject constructor() : ComponentProvider<AggregatorComponent> {

    override fun get(): AggregatorComponent {
        return DaggerAggregatorComponent.builder().build()
    }
}
