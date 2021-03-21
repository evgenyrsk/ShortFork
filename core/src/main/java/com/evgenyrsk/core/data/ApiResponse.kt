package com.evgenyrsk.core.data

/**
 * @author Evgeny Rasskazov
 */
sealed class ApiResponse<out R> {

    class Success<out T>(val data: T) : ApiResponse<T>()

    class Error(val exception: Exception) : ApiResponse<Nothing>()
}
