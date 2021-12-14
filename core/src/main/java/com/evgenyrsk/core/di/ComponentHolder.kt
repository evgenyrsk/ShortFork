package com.evgenyrsk.core.di

import androidx.annotation.WorkerThread

/**
 * @author Evgeny Rasskazov
 * Created on 14.12.2021
 */
@WorkerThread
abstract class ComponentHolder<T> {

    var componentInstance: T? = null

    fun getComponent(): T = componentInstance ?: run {
        componentInstance = createComponent()
        return@run componentInstance!!
    }

    abstract fun createComponent(): T
}