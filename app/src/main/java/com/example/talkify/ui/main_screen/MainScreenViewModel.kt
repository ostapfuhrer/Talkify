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

   private var _UiState: MainScreenState by mutableStateOf(MainScreenState())
        private set

    val UiState: MainScreenState
        get() = _UiState
    fun onEvent(state :MainScreenStates){
        when(state){
            MainScreenStates.Edit->editScreen()
            MainScreenStates.ChangeList -> TODO()
            MainScreenStates.GoHome -> TODO()
            MainScreenStates.OpenSetting -> TODO()
        }

    }

    private fun editScreen() {
       val current = _UiState.edit
        val updated = _UiState.copy(!current)
        _UiState= updated
    }
}