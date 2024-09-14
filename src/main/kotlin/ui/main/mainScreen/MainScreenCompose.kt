package ui.main.mainScreen

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.awt.ComposeWindow
import ui.main.events.globalEvents
import ui.main.mainScreen.top.TopCompose
import ui.main.mainScreen.body.BodyCompose

@Preview
@Composable
fun MainScreenCompose(window: ComposeWindow) {
    globalEvents()
    Column {
        TopCompose()
        BodyCompose()
    }
}