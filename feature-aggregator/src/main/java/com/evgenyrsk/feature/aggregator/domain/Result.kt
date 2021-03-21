package com.evgenyrsk.feature.aggregator.domain

import com.evgenyrsk.core.data.ApiError

/**
 * @author Evgeny Rasskazov
 */
// TODO extract to core/domain?
sealed class Result<out R> {

    class Success<out T>(val data: T) : Result<T>()

    class Error(val exception: ApiError) : Result<Nothing>()
}
