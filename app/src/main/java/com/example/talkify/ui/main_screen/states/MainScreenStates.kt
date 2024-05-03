package com.example.talkify.ui.main_screen.states

sealed class MainScreenStates {
    object Edit : MainScreenStates()
    data class ChangeList(val listName:String) : MainScreenStates()
    object OpenSetting : MainScreenStates()
    object GoHome : MainScreenStates()

}