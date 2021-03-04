package com.evgenyrsk.core.models

/**
 * @author Evgeny Rasskazov
 */
data class Response<out T>(
    val status: Status,
    val data: T?,
    val message: String? = null
) {

    companion object {

        fun <T> success(data: T): Response<T> = Response(status = Status.SUCCESS, data = data)

        fun <T> error(data: T?, message: String) = Response(status = Status.ERROR, data = data)

        fun <T> loading(data: T?) = Response(status = Status.LOADING, data = data)
    }
}
