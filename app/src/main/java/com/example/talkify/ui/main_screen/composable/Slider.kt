package com.example.talkify.ui.main_screen.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color

val activeTrackColor = Color(0xFFF6891E) // orange
val inactiveTrackColor = Color(0xFFA9A5A5) // Grey
val thumbColor = Color(0xFFEC417A) // pink

@Composable
fun SettingsSlider(
    sliderValue: MutableState<Float>,
    onValueChange: (Float) -> Unit
) {
    Column {
        Slider(
            value = sliderValue.value,
            onValueChange = { newValue ->
                sliderValue.value = newValue
                onValueChange(newValue)
            },
            valueRange = 0f..100f,
            colors = SliderDefaults.colors(
                activeTrackColor = activeTrackColor,
                inactiveTrackColor = inactiveTrackColor,
                thumbColor = thumbColor
            )
        )
    }
}

/*@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun PreviewSettingsSlider() {
    val sliderValue = mutableStateOf(50f)  // Remember to import mutableStateOf
    SettingsSlider(sliderValue = sliderValue, onValueChange = {})
}*/