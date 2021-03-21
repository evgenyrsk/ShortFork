package com.evgenyrsk.core.di

import com.evgenyrsk.core.data.ApiError
import com.evgenyrsk.core.data.ErrorHandler
import dagger.Module
import dagger.Provides
import dagger.Reusable

/**
 * @author Evgeny Rasskazov
 */
@Module
class CoreMiscModule {

    @Provides
    @Reusable
    fun providesErrorHandler(): ErrorHandler {
        return object : ErrorHandler {
            override fun getError(throwable: Throwable): ApiError {
                // TODO specify an implementation
                return ApiError.Unknown
            }
        }
    }
}
