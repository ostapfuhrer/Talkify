package com.example.talkify.ui.home_screen.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.talkify.ui.home_screen.composable.Item
import com.example.talkify.ui.home_screen.states.HomeScreenEvents
import com.example.talkify.ui.home_screen.viewmodel.HomeScreenViewModel
import com.example.talkify.utils.Screens
import com.example.talkify.utils.categories


@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.White, Color.Yellow),
                    startY = 0f,
                    endY = 500f
                )
            )
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Item(category = categories.component1(),
                    modifier = Modifier.clickable {
                        viewModel.onEvent(HomeScreenEvents.NavigateToCategory(categories.component1()))
                        navController.navigate(Screens.MainScreen.route + "?categoryId=${categories.component1().id}")
                    })
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Item(category = categories.component2(),
                        modifier = Modifier.clickable {
                            viewModel.onEvent(HomeScreenEvents.NavigateToCategory(categories.component2()))
                            navController.navigate(Screens.MainScreen.route + "?categoryId=${categories.component2().id}")
                        })
                    Item(category = categories.component3(),
                        modifier = Modifier.clickable {
                            viewModel.onEvent(HomeScreenEvents.NavigateToCategory(categories.component3()))
                            navController.navigate(Screens.MainScreen.route + "?categoryId=${categories.component3().id}")
                        })

                }
                Item(category = categories.component4(),
                    modifier = Modifier.clickable {
                        viewModel.onEvent(HomeScreenEvents.NavigateToCategory(categories.component4()))
                        navController.navigate(Screens.MainScreen.route + "?categoryId=${categories.component4().id}")
                    })

            }

        }

    }
}