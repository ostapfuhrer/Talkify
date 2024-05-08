package com.example.talkify.ui.main_screen.utils

import com.example.talkify.R
import com.example.talkify.ui.main_screen.states.MainScreenState

enum class IconType {
    HOME,
    EDIT,
    SETTINGS,
    BACK,
    DISCARD_CHANGES,
    ADD,
}

object IconsBottomBarUtils {
    private val standardIcons = mapOf(
        IconType.HOME to R.drawable.home1,
        IconType.EDIT to R.drawable.edit1,
        IconType.SETTINGS to R.drawable.setting1
    )
    private val editIcons = mapOf(
        IconType.BACK to R.drawable.arrow_back,
        IconType.DISCARD_CHANGES to R.drawable.arrow_discard,
        IconType.ADD to R.drawable.add
    )

    fun updateCurrentIcons(state: MainScreenState): Map<IconType, Int> {
        return if (state.edit) {
            editIcons
        } else {
            standardIcons
        }
    }
}