package com.example.talkify.ui.main_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.talkify.R
import com.example.talkify.ui.main_screen.states.MainScreenStates

data class Category(val name: String, val Imageid: Int)
data class Item(val name: String, val Imageid: Int)

enum class Icon(val resourceId: Int) {
    HOME(R.drawable.home),
    EDIT(R.drawable.edit),
    SETTINGS(R.drawable.settings)
}
val categories = listOf<Category>(
    Category("Fruits", R.drawable.img_6),

    Category("Cars", R.drawable.cars),
    Category("Emotions", R.drawable.emotions),
    Category("Custom", R.drawable.custom)
)
val items = listOf<Item>(
    Item("1", R.drawable.img_1),
    Item("1", R.drawable.img_2),
    Item("1", R.drawable.img_3),
    Item("1", R.drawable.img_4),
    Item("1", R.drawable.img_5),
    Item("1", R.drawable.img_6),
    Item("1", R.drawable.img_2),
    Item("1", R.drawable.img_3),
    Item("1", R.drawable.img_4),
    Item("1", R.drawable.img_5),
    Item("1", R.drawable.img_6),
    Item("1", R.drawable.img),
    Item("1", R.drawable.img_2),
    Item("1", R.drawable.img_3),
    Item("1", R.drawable.img_4),
    Item("1", R.drawable.img_5),
    Item("1", R.drawable.img_6),
    Item("1", R.drawable.img_2),
    Item("1", R.drawable.img_3),
    Item("1", R.drawable.img_4),
    Item("1", R.drawable.img_5),
    Item("1", R.drawable.img_6),
    Item("1", R.drawable.img),
    Item("1", R.drawable.img_2),
    Item("1", R.drawable.img_3),
    Item("1", R.drawable.img_4),
    Item("1", R.drawable.img_5),
    Item("1", R.drawable.img_6),
    Item("1", R.drawable.img_2),
    Item("1", R.drawable.img_3),
    Item("1", R.drawable.img_4),
    Item("1", R.drawable.img_5),
    Item("1", R.drawable.img_6),
)


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
        .background(
            brush = Brush.verticalGradient(colors)
        )) {


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

@Composable
fun Item(item: Item, modifier: Modifier=Modifier){
    Column(     modifier = modifier
        .padding(vertical = 10.dp),
        horizontalAlignment =  Alignment.CenterHorizontally) {

            Image(
                painterResource(item.Imageid), contentDescription = null,
                modifier = modifier

                    .size(70.dp)
            )


    }

}

@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        )
    ) {
        LazyRow() {
            items(categories) { category ->
                Image(
                    painterResource(id = category.Imageid),
                    contentDescription = category.name,
                    modifier = modifier
                        .padding(20.dp)
                        .size(75.dp)
                        .clickable { }
                )

            }


        }

    }
}

@Composable
fun TestScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(brush = Brush.verticalGradient(colors))){

    }
}




@Composable
fun BottomBar(modifier: Modifier = Modifier,onEdit:()->Unit,) {

    Row(modifier = modifier.fillMaxWidth()
        .background(brush = GradientBackgrougBrash(colors = colors)),horizontalArrangement = Arrangement.SpaceEvenly) {
        RoundIcon(R.drawable.home,{})
        RoundIcon(R.drawable.edit,{onEdit()})
        RoundIcon(R.drawable.settings,{})

    }


}






@Composable
fun RoundIcon(image:Int,onClick:()->Unit,modifier: Modifier = Modifier){
    Box(modifier= modifier.padding(10.dp)
        .size(90.dp)
        .shadow(
            elevation = 10.dp,
            spotColor = Color.LightGray,
            shape = RoundedCornerShape(50)
        )
        .clip(RoundedCornerShape(50))
        .background(Color.White), contentAlignment = Alignment.Center){
        Image(painterResource(id = image), contentDescription = null,
            modifier
                .size(70.dp)
                .clickable { onClick() }
                .clip(RoundedCornerShape(50))
                .background(Color.White),)
    }


}

@Composable
fun GradientBackgrougBrash(colors:List<Color>): Brush {

    return Brush.linearGradient(
        colors= colors,
        start = Offset.Zero,
        end = Offset(0F, Float.POSITIVE_INFINITY)
    )

}




@Preview(showBackground = true)
@Composable
fun pr() {
    MainScreen()
}
@Preview(showBackground = true)
@Composable
fun prTest() {
    TestScreen()
}


