package com.example.talkify.ui.main_screen.composable

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SettingsSlider(sliderValue: MutableState<Float>,
                   onValueChange: (Float) -> Unit) {
    Column {
        Slider(
            value = sliderValue.value,
            onValueChange = { newValue ->
                sliderValue.value = newValue
                onValueChange(newValue)
            },
            valueRange = 0f..100f
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun PreviewSettingsSlider() {
    val sliderValue = mutableStateOf(50f)  // Remember to import mutableStateOf
    SettingsSlider(sliderValue = sliderValue, onValueChange = {})
}