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
import androidx.compose.ui.tooling.preview.Preview
import com.example.talkify.R
import com.example.talkify.ui.theme.dimens

@Composable
fun RoundIcon(image: Int, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .padding(dimens.itemPadding1)
            .size(dimens.boxSize)
            .shadow(
                elevation = dimens.elevation,
                spotColor = Color.LightGray,
                shape = RoundedCornerShape(50)
            )
            .clip(RoundedCornerShape(50))
            .background(Color.White), contentAlignment = Alignment.Center
    ) {
        Image(
            painterResource(id = image), contentDescription = null,
            modifier
                .size(dimens.iconSize)
                .clickable { onClick() }
                .clip(RoundedCornerShape(10))
                .background(Color.White),
        )
    }
}

@Preview
@Composable
fun IconPreview() {
    RoundIcon(R.drawable.edit1, {})
}