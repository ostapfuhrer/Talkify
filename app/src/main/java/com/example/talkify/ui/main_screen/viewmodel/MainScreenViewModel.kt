package com.example.talkify.ui.main_screen.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.MakeListUseCase
import com.example.domain.utiles.ItemUI
import com.example.talkify.ui.main_screen.states.MainScreenState
import com.example.talkify.ui.main_screen.states.MainScreenStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val makeListUseCase: MakeListUseCase
    ) : ViewModel() {
    private var _uiState: MainScreenState by mutableStateOf(MainScreenState())
        private set
    val uiState: MainScreenState
        get() = _uiState

val category ="Fruits"

    fun onEvent(state: MainScreenStates) {
        when (state) {
            MainScreenStates.Edit -> editScreen()
            is MainScreenStates.ChangeList -> {
                viewModelScope.launch {
                    updateUIState(  makeListUseCase( state.listName))
                }
            }
            MainScreenStates.GoHome -> TODO()
            MainScreenStates.OpenSetting -> TODO()


        }
    }
    init{
        viewModelScope.launch {
            try {
                updateUIState( makeListUseCase(category))
            }
            catch (e:Exception){//  при першому створенні бази даних не встигають створитися категорії
                delay(5000)
                updateUIState( makeListUseCase(category))

            }
        }
    }
    private fun editScreen() {
        val current = _uiState.edit
        val updated = _uiState.copy(edit = !current)
        _uiState = updated

    }
    private fun updateUIState(itemList:List<ItemUI>) {
        _uiState = _uiState.copy(list = itemList )
    }
}