package com.example.talkify.ui.main_screen.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.example.talkify.ui.main_screen.states.MainScreenState
import com.example.talkify.ui.main_screen.utils.IconType
import com.example.talkify.ui.main_screen.utils.IconsBottomBarUtils.updateCurrentIcons
import com.example.talkify.utils.colors

@Composable
fun BottomBar(
    state: MainScreenState,
    onEditButtonClick: () -> Unit,
    onHomeButtonClick: () -> Unit,
    onSettingsButtonClick: () -> Unit,
    onBackButtonClick: () -> Unit,
    onAddButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(brush = gradientBackgroundBrash(colors = colors)),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        val icons = updateCurrentIcons(state)
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(brush = gradientBackgroundBrash(colors = colors)),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            DisplayIcons(
                icons,
                onEditButtonClick,
                onHomeButtonClick,
                onSettingsButtonClick,
                onBackButtonClick,
                onAddButtonClick,
            )
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
fun DisplayIcons(
    icons: Map<IconType, Int>,
    onEditButtonClick: () -> Unit,
    onHomeButtonClick: () -> Unit,
    onSettingsButtonClick: () -> Unit,
    onBackButtonClick: () -> Unit,
    onAddButtonClick: () -> Unit,
) {
    val onDefaultClick: () -> Unit = {}
    icons.keys.forEach { iconType ->
        val onClick = when (iconType) {
            IconType.HOME -> onHomeButtonClick
            IconType.EDIT -> onEditButtonClick
            IconType.SETTINGS -> onSettingsButtonClick
            IconType.BACK -> onBackButtonClick
            IconType.ADD ->onAddButtonClick
            else -> onDefaultClick
        }
        RoundIcon(
            icons[iconType] ?: error("Icon not found for $iconType"),
            onClick = onClick
        )
    }
}






