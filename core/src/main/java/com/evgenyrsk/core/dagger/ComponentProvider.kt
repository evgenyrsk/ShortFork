package com.evgenyrsk.core.dagger

/**
 * @author Evgeny Rasskazov
 */
fun interface ComponentProvider<T> {

    fun get(): T
}
