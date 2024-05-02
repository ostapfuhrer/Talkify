package com.example.talkify.ui.main_screen.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.talkify.ui.main_screen.states.MainScreenState
import com.example.talkify.ui.main_screen.states.MainScreenStates
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor() : ViewModel() {

    private var _uiState: MainScreenState by mutableStateOf(MainScreenState())

    val uiState: MainScreenState
        get() = _uiState

    fun onEvent(state: MainScreenStates) {
        when (state) {
            MainScreenStates.ToggleEditMode -> editModeScreen()
            MainScreenStates.ChangeList -> TODO()
            MainScreenStates.GoHome -> TODO()
            MainScreenStates.OpenSetting -> openBottomSheetSettings()
            else -> {}
        }
    }

    private fun editModeScreen() {
        val current = _uiState.edit
        val updated = _uiState.copy(edit = !current)
        _uiState = updated
    }
}
    private fun openBottomSheetSettings() {

    }