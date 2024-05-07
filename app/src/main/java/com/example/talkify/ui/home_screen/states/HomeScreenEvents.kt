package com.example.talkify.ui.home_screen.states

import com.example.talkify.utils.Category

sealed class HomeScreenEvents {
    data class NavigateToCategory(val category: Category) : HomeScreenEvents()
}