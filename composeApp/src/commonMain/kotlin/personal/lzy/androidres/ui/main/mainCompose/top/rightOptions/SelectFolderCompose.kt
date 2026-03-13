package personal.lzy.androidres.ui.main.mainCompose.top.rightOptions

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import personal.lzy.androidres.platform.platformFileApi
import personal.lzy.androidres.ui.GlobalModel

@Composable
fun SelectFolderCompose() {
    val api = platformFileApi
    Column(
        Modifier.padding(10.dp, 0.dp)
    ) {
        Text("选择归类文件夹")
        LazyRow {
            items(GlobalModel.folders) { item->
                if ("" == GlobalModel.viewStatus.moveEvent.targetItem || !platformFileApi.exists("${GlobalModel.RES_PATH}${item}/${GlobalModel.viewStatus.moveEvent.targetItem}")) {
                    Text(
                        item,
                        modifier = Modifier.padding(3.dp)
                            .clip(RoundedCornerShape(5.dp))
                            .background(Color.LightGray)
                            .clickable {
                                GlobalModel.viewStatus.apply {
                                    targetFolder.value = item
                                    onSelectFolder.value = 2
                                }
                            }
                            .padding(15.dp, 10.dp)
                    )
                }
            }
        }
        Button(
            onClick = {
                GlobalModel.viewStatus.onSelectFolder.value = 0
            }
        ) {
            Text("取消")
        }
    }
}