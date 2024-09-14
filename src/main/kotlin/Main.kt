import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ui.main.mainScreen.MainScreenCompose


fun main() = application {
    Window(onCloseRequest = {
        exitApplication()
    }, visible = true) {
        MainScreenCompose(window)
    }
}
