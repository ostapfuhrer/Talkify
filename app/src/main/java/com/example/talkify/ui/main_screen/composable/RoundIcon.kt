package com.example.talkify.ui.main_screen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun RoundIcon(image:Int,onClick:()->Unit,modifier: Modifier = Modifier){
    Box(modifier= modifier.padding(10.dp)
        .size(90.dp)
        .shadow(
            elevation = 10.dp,
            spotColor = Color.LightGray,
            shape = RoundedCornerShape(50)
        )
        .clip(RoundedCornerShape(50))
        .background(Color.White), contentAlignment = Alignment.Center){
        Image(
            painterResource(id = image), contentDescription = null,
            modifier
                .size(70.dp)
                .clickable { onClick() }
                .clip(RoundedCornerShape(50))
                .background(Color.White),)
    }


}