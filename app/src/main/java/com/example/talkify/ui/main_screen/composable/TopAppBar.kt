package com.example.talkify.ui.main_screen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.talkify.ui.theme.dimens

import com.example.talkify.utils.categories

@Composable
fun TopAppBar(modifier: Modifier = Modifier, onClick: (String) -> Unit) {
    Card(
        modifier = modifier
            .padding(dimens.itemPadding2),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimens.elevation
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        )
    ) {
        LazyRow() {
            items(categories) { category ->
                Image(
                    painterResource(id = category.Imageid),
                    contentDescription = category.name,
                    modifier = modifier
                        .padding(dimens.itemPadding3)
                        .size(dimens.itemSize)
                        .clickable { onClick(category.name) }
                )

            }
        }
    }
}