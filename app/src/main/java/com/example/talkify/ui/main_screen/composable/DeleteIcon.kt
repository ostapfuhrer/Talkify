package com.example.talkify.ui.main_screen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.domain.R.drawable

@Composable
fun DeleteIcon(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = drawable.delete_icon),
        contentDescription = null,
        modifier = modifier
            .padding(6.dp)
            .size(24.dp) // Розмір значка видалення
    )
}