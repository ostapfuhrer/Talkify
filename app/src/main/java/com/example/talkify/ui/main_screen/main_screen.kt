package com.example.talkify.ui.main_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.talkify.R
import com.example.talkify.ui.main_screen.composable.BottomBar
import com.example.talkify.ui.main_screen.composable.TopAppBar
import com.example.talkify.ui.main_screen.composable.Item
import com.example.talkify.ui.main_screen.states.MainScreenStates
import com.example.talkify.utils.items




val colors = listOf<Color>(
    Color.White,

    Color(0xB0F7E436)
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier, viewModel: MainScreenViewModel = hiltViewModel<MainScreenViewModel>()) {
    var edit:Boolean by remember {
    mutableStateOf(false)

}

    val state = viewModel.UiState
    Box( modifier = modifier
        .fillMaxSize()
      ) {


        Scaffold(
            topBar = { if(state.edit){TopAppBar()} }, bottomBar = {BottomBar(onEdit = {viewModel.onEvent(MainScreenStates.Edit)})}

            , modifier = modifier
                .fillMaxSize()

        ) { paddingValues ->
            mainHome(paddingValues, onEdit = {viewModel.onEvent(MainScreenStates.Edit)})
        }

    }
}

@Composable
fun mainHome(paddingValues: PaddingValues,onEdit:()->Unit, modifier: Modifier = Modifier) {
    Column(modifier= modifier
        .fillMaxSize()
        .padding(paddingValues)) {
        if(items.isEmpty()){
            Column(modifier= modifier
                .fillMaxHeight()
                .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center){
                Image(painter = painterResource(id = R.drawable.bucket), contentDescription =null, modifier= Modifier.size(80.dp) )
            }

        }
        else {
            LazyVerticalGrid( modifier= modifier.fillMaxHeight(),
                columns = GridCells.Adaptive(minSize = 128.dp),
            ) {
                items(items.size) { item ->

                    Item(items[item])

            }

            }
        }

    }



}


@Preview(showBackground = true)
@Composable
fun pr() {
    MainScreen()
}


