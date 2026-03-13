package personal.lzy.androidres.platform

import androidx.compose.ui.Modifier

private object AndroidPlatformDragDropApi : PlatformDragDropApi {
    override fun dropFiles(modifier: Modifier, onFiles: (paths: List<String>) -> Unit): Modifier {
        println("当前平台未实现")
        return modifier
    }
}

actual val platformDragDropApi: PlatformDragDropApi = AndroidPlatformDragDropApi
