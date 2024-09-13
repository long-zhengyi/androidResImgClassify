package ui.main.ui.top.rightOptions

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ui.GlobalModel

@Composable
fun AddFolderCompose() {
    Column (
        Modifier
            .padding(10.dp, 0.dp)
    ) {
        Row {
            TextField(
                modifier = Modifier.width(180.dp),
                value = GlobalModel.viewStatus.editTextAddWindow.value,
                onValueChange = { s->
                    GlobalModel.viewStatus.editTextAddWindow.value = s
                }
            )
            LazyVerticalGrid (
                GridCells.Fixed(3),
                Modifier.padding(10.dp, 0.dp)
            ) {
                items(GlobalModel.resPathDefault) { item->
                    Text(
                        item,
                        modifier = Modifier.padding(3.dp)
                            .clip(RoundedCornerShape(5.dp))
                            .background(Color.LightGray)
                            .clickable { GlobalModel.viewStatus.editTextAddWindow.value = item }
                            .padding(4.dp, 0.dp)
                    )
                }
            }
        }
        Row {
            Button(
                modifier = Modifier.padding(0.dp, 3.dp),
                onClick = {
                    GlobalModel.viewStatus.onAddFolder.value = false
                }
            ) {
                Text("取消")
            }
            Button(
                modifier = Modifier.padding(10.dp, 3.dp),
                onClick = {
                    GlobalModel.apply {
                        folders.add(viewStatus.editTextAddWindow.value)
                        viewStatus.editTextAddWindow.value = ""
                        viewStatus.onAddFolder.value = false
                    }
                }
            ) {
                Text("确认")
            }
        }
    }
}