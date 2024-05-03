package com.example.talkify.ui.main_screen.composable

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.example.domain.utiles.ItemUI
import com.example.talkify.ui.theme.dimens


@Composable
fun Item(item: ItemUI, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column(
        modifier = modifier
            .padding(vertical = dimens.itemPadding2),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(item.imageId), contentDescription = null,
            modifier = modifier
                .size(dimens.itemSize)
                .clickable {

                        val music: MediaPlayer = MediaPlayer.create(context, item.audioId )
                       music.start()
                }
        )
    }
}

