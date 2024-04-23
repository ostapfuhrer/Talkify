package com.example.talkify.ui.main_screen.states

 sealed class MainScreenStates {
     object  Edit:MainScreenStates()
     object  ChangeList:MainScreenStates()
     object  OpenSetting:MainScreenStates()
     object  GoHome:MainScreenStates()

}