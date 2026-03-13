package personal.lzy.androidres.platform

import androidx.compose.ui.Modifier

interface PlatformDragDropApi {
    fun dropFiles(modifier: Modifier, onFiles: (paths: List<String>) -> Unit): Modifier
}

expect val platformDragDropApi: PlatformDragDropApi

fun Modifier.platformDropFiles(onFiles: (paths: List<String>) -> Unit): Modifier {
    return platformDragDropApi.dropFiles(this, onFiles)
}
