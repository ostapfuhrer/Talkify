package com.example.talkify.ui.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimens(
    val elevation: Dp,
    val itemPadding1: Dp,
    val itemPadding2: Dp,
    val itemPadding3: Dp,
    val itemSize: Dp,
    val boxSize: Dp,
    val gridSellSize: Dp,
    val border: Dp
)


val dimens = Dimens(
    elevation = 10.dp,
    itemPadding1 = 10.dp,
    itemPadding2 = 15.dp,
    itemPadding3 = 20.dp,
    itemSize = 70.dp,
    boxSize = 90.dp,
    gridSellSize = 128.dp,
    border = 1.dp
)