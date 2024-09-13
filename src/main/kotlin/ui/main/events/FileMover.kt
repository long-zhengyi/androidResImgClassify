package ui.main.events

import ui.GlobalModel
import java.io.File
import java.nio.file.Files
import java.nio.file.StandardCopyOption

object FileMover {
    fun putFile(files: MutableList<File>, targetPathParent: String) {
        try {
            for (file in files) {
                // 处理每个文件
                val targetFile = File(targetPathParent + file.name)
                if (!targetFile.exists()) {
                    targetFile.parentFile.mkdirs()
                    targetFile.createNewFile()
                }
                Files.copy(file.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING)
                GlobalModel.imgs.add(targetFile.name)
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        //恢复初始状态
        GlobalModel.viewStatus.onSelectFolder.value = 0
        GlobalModel.viewStatus.moveEvent.apply {
            moveAction = -1
            targetItem = ""
            movingFiles = mutableListOf()
        }
        GlobalModel.viewStatus.itemsRefreshFlag.apply {
            value = (value + 1) % 2
        }
    }

    fun addFile(file: File, targetPath: String) {
        // 只处理一个文件
        try {
            val targetFile = File(targetPath)
            if (!targetFile.exists()) {
                targetFile.parentFile.mkdirs()
                targetFile.createNewFile()
            }
            Files.copy(file.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        //恢复初始状态
        GlobalModel.viewStatus.onSelectFolder.value = 0
        GlobalModel.viewStatus.moveEvent.apply {
            moveAction = -1
            targetItem = ""
            movingFiles = mutableListOf()
        }
        GlobalModel.viewStatus.itemsRefreshFlag.apply {
            value = (value + 1) % 2
        }
    }
}