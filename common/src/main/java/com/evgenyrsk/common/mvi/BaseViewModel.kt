package com.evgenyrsk.common.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

/**
 * @author Evgeny Rasskazov
 */
abstract class BaseViewModel<EVENT : UiEvent, STATE : UiState, EFFECT : UiEffect> : ViewModel() {

    val currentState: STATE
        get() = uiState().value

    private val initialState: STATE by lazy { createInitialState() }

    private val uiState: MutableStateFlow<STATE> = MutableStateFlow(initialState)
    private val event: MutableSharedFlow<EVENT> = MutableSharedFlow()
    private val effect: Channel<EFFECT> = Channel()

    init {
        subscribeEvents()
    }

    fun uiState(): StateFlow<STATE> = uiState.asStateFlow()

    fun event(): SharedFlow<EVENT> = event.asSharedFlow()

    fun effect(): Flow<EFFECT> = effect.receiveAsFlow()

    fun setState(reduce: STATE.() -> STATE) {
        val newState = currentState.reduce()
        uiState.value = newState
    }

    fun setEvent(newEvent: EVENT) {
        viewModelScope.launch { event.emit(newEvent) }
    }

    fun setEffect(builder: () -> EFFECT) {
        val newEffect = builder()
        viewModelScope.launch { effect.send(newEffect) }
    }

    private fun subscribeEvents() {
        viewModelScope.launch {
            event.collect {
                handleEvent(it)
            }
        }
    }

    abstract fun createInitialState(): STATE

    abstract fun handleEvent(event: EVENT)
}
