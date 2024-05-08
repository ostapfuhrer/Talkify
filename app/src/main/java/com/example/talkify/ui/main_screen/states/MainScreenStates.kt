package com.example.talkify.ui.main_screen.states

sealed class MainScreenStates {
    object ToggleEditMode : MainScreenStates()
    data class ChangeList(val listName:String) : MainScreenStates()
    object OpenSetting : MainScreenStates()
    object GoHome : MainScreenStates()
    object DiscardChanges:MainScreenStates()
    object AddItems:MainScreenStates()
}