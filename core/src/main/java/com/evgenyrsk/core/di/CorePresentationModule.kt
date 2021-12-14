package com.evgenyrsk.core.di

import android.app.Application
import com.evgenyrsk.core.data.ApiErrorHandler
import com.evgenyrsk.core.data.ErrorHandler
import com.evgenyrsk.core.presentation.util.AppStringsProvider
import com.evgenyrsk.core.presentation.util.StringsProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Evgeny Rasskazov
 */
@Module
internal interface CorePresentationModule {

    @Binds
    @Singleton
    fun appStringsProvider(impl: AppStringsProvider): StringsProvider
}
