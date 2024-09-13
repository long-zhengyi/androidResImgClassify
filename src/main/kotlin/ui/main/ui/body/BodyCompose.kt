package ui.main.ui.body

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ui.main.ui.body.center.BodyCenterCompose
import ui.main.ui.body.left.BodyLeftCompose
import ui.main.ui.body.right.BodyRightCompose

@Composable
fun BodyCompose() {
    Row {
        BodyLeftCompose()
        Divider(Modifier.fillMaxHeight().width(1.dp), Color.Gray, 1.dp)
        Row (Modifier.fillMaxSize()){
            BoxWithConstraints(Modifier.fillMaxWidth()) {
                BodyCenterCompose(maxWidth * 0.7f)
//                BodyRightCompose(maxWidth * 0.3f)
            }
        }
    }
}