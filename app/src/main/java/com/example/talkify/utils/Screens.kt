package com.example.talkify.utils

sealed class Screens(val route: String) {
    object HomeScreen: Screens("home_screen")
    object MainScreen: Screens ("main_screen")
}