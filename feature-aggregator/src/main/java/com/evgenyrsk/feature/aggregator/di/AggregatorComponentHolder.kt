package com.evgenyrsk.feature.aggregator.di

/**
 * @author Evgeny Rasskazov
 * Created on 14.12.2021
 */
internal object AggregatorComponentHolder {

    private val componentInstance: AggregatorComponent by lazy {
        DaggerAggregatorComponent.factory()
            .create(AggregatorDependenciesImpl())
    }

    fun getComponent(): AggregatorComponent = componentInstance
}