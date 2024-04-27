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
import com.example.talkify.R



val colors = listOf<Color>(
    Color.White,
    Color(0xB0F7E436)
)

@Composable
fun BottomBar(modifier: Modifier = Modifier, onEdit:()->Unit,) {
    Row(modifier = modifier.fillMaxWidth()
        .background(brush = gradientBackgroundBrash(colors = colors)),horizontalArrangement = Arrangement.SpaceEvenly) {
        RoundIcon(R.drawable.home,{})
        RoundIcon(R.drawable.edit,{onEdit()})
        RoundIcon(R.drawable.settings,{})
    }
}

@Composable
fun gradientBackgroundBrash(colors:List<Color>): Brush {
    return Brush.linearGradient(
        colors= colors,
        start = Offset.Zero,
        end = Offset(0F, Float.POSITIVE_INFINITY)
    )
}
