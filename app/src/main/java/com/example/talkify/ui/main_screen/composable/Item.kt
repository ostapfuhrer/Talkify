package com.example.talkify.ui.main_screen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

import com.example.talkify.utils.Item


@Composable
fun Item(item: Item, modifier: Modifier = Modifier){
    Column(     modifier = modifier
        .padding(vertical = 10.dp),
        horizontalAlignment =  Alignment.CenterHorizontally) {

        Image(
            painterResource(item.Imageid), contentDescription = null,
            modifier = modifier

                .size(70.dp)
        )


    }

}

