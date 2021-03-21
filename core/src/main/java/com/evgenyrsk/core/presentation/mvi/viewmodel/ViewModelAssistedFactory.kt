package com.evgenyrsk.core.presentation.mvi.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

/**
 * @author Evgeny Rasskazov
 */
fun interface ViewModelAssistedFactory<T : ViewModel> {

    fun create(handle: SavedStateHandle): T
}
