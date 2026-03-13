package personal.lzy.androidres.ui.main.mainCompose.body.left

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import personal.lzy.androidres.platform.platformFileApi
import personal.lzy.androidres.ui.GlobalModel

@Composable
fun BodyLeftCompose() {
    Box(Modifier.fillMaxHeight()) {
        Column (
            Modifier.width(150.dp)
                .background(Color(0xe0e0e0))
        ) {
            LazyColumn(
                Modifier.fillMaxWidth()
                    .padding(5.dp)
            ) {
                items(GlobalModel.folders.toList()) { item->
                    Text(
                        item,
                        modifier = Modifier.padding(3.dp)
                            .clip(RoundedCornerShape(5.dp))
                            .background(Color.LightGray)
                            .padding(4.dp, 0.dp)
                    )
                }
            }
        }
        Button(
            {
                platformFileApi.openFolder(GlobalModel.RES_PATH)
            },
            Modifier.align(Alignment.BottomStart).width(150.dp).padding(10.dp)
        ) {
            Text("打开文件夹", textAlign = TextAlign.Center)
        }
    }
}