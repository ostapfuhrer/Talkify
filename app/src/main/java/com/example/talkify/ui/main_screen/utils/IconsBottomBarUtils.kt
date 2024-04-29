package com.example.talkify.ui.main_screen.utils

import com.example.talkify.R
import com.example.talkify.ui.main_screen.states.MainScreenState

object IconsBottomBarUtils {
    val standardIcons = mapOf(
        "home" to R.drawable.home,
        "edit" to R.drawable.edit,
        "settings" to R.drawable.settings
    )
    val editIcons = mapOf(
        "home" to R.drawable.arrow_back,
        "edit" to R.drawable.arrow_discard,
        "settings" to R.drawable.add
    )

    fun getCurrentIcons(state: MainScreenState): Map<String, Int> {
        return if (state.edit) {
            editIcons
        } else {
            standardIcons
        }
    }
}