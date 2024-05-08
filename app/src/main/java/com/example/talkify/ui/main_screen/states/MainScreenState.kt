package com.example.talkify.ui.main_screen.states

import com.example.domain.utiles.ItemUI

data class MainScreenState(
    val edit: Boolean = false,
    val list: List<ItemUI> = emptyList(),
    val basketList: List<ItemUI> = emptyList(),
)
