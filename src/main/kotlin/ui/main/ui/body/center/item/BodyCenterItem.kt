package ui.main.ui.body.center.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.unit.dp
import ui.GlobalModel
import ui.main.util.exts.onDropFile
import java.io.File
import javax.imageio.ImageIO

@Composable
fun LazyGridItemScope.BodyCenterItem(item: String) {
    val file = GlobalModel.folders.let {
            for (i in (it.size - 1) downTo 0) {
                val f = File("${GlobalModel.RES_PATH}${it[i]}/$item")
                if (f.exists()) {
                    return@let f
                }
            }
        return@let File("")
    }
    if (file.exists()) {
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
                    Image(
                        ImageIO.read(file)
                            .toComposeImageBitmap(),
                        "",
                        modifier = Modifier.size(100.dp)
                    )
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
                                    if (!File("${GlobalModel.RES_PATH}${folder}/$item").exists()) {
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