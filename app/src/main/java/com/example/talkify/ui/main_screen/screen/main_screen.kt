package com.example.talkify.ui.main_screen.screen

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domain.utiles.ItemUI
import com.example.talkify.R
import com.example.talkify.ui.main_screen.composable.BottomBar
import com.example.talkify.ui.main_screen.composable.Item
import com.example.talkify.ui.main_screen.composable.TopAppBar
import com.example.talkify.ui.main_screen.states.MainScreenStates
import com.example.talkify.ui.main_screen.viewmodel.MainScreenViewModel
import com.example.talkify.ui.theme.dimens


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainScreenViewModel = hiltViewModel<MainScreenViewModel>()
) {
    val state = viewModel.uiState
    Scaffold(
        topBar = {
            if (state.edit) {
                TopAppBar(onClick = { viewModel.onEvent(MainScreenStates.ChangeList(it))})
            }
        },
        bottomBar = { BottomBar(onEdit = { viewModel.onEvent(MainScreenStates.Edit) }) },
        modifier = modifier
            .fillMaxSize()

    ) { paddingValues ->
        MainHome(paddingValues, state.list )
    }
}

@Composable
fun MainHome(paddingValues: PaddingValues, list:List<ItemUI>, modifier: Modifier = Modifier) {
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
                    painter = painterResource(id = R.drawable.bucket),
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
                    Item(list[item])
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}


