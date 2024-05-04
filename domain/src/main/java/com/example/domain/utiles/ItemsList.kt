package com.example.domain.utiles

import com.example.domain.R


val fruits = List(21) { ItemUI(
    name = "${it}",
    title = "fruits_$it",
    imageId = R.drawable::class.java.getDeclaredField("fruits_$it").getInt(null),
    audioId = R.raw::class.java.getDeclaredField("fruits").getInt(null)
) }
val transports = List(21) { ItemUI(
    name = "${it + 21}",
    title = "transport_${it}",
    imageId = R.drawable::class.java.getDeclaredField("transport_${it}").getInt(null),
    audioId = R.raw::class.java.getDeclaredField("transport").getInt(null)
) }
val emotions = List(16) { ItemUI(
    name = "${it + 42}",
    title = "emotions_${it}",
    imageId = R.drawable::class.java.getDeclaredField("emotion_${it}").getInt(null),
    audioId = R.raw::class.java.getDeclaredField("emotion").getInt(null)
) }

val allItems = fruits + transports + emotions
