package com.example.talkify

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.talkify.ui.home_screen.screen.HomeScreen
import com.example.talkify.ui.main_screen.screen.MainScreen
import com.example.talkify.utils.Screens

@Composable
fun TalkifyNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.route
    ) {
        composable(Screens.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(
            Screens.MainScreen.route +
                    "?categoryId={categoryId}",
            arguments = listOf(
                navArgument("categoryId"){
                    type = NavType.IntType
                }
            )
        ) {
            val categoryId = it.arguments?.getInt("categoryId")
            MainScreen(
                navController = navController,
                categoryId = categoryId
            )
        }
    }

}