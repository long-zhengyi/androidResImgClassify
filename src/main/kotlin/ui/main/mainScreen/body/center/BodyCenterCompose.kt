package ui.main.mainScreen.body.center

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import ui.GlobalModel
import ui.main.mainScreen.body.center.item.BodyCenterItem
import ui.main.util.exts.onDropFile

@Composable
fun BoxScope.BodyCenterCompose(percent: Dp) {
    Box(
        Modifier
            .width(percent)
            .fillMaxHeight()
            .background(Color(0xfff8f8f8))
            .onDropFile { res->
                GlobalModel.viewStatus.apply {
                    moveEvent.movingFiles = res
                    moveEvent.moveAction = moveEvent.ACTION_PUT
                    onSelectFolder.value = 1
                }
//                FileMover.putFile(res)
            }
    ) {
        if (GlobalModel.imgs.size != 0) {
            LazyVerticalGrid(
                GridCells.Fixed(3),
            ) {
                items(GlobalModel.imgs) { item ->
                    BodyCenterItem(item)
                }
            }
        }
    }
}