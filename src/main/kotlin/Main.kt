import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ui.main.ui.MainScreen


fun main() = application {
    Window(onCloseRequest = {
        exitApplication()
    }, visible = true) {
        MainScreen(window)
    }
}
