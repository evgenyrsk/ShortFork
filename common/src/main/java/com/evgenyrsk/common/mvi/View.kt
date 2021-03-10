package com.evgenyrsk.common.mvi

/**
 * @author Evgeny Rasskazov
 */
interface View<STATE : UiState> {

    fun render(state: STATE)
}
