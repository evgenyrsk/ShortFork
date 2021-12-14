package com.evgenyrsk.core.di

import androidx.annotation.WorkerThread

/**
 * @author Evgeny Rasskazov
 * Created on 14.12.2021
 */
@WorkerThread
abstract class DataComponentHolder<T, D> {

    private var componentInstance: T? = null

    fun getComponent(): T =
        componentInstance ?: throw IllegalStateException("Component has not been created yet")

    fun initComponent(data: D) {
        componentInstance = createComponent(data)
    }

    abstract fun createComponent(data: D): T
}