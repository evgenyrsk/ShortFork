package com.evgenyrsk.nakedshort.di

import com.evgenyrsk.nakedshort.domain.NakedShortRepository
import dagger.Component

/**
 * @author Evgeny Rasskazov
 */
@Component(modules = [NakedShortModule::class])
interface NakedShortComponent {

    fun repository(): NakedShortRepository
}
