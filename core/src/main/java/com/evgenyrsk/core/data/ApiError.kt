package com.evgenyrsk.core.data

/**
 * @author Evgeny Rasskazov
 */
// TODO extract to core/domain?
sealed class ApiError() {

    object Network : ApiError()

    object ServiceUnavailable : ApiError()

    object Unknown : ApiError()
}
