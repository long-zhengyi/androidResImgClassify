package ui.main.events

import ui.GlobalModel

fun globalEvents() {
    GlobalModel.viewStatus.apply {
        if (onSelectFolder.value == 2) {
            when (moveEvent.moveAction) {
                moveEvent.ACTION_PUT->
                    FileMover.putFile(
                        moveEvent.movingFiles,
                        "${GlobalModel.RES_PATH}${targetFolder.value}/"
                    )
                moveEvent.ACTION_ADD->
                    FileMover.addFile(
                        moveEvent.movingFiles[0],
                        "${GlobalModel.RES_PATH}${targetFolder.value}/${moveEvent.targetItem}"
                    )
                else-> {}
            }
        }
    }
}