package ui.main.ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.awt.ComposeWindow
import ui.main.events.globalEvents
import ui.main.ui.top.TopCompose
import ui.main.ui.body.BodyCompose

@Preview
@Composable
fun MainScreen(window: ComposeWindow) {
    globalEvents()
    Column {
        TopCompose()
        BodyCompose()
    }
}