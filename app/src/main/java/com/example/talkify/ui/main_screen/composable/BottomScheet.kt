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
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

/**
 *в функцію буде передаватись два параметра
 *зображення, яке буде виступати посиланням та те що треба відобразит
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
    val scope = rememberCoroutineScope()
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

    if (isSheetOpen) {
        ModalBottomSheet(
            onDismissRequest = { onToggleSheet() },
            sheetState = bottomSheetState,
            windowInsets = BottomSheetDefaults.windowInsets
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                content()
            }
            Button(
                onClick = {
                    scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
                        if (!bottomSheetState.isVisible) {
                            onToggleSheet()
                        }
                    }
                }
            ) {
                Text("Hide Bottom Sheet")
            }
        }
    }
}

/*щось типу такого
fun BottomSheetExamplePreview() {
    BottomSheetTalkify(
        imagePainter = painterResource(id = R.drawable.settings),
        content = {
            Text("This is a simple text inside the bottom sheet")
            // можна додавати компоненти
        }
    )
}
 */