package com.evgenyrsk.core.presentation.mvi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evgenyrsk.core.presentation.mvi.UiEffect
import com.evgenyrsk.core.presentation.mvi.UiEvent
import com.evgenyrsk.core.presentation.mvi.UiState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

/**
 * @author Evgeny Rasskazov
 */
abstract class BaseViewModel<EVENT : UiEvent, STATE : UiState, EFFECT : UiEffect> : ViewModel() {

    val currentState: STATE
        get() = uiState.value

    private val initialState: STATE by lazy { createInitialState() }

    private val _uiState: MutableStateFlow<STATE> = MutableStateFlow(initialState)
    val uiState: StateFlow<STATE> = _uiState

    private val _event: MutableSharedFlow<EVENT> = MutableSharedFlow()
    val event: SharedFlow<EVENT> = _event

    private val _effect: Channel<EFFECT> = Channel()
    val effect: Flow<EFFECT>
        get() = _effect.receiveAsFlow()

    init {
        subscribeEvents()
    }

    fun setState(reduce: STATE.() -> STATE) {
        val newState = currentState.reduce()
        _uiState.value = newState
    }

    fun setEvent(newEvent: EVENT) {
        viewModelScope.launch { _event.emit(newEvent) }
    }

    fun setEffect(builder: () -> EFFECT) {
        val newEffect = builder()
        viewModelScope.launch { _effect.send(newEffect) }
    }

    private fun subscribeEvents() {
        viewModelScope.launch {
            _event.collect {
                handleEvent(it)
            }
        }
    }

    abstract fun createInitialState(): STATE

    abstract fun handleEvent(event: EVENT)
}
