package personal.lzy.androidres.platform

import androidx.compose.ui.graphics.ImageBitmap

private object AndroidPlatformFileApi : PlatformFileApi {
    override fun exists(path: String): Boolean {
        println("当前平台未实现")
        return false
    }

    override fun copyToDir(sourcePaths: List<String>, targetDir: String) {
        println("当前平台未实现")
    }

    override fun copyToFile(sourcePath: String, targetPath: String) {
        println("当前平台未实现")
    }

    override fun openFolder(path: String) {
        println("当前平台未实现")
    }

    override fun readImageBitmap(path: String): ImageBitmap? {
        println("当前平台未实现")
        return null
    }
}

actual val platformFileApi: PlatformFileApi = AndroidPlatformFileApi
