package com.example.talkify.ui.main_screen.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.talkify.ui.home_screen.composable.Item
import com.example.talkify.utils.Screens
import com.example.talkify.utils.categories

@Composable
fun MainScreen(
    navController: NavController,
    categoryId: Int?
) {
    val category = categories.find { it.id == categoryId }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        category?.let { Item(category = it) }
    }

}