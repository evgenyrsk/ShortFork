package com.evgenyrsk.core.presentation.mvi

/**
 * @author Evgeny Rasskazov
 */
interface View<STATE : UiState> {

    fun render(state: STATE)
}
