package personal.lzy.androidres.ui.main.util.exts

import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEvent
import androidx.compose.ui.input.pointer.PointerInputScope
import personal.lzy.androidres.platform.platformDropFiles

fun Modifier.onDropFile(result: (data: MutableList<String>) -> Unit): Modifier {
    return platformDropFiles { paths ->
        result(paths.toMutableList())
    }
}

//click event utils
suspend inline fun PointerInputScope.onPointerEvent(handler: (event: PointerEvent) -> Unit) {
    var ev: PointerEvent
    while (true) {
        ev = awaitPointerEventScope { awaitPointerEvent() }
        handler(ev)
    }
}