package com.example.domain.utiles

import androidx.annotation.DrawableRes

data class ItemUI(
    val name: String,
    val title:String,
    @DrawableRes
    val imageId: Int,
    val audioId: Int

)