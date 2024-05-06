package com.example.talkify.ui.main_screen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.talkify.R
import com.example.talkify.ui.main_screen.viewmodel.MainScreenViewModel

@Composable
fun BottomSheetContent(viewModel: MainScreenViewModel) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Adjust Settings")

        Row{
            Image(
                painter = painterResource(id = R.drawable.brightness),
                contentDescription = "Brightness",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(70.dp)
            )
            SettingsSlider(
                sliderValue = viewModel.brightness,
                onValueChange = viewModel::updateBrightness
            )
        }
        Row {
            Image(
                painter = painterResource(id = R.drawable.sound),
                contentDescription = "Sound",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(60.dp)
            )
            SettingsSlider(
                sliderValue = viewModel.volume,
                onValueChange = viewModel::updateVolume
            )
        }
    }
}