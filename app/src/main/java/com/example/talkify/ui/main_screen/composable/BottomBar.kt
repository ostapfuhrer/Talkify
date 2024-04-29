package com.example.talkify.ui.main_screen.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.example.talkify.ui.main_screen.states.MainScreenStates
import com.example.talkify.ui.main_screen.utils.IconType
import com.example.talkify.ui.main_screen.utils.IconsBottomBarUtils.editIcons
import com.example.talkify.ui.main_screen.utils.IconsBottomBarUtils.getCurrentIcons
import com.example.talkify.ui.main_screen.utils.IconsBottomBarUtils.standardIcons
import com.example.talkify.ui.main_screen.viewmodel.MainScreenViewModel


//це винести в окремий файл, тут немає бути цього, тут тільки composable fun ,
// я створив папку constants , і там створюєш object-файли, в них це все виносиш
val colors = listOf(
    Color.White,
    Color(0xB0F7E436)
)

@Composable
fun BottomBar(viewModel: MainScreenViewModel, modifier: Modifier = Modifier) {
    val state = viewModel.uiState

    val defaultIcons = remember {
        mutableStateMapOf<IconType, Int>().apply {
            putAll(standardIcons)
        }
    }
    val editIcons = remember {
        mutableStateMapOf<IconType, Int>().apply {
            putAll(editIcons)
        }
    }

    val standardOnClicks = mapOf(
        IconType.HOME to { /* Обробка натискання на кнопку "home" */ },
        IconType.EDIT to { viewModel.onEvent(MainScreenStates.ToggleEditMode) },
        IconType.SETTINGS to { /* Обробка натискання на кнопку "settings" */ }
    )

    val editModeOnClicks = mapOf(
        IconType.BACK to { viewModel.onEvent(MainScreenStates.ToggleEditMode) },
        IconType.DISCARD_CHANGES to { /* Обробка натискання на кнопку "arrow_discard" */ },
        IconType.ADD to { /* Обробка натискання на кнопку "add" */ }
    )
    val onClicks = if (state.edit) editModeOnClicks else standardOnClicks
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(brush = gradientBackgroundBrash(colors = colors)),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        val icons = getCurrentIcons(state)
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(brush = gradientBackgroundBrash(colors = colors)),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            DisplayIcons(icons, onClicks)
        }
    }
}

@Composable
fun gradientBackgroundBrash(colors: List<Color>): Brush {
    return Brush.linearGradient(
        colors = colors,
        start = Offset.Zero,
        end = Offset(0F, Float.POSITIVE_INFINITY)
    )
}

@Composable
private fun DisplayIcons(
    icons: Map<IconType, Int>,
    onClicks: Map<IconType, () -> Unit>
) {
    icons.keys.forEach { iconType ->
        RoundIcon(
            icons[iconType] ?: error("Icon not found for $iconType"),
            onClick = onClicks[iconType] ?: {}
        )
    }
}







