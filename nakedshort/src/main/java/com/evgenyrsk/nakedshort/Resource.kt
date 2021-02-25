package com.evgenyrsk.nakedshort

/**
 * @author Evgeny Rasskazov
 */
data class Resource<out T>(
    val status: Status,
    val data: T?,
    val message: String? = null
) {

    companion object {

        fun <T> success(data: T): Resource<T> = Resource(status = Status.SUCCESS, data = data)

        fun <T> error(data: T?, message: String) = Resource(status = Status.ERROR, data = data)

        fun <T> loading(data: T?) = Resource(status = Status.LOADING, data = data)
    }
}
