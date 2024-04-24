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
import androidx.compose.ui.unit.dp

import com.example.talkify.utils.categories

@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
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
                        .padding(20.dp)
                        .size(75.dp)
                        .clickable { }
                )

            }


        }

    }
}