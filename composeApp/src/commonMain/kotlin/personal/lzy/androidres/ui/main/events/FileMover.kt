package personal.lzy.androidres.ui.main.events

import personal.lzy.androidres.platform.platformFileApi
import personal.lzy.androidres.ui.GlobalModel

object FileMover {
    fun putFile(files: MutableList<String>, targetPathParent: String) {
        try {
            platformFileApi.copyToDir(files, targetPathParent)
            for (path in files) {
                val name = path.substringAfterLast('/', path.substringAfterLast('\\'))
                if (name.isNotBlank()) {
                    GlobalModel.imgs.add(name)
                }
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

    fun addFile(file: String, targetPath: String) {
        // 只处理一个文件
        try {
            platformFileApi.copyToFile(file, targetPath)
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