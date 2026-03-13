package personal.lzy.androidres.platform

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import java.awt.Desktop
import java.io.File
import java.nio.file.Files
import java.nio.file.StandardCopyOption
import javax.imageio.ImageIO

private object JvmPlatformFileApi : PlatformFileApi {
    override fun exists(path: String): Boolean {
        if (path.isBlank()) return false
        return File(path).exists()
    }

    override fun copyToDir(sourcePaths: List<String>, targetDir: String) {
        if (targetDir.isBlank()) return
        for (src in sourcePaths) {
            if (src.isBlank()) continue
            val sourceFile = File(src)
            val targetFile = File(targetDir, sourceFile.name)
            if (!targetFile.exists()) {
                targetFile.parentFile?.mkdirs()
                targetFile.createNewFile()
            }
            Files.copy(sourceFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING)
        }
    }

    override fun copyToFile(sourcePath: String, targetPath: String) {
        if (sourcePath.isBlank() || targetPath.isBlank()) return
        val sourceFile = File(sourcePath)
        val targetFile = File(targetPath)
        if (!targetFile.exists()) {
            targetFile.parentFile?.mkdirs()
            targetFile.createNewFile()
        }
        Files.copy(sourceFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING)
    }

    override fun openFolder(path: String) {
        val folder = File(path)
        if (folder.exists() && Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(folder)
        }
    }

    override fun readImageBitmap(path: String): ImageBitmap? {
        if (path.isBlank()) return null
        val file = File(path)
        if (!file.exists()) return null
        return ImageIO.read(file)?.toComposeImageBitmap()
    }
}

actual val platformFileApi: PlatformFileApi = JvmPlatformFileApi

