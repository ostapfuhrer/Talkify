package com.example.talkify.ui.main_screen.viewmodel

import android.app.Activity
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
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
    private var _isSettingsSheetOpen: Boolean by mutableStateOf(false)
    var brightness = mutableFloatStateOf(50f) // Default brightness value
    var volume = mutableFloatStateOf(50f) // Default volume value

    val uiState: MainScreenState
        get() = _uiState
    val isSettingsSheetOpen: Boolean
        get() = _isSettingsSheetOpen

    fun onEvent(state: MainScreenStates) {
        when (state) {
            MainScreenStates.ToggleEditMode -> editModeScreen()
            MainScreenStates.ChangeList -> TODO()
            MainScreenStates.GoHome -> TODO()
            MainScreenStates.OpenSetting -> toggleSettingsSheet()
            else -> {}
        }
    }

    private fun editModeScreen() {
        val current = _uiState.edit
        val updated = _uiState.copy(edit = !current)
        _uiState = updated
    }

    private fun toggleSettingsSheet() {
        _isSettingsSheetOpen = !_isSettingsSheetOpen
        Log.d("BottomSheet", "Is bottom sheet open: $_isSettingsSheetOpen")  // Use Android's Log class to check state changes
    }
    fun updateBrightness(newValue: Float) {
        brightness.floatValue = newValue
    }

    fun updateVolume(newValue: Float) {
        volume.floatValue = newValue
    }

    fun adjustBrightness(activity: Activity, brightness: Float) {
        val window = activity.window
        val layoutParams = window.attributes
        layoutParams.screenBrightness = brightness  // Brightness value must be between 0.0 and 1.0
        window.attributes = layoutParams
    }

}