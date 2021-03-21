package com.evgenyrsk.feature.aggregator.di

import androidx.annotation.MainThread

/**
 * @author Evgeny Rasskazov
 */
object AggregatorComponentHolder {

    private var component: AggregatorComponent? = null

    fun init(dependencies: AggregatorDependencies) {
        component ?: build(dependencies).also { component = it }
    }

    fun build(dependencies: AggregatorDependencies): AggregatorComponent = DaggerAggregatorComponent.builder()
        .aggregatorDependencies(dependencies)
        .build()

    @MainThread
    fun get(): AggregatorComponent {
        return requireNotNull(component) { "Component \"$component\" has not been not found" }
    }

    @MainThread
    fun clear() {
        component = null
    }
}
