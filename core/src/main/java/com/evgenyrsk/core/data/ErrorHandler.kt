package com.evgenyrsk.core.data

/**
 * @author Evgeny Rasskazov
 */
interface ErrorHandler {

    fun getError(throwable: Throwable): ApiError
}
