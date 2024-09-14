package ui.main.mainScreen.body.right

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import ui.GlobalModel
import ui.main.util.exts.onDropFile

@Composable
fun BoxScope.BodyRightCompose(percent: Dp) {
    Column(
        Modifier
            .width(percent)
            .align(Alignment.TopEnd)
            .background(Color(0xfff8f8f8))
            .onDropFile { res->
                GlobalModel.viewStatus.apply {
                    moveEvent.movingFiles = res
                    moveEvent.moveAction = moveEvent.ACTION_PUT
                    onSelectFolder.value = 1
                }
            }
    ) {
        GlobalModel.viewStatus.apply {
            Text("\nview state:\n")
            Text("onAddFolder: ${onAddFolder.value}\n")
            Text("editTextAddWindow: ${editTextAddWindow.value}\n")
            Text("onSelectFolder: ${onSelectFolder.value}\n")
            Text("targetFolder: ${targetFolder.value}\n")
        }
        GlobalModel.viewStatus.moveEvent.apply {
            Text("\nmove property:\n")
            Text("moveAction: ${moveAction}\n")
            Text("targetItem: ${targetItem}\n")
            Text("movingFiles: ${
                movingFiles.run {
                    var res = "["
                    forEach { item->
                        res += "$item, "
                    }
                    "$res]"
                }}\n")
        }
        GlobalModel.apply {
            Text("\ndata:\n")
            Text("targetFolder: ${
                imgs.run {
                    var res = "["
                    forEach { item->
                        res += "$item, "
                    }
                    "$res]"
                }}\n")
        }
    }
}