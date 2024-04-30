package com.example.talkify.ui.home_screen.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.talkify.ui.theme.dimens
import com.example.talkify.utils.Category


@Composable
fun Item(category: Category, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(vertical = dimens.itemPadding2),
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimens.elevation
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),

        border = BorderStroke(dimens.border, Color.Black)
    ) {
        Image(
            painterResource(category.Imageid), contentDescription = null,
            modifier = modifier
                .size(dimens.itemSize)
                .padding(dimens.itemPadding1)
        )
    }
}