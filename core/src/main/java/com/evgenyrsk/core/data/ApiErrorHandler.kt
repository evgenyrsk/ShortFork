package com.evgenyrsk.core.data

class ApiErrorHandler: ErrorHandler {

    override fun getError(throwable: Throwable): ApiError {
        // TODO specify an implementation
        return ApiError.Unknown
    }
}