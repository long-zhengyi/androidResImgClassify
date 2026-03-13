package personal.lzy.androidres.platform

import androidx.compose.ui.graphics.ImageBitmap

interface PlatformFileApi {
    fun exists(path: String): Boolean

    fun copyToDir(sourcePaths: List<String>, targetDir: String)

    fun copyToFile(sourcePath: String, targetPath: String)

    fun openFolder(path: String)

    fun readImageBitmap(path: String): ImageBitmap?
}

expect val platformFileApi: PlatformFileApi
