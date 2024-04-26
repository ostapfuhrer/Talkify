package com.example.talkify.ui.main_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.talkify.ui.main_screen.states.MainScreenState
import com.example.talkify.ui.main_screen.states.MainScreenStates
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel@Inject constructor():ViewModel() {

   private var _uiState: MainScreenState by mutableStateOf(MainScreenState())
        private set

    val uiState: MainScreenState
        get() = _uiState
    fun onEvent(state :MainScreenStates){
        when(state){
            MainScreenStates.Edit->editScreen()
            MainScreenStates.ChangeList -> TODO()
            MainScreenStates.GoHome -> TODO()
            MainScreenStates.OpenSetting -> TODO()
        }

    }

    private fun editScreen() {
       val current = _uiState.edit
        val updated = _uiState.copy(!current)
        _uiState= updated
    }
}