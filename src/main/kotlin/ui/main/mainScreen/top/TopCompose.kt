package ui.main.mainScreen.top

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.GlobalModel
import ui.main.mainScreen.top.rightOptions.AddFolderCompose
import ui.main.mainScreen.top.rightOptions.SelectFolderCompose

@Composable
fun TopCompose() {
    Row (
        Modifier
            .height(100.dp)
    ) {
        Button ({ GlobalModel.viewStatus.onAddFolder.value = true },
            Modifier.size(100.dp).padding(10.dp)
        ) {
            Text("添加")
        }
        if (GlobalModel.viewStatus.onAddFolder.value) {
            AddFolderCompose()
        }
        if (GlobalModel.viewStatus.onSelectFolder.value == 1) {
            SelectFolderCompose()
        }
    }
}