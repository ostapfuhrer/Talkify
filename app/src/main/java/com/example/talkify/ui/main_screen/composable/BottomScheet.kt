package com.example.talkify.ui.main_screen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

/**
 *в функцію буде передаватись два параметра
 *зображення, яке буде виступати посиланням та те що треба відобразити
 *в bottomScheet
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    imagePainter: Painter,
    content: @Composable ColumnScope.() -> Unit,
    isSheetOpen: Boolean,
    onToggleSheet: () -> Unit
) {
    //var openBottomSheet by remember { mutableStateOf(false) }
    //val scope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )

    Image(
        painter = imagePainter,
        contentDescription = "Open Bottom Sheet",
        modifier = Modifier
            .size(50.dp)
            .clickable { onToggleSheet() }
    )
    println("Bottom Sheet is open: $isSheetOpen")  // Debugging output
    if (isSheetOpen) {
        ModalBottomSheet(
            onDismissRequest = { onToggleSheet() },
            sheetState = bottomSheetState,
            windowInsets = BottomSheetDefaults.windowInsets
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom=45.dp, start = 25.dp, end = 25.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                content()
            }
        }
    }
}