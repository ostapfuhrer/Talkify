package com.example.talkify.utils


import com.example.talkify.R

val items = List(30) { Item("${it % 8 + 1}", R.drawable::class.java.getDeclaredField("img_${it % 8 + 1}").getInt(null)) }
val fruits = List(21) { Item("${it}", R.drawable::class.java.getDeclaredField("fruits_${it}").getInt(null)) }
val transports = List(21) { Item("${it}", R.drawable::class.java.getDeclaredField("transport_${it}").getInt(null)) }
val emotions = List(16) { Item("${it}", R.drawable::class.java.getDeclaredField("emotions_${it}").getInt(null)) }
