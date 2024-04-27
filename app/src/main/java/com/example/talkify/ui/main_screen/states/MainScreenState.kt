package com.example.talkify.ui.main_screen.states

import com.example.talkify.utils.Item

data class MainScreenState(val edit:Boolean= false, val list: List<Item> = emptyList())
