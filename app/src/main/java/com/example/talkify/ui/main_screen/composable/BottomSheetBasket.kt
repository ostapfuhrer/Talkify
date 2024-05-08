package com.example.talkify.ui.main_screen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.talkify.R

@Composable
fun BottomSheetAddToBasketContent() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.basket),
            contentDescription = "Brightness",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(50.dp)
        )
    }
}
