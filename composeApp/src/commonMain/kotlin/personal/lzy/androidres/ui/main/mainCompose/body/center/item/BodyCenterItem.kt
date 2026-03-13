package personal.lzy.androidres.ui.main.mainCompose.body.center.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import personal.lzy.androidres.platform.platformFileApi
import personal.lzy.androidres.ui.GlobalModel
import personal.lzy.androidres.ui.main.util.exts.onDropFile

@Composable
fun LazyGridItemScope.BodyCenterItem(item: String) {
    val filePath = GlobalModel.folders.let {
        for (i in (it.size - 1) downTo 0) {
            val path = "${GlobalModel.RES_PATH}${it[i]}/$item"
            if (platformFileApi.exists(path)) {
                return@let path
            }
        }
        return@let ""
    }
    if (platformFileApi.exists(filePath)) {
        Box(
            Modifier.fillMaxSize()
        ) {
            Column(
                Modifier
                    .align(Alignment.Center)
            ) {
                Box(
                    Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .border(1.dp, Color.Gray, RoundedCornerShape(10.dp))
                        .background(Color.White)
                        .onDropFile { res ->
                            GlobalModel.viewStatus.apply {
                                moveEvent.movingFiles = res
                                moveEvent.moveAction = moveEvent.ACTION_ADD
                                moveEvent.targetItem = item
                                onSelectFolder.value = 1
                            }
                        }
                        .padding(5.dp)
                ) {
                    val bitmap = platformFileApi.readImageBitmap(filePath)
                    if (bitmap != null) {
                        Image(
                            bitmap,
                            "",
                            modifier = Modifier.size(100.dp)
                        )
                    }
                    Row(Modifier.align(Alignment.BottomStart)) {
                        if (GlobalModel.viewStatus.itemsRefreshFlag.value == 1
                            || GlobalModel.viewStatus.itemsRefreshFlag.value == 0) {
                            for (folder in GlobalModel.folders) {
                                Box {
                                    Spacer(
                                        Modifier
                                            .align(Alignment.Center)
                                            .padding(3.dp)
                                            .size(10.dp)
                                            .clip(RoundedCornerShape(50))
                                            .background(Color.White)
                                    )
                                    Spacer(
                                        Modifier
                                            .align(Alignment.Center)
                                            .size(8.dp)
                                            .clip(RoundedCornerShape(50))
                                            .background(Color.Black)
                                    )
                                    if (!platformFileApi.exists("${GlobalModel.RES_PATH}${folder}/$item")) {
                                        Spacer(
                                            Modifier
                                                .align(Alignment.Center)
                                                .size(6.dp)
                                                .clip(RoundedCornerShape(50))
                                                .background(Color.White)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
                Text(item)
            }
        }
    }
}