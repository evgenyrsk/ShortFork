package com.evgenyrsk.feature.aggregator.di

import com.evgenyrsk.core.di.CoreComponentHolder
import com.evgenyrsk.core.presentation.util.StringsProvider

/**
 * @author Evgeny Rasskazov
 * Created on 14.12.2021
 */
interface AggregatorDependencies {

    fun stringsProvider(): StringsProvider
}

internal class AggregatorDependenciesImpl: AggregatorDependencies {

    override fun stringsProvider(): StringsProvider {
        return CoreComponentHolder.getComponent().stringsProvider()
    }

}