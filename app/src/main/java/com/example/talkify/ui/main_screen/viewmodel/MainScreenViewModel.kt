package com.example.talkify.ui.main_screen.viewmodel


import android.app.Activity
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.MakeListUseCase
import com.example.domain.utiles.ItemUI
import com.example.talkify.ui.main_screen.states.MainScreenState
import com.example.talkify.ui.main_screen.states.MainScreenStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val makeListUseCase: MakeListUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _uiState: MainScreenState by mutableStateOf(MainScreenState())
    private var _isSettingsSheetOpen: Boolean by mutableStateOf(false)
    private var _isBasketSheetOpen: Boolean by mutableStateOf(false)
    var brightness = mutableFloatStateOf(50f) // Default brightness value
    var volume = mutableFloatStateOf(50f) // Default volume value

    val uiState: MainScreenState
        get() = _uiState
    val isSettingsSheetOpen: Boolean
        get() = _isSettingsSheetOpen
    val isBasketSheetOpen: Boolean
        get() = _isBasketSheetOpen
    var category = "Fruits"
    fun onEvent(state: MainScreenStates) {
        when (state) {
            MainScreenStates.ToggleEditMode -> editModeScreen()
            is MainScreenStates.ChangeList -> { viewModelScope.launch(Dispatchers.IO) { updateUIState(makeListUseCase(state.listName)) } }
            is MainScreenStates.GoHome -> TODO()
            is MainScreenStates.OpenSetting -> toggleSettingsSheet()
            is MainScreenStates.AddItems -> {toggleBasketSheet()
                addItemsToBasket()
            }
            else -> {}
        }
    }


    init {
        savedStateHandle.get<String>("categoryName")?.let {
            category = it
        }

        viewModelScope.launch(Dispatchers.IO) {
            try {
                updateUIState(makeListUseCase(category))
            } catch (e: Exception) {//  при першому створенні бази даних не встигають створитися категорії
                delay(1000)
                updateUIState(makeListUseCase(category))

            }
        }
    }

    private fun editModeScreen() {
        val current = _uiState.edit
        val updated = _uiState.copy(edit = !current)
        _uiState = updated
    }

    private fun toggleSettingsSheet() {
        _isSettingsSheetOpen = !_isSettingsSheetOpen
        Log.d(
            "BottomSheet",
            "Is bottom sheet open: $_isSettingsSheetOpen"
        )  // Use Android's Log class to check state changes
    }

    private fun toggleBasketSheet() {
        _isBasketSheetOpen = !_isBasketSheetOpen
    }
    private fun addItemsToBasket() {
    //   val updatedList = _uiState.list.map { item ->
    //       if (item.isInBasket) {
    //           // Якщо елемент уже знаходиться в кошику, нічого не робимо
    //           item
    //       } else {
    //           // Якщо елемент не в кошику, але вибраний для додавання, додаємо його у кошик
    //           if (item.isSelectedForAdd) {
    //               item.copy(isInBasket = true)
    //           } else {
    //               item
    //           }
    //       }
    //   }
    //   _uiState = _uiState.copy(list = updatedList)
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

    private fun updateUIState(itemList: List<ItemUI>) {
        _uiState = _uiState.copy(list = itemList)
    }

}