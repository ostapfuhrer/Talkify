package com.example.talkify.utils


import com.example.talkify.R

val items = List(30) { Item("${it % 8 + 1}", R.drawable::class.java.getDeclaredField("img_${it % 8 + 1}").getInt(null)) }
