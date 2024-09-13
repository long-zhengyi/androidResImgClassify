package ui.main.util.exts

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.draganddrop.dragAndDropTarget
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draganddrop.DragAndDropEvent
import androidx.compose.ui.draganddrop.DragAndDropTarget
import androidx.compose.ui.draganddrop.awtTransferable
import androidx.compose.ui.input.pointer.PointerEvent
import androidx.compose.ui.input.pointer.PointerInputScope
import ui.GlobalModel
import java.awt.datatransfer.DataFlavor
import java.io.File

fun File.checkExist(): File? {
    return if (exists()) this else null
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalComposeUiApi::class)
fun Modifier.onDropFile(result: (data: MutableList<File>)->Unit): Modifier {
    return dragAndDropTarget(
        shouldStartDragAndDrop = { true },
        target = object : DragAndDropTarget {
            override fun onDrop(event: DragAndDropEvent): Boolean {
                result(
                    event.awtTransferable
                        .getTransferData(DataFlavor.javaFileListFlavor) as MutableList<File>
                )
                return false
            }
        }
    )
}

//click event utils
suspend inline fun PointerInputScope.onPointerEvent(handler: (event: PointerEvent) -> Unit) {
    var ev: PointerEvent
    while (true) {
        ev = awaitPointerEventScope { awaitPointerEvent() }
        handler(ev)
    }
}