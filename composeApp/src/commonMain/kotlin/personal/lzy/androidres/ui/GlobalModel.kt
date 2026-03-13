package personal.lzy.androidres.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf

object GlobalModel {
    //static
    const val RES_PATH = "C:/resClassify/"
    const val RES_DRAWABLE_XH = "drawable-xhdpi"
    const val RES_DRAWABLE_XXH = "drawable-xxhdpi"
    const val RES_DRAWABLE_XXXH = "drawable-xxxhdpi"
    val resPathDefault = mutableListOf(RES_DRAWABLE_XH, RES_DRAWABLE_XXH, RES_DRAWABLE_XXXH)
    //data
    val folders = mutableStateListOf<String>()
    val imgs = mutableStateListOf<String>()
    //view
    val viewStatus = ViewStatus()
    class ViewStatus {
        //view
        val onAddFolder = mutableStateOf(false)
        val editTextAddWindow = mutableStateOf("")
        val onSelectFolder = mutableStateOf(0)//0：常态；1：正在选择；2：选择完成；-1：取消
        val targetFolder = mutableStateOf("")
        val itemsRefreshFlag = mutableStateOf(1)
        //moveEvent
        val moveEvent = MoveEvent()
        class MoveEvent {
            var movingFiles = mutableListOf<String>()
            var moveAction = -1
            val ACTION_OTHER = -1
            val ACTION_PUT = 1
            val ACTION_ADD = 2
            var targetItem = ""
        }
    }
}
