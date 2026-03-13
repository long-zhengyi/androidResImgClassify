package personal.lzy.androidres.platform

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.draganddrop.dragAndDropTarget
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draganddrop.DragAndDropEvent
import androidx.compose.ui.draganddrop.DragAndDropTarget
import androidx.compose.ui.draganddrop.awtTransferable
import java.awt.datatransfer.DataFlavor
import java.io.File

private object JvmPlatformDragDropApi : PlatformDragDropApi {
    @OptIn(ExperimentalFoundationApi::class, ExperimentalComposeUiApi::class)
    override fun dropFiles(modifier: Modifier, onFiles: (paths: List<String>) -> Unit): Modifier {
        return modifier.dragAndDropTarget(
            shouldStartDragAndDrop = { true },
            target = object : DragAndDropTarget {
                override fun onDrop(event: DragAndDropEvent): Boolean {
                    val files = event.awtTransferable
                        .getTransferData(DataFlavor.javaFileListFlavor) as List<File>
                    onFiles(files.map { it.absolutePath })
                    return false
                }
            }
        )
    }
}

actual val platformDragDropApi: PlatformDragDropApi = JvmPlatformDragDropApi
