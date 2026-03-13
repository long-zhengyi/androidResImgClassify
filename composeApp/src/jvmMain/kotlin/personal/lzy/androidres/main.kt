package personal.lzy.androidres

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import personal.lzy.androidres.ui.main.mainCompose.MainScreen

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "androidRes",
    ) {
        MainScreen()
    }
}