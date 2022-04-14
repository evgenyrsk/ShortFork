package com.evgenyrsk.core.presentation.mvi

/**
 * @author Evgeny Rasskazov
 */
interface MviView<STATE : UiState> {

    fun render(state: STATE)
}
