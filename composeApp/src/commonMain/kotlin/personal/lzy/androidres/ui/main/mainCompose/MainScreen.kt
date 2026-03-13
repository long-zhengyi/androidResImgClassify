package personal.lzy.androidres.ui.main.mainCompose

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import personal.lzy.androidres.ui.main.events.globalEvents
import personal.lzy.androidres.ui.main.mainCompose.top.TopCompose
import personal.lzy.androidres.ui.main.mainCompose.body.BodyCompose

@Composable
fun MainScreen() {
    globalEvents()
    Column {
        TopCompose()
        BodyCompose()
    }
}


@Preview(
    showBackground = true,
    backgroundColor = 0xffffffff,
    widthDp = 800,
    heightDp = 600
)
@Composable
fun PreviewMainScreen() {
    MainScreen()
}