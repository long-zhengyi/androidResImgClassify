package personal.lzy.androidres.ui.main.mainCompose.top

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import personal.lzy.androidres.ui.GlobalModel
import personal.lzy.androidres.ui.main.mainCompose.top.rightOptions.AddFolderCompose
import personal.lzy.androidres.ui.main.mainCompose.top.rightOptions.SelectFolderCompose

@Composable
fun TopCompose() {
    Row (
        Modifier
            .height(100.dp)
    ) {
        Button ({ GlobalModel.viewStatus.onAddFolder.value = true },
            Modifier.size(100.dp).padding(10.dp),
            shape = RoundedCornerShape(10.dp)
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