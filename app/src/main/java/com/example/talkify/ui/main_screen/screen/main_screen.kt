package com.example.talkify.ui.main_screen.screen

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.talkify.R
import com.example.talkify.ui.main_screen.composable.BottomBar
import com.example.talkify.ui.main_screen.composable.BottomSheet
import com.example.talkify.ui.main_screen.composable.BottomSheetAddToBasketContent
import com.example.talkify.ui.main_screen.composable.BottomSheetSettingsContent
import com.example.talkify.ui.main_screen.composable.Item
import com.example.talkify.ui.main_screen.composable.TopAppBar
import com.example.talkify.ui.main_screen.states.MainScreenStates
import com.example.talkify.ui.main_screen.viewmodel.MainScreenViewModel
import com.example.talkify.ui.theme.dimens


@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: MainScreenViewModel = hiltViewModel<MainScreenViewModel>()
) {
    val state = viewModel.uiState
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            if (state.edit) {
                TopAppBar(onClick = { viewModel.onEvent(MainScreenStates.ChangeList(it)) })

            }
        },
        bottomBar = {
            BottomBar(
                state = state,
                onEditButtonClick = { viewModel.onEvent(MainScreenStates.ToggleEditMode) },
                onHomeButtonClick = { navController.popBackStack() },
                onSettingsButtonClick = { viewModel.onEvent(MainScreenStates.OpenSetting) },
                onBackButtonClick = { viewModel.onEvent(MainScreenStates.ToggleEditMode) },
                onAddButtonClick = { viewModel.onEvent(MainScreenStates.AddItems) },
                modifier = modifier
            )
        },
    ) { paddingValues ->
        MainHome(paddingValues = paddingValues, viewModel = viewModel, modifier = modifier)
    }
}

@Composable
fun MainHome(
    paddingValues: PaddingValues,
    viewModel: MainScreenViewModel,
    modifier: Modifier = Modifier
) {
    val list = viewModel.uiState.list
    viewModel.uiState.basketList
    val editModeState = viewModel.uiState.edit
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        if (list.isEmpty()) {
            Column(
                modifier = modifier
                    .fillMaxHeight()
                    .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.basket),
                    contentDescription = null,
                    modifier = Modifier.size(dimens.boxSize)
                )

            }

        } else {
            LazyVerticalGrid(
                modifier = modifier.fillMaxHeight(),
                columns = GridCells.Adaptive(minSize = dimens.gridSellSize),
            ) {

                items(list.size) { item ->
                    //add delete_icon for every item
                    Item(item = list[item], isEditMode = editModeState)
                }
            }
            if (editModeState) {
                BottomSheet(
                    imagePainter = painterResource(id = R.drawable.basket),
                    content = {
                        // Define what content to show inside the bottom sheet
                        BottomSheetAddToBasketContent()
                    },
                    isSheetOpen = viewModel.isBasketSheetOpen,  // Pass the ViewModel's state
                    onToggleSheet = {
                        viewModel.onEvent(MainScreenStates.AddItems)  // This should toggle the bottom sheet's visibility
                    }
                )
            } else {
                BottomSheet(
                    imagePainter = painterResource(id = R.drawable.setting1),
                    content = {
                        // Define what content to show inside the bottom sheet
                        BottomSheetSettingsContent(viewModel)
                    },
                    isSheetOpen = viewModel.isSettingsSheetOpen,  // Pass the ViewModel's state
                    onToggleSheet = {
                        viewModel.onEvent(MainScreenStates.OpenSetting)  // This should toggle the bottom sheet's visibility
                    }
                )
            }
        }
    }
}



