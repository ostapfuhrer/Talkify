package com.example.talkify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.domain.repository.IExampleRepository
import com.example.domain.usecase.IExampleUseCase
import com.example.talkify.ui.home_screen.screen.HomeScreen
import com.example.talkify.ui.main_screen.screen.MainScreen
import com.example.talkify.ui.theme.TalkifyTheme
import com.example.talkify.utils.Screens
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var exampleRepository: IExampleRepository

    @Inject
    lateinit var exampleUseCase: IExampleUseCase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // exampleRepository.getModel()
        setContent {
            TalkifyTheme {

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
        }
    }
}

