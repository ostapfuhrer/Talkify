package com.example.talkify.utils


import com.example.talkify.R

//val items = List(30) { Item("${it % 8 + 1}", R.drawable::class.java.getDeclaredField("img_${it % 8 + 1}").getInt(null), R.drawable::class.java.getDeclaredField("img_${it % 8 + 1}").getInt(null)), }
val fruits = List(21) { Item("${it}", R.drawable::class.java.getDeclaredField("fruits_$it").getInt(null), R.raw::class.java.getDeclaredField("fruits").getInt(null)) }
val transports = List(21) { Item("${it + 21}", R.drawable::class.java.getDeclaredField("transport_${it}").getInt(null), R.raw::class.java.getDeclaredField("transport").getInt(null)) }
val emotions = List(16) { Item("${it + 42}", R.drawable::class.java.getDeclaredField("emotions_${it}").getInt(null), R.raw::class.java.getDeclaredField("emotions").getInt(null)) }

val allItems = fruits + transports + emotions