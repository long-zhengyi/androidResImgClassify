package personal.lzy.androidres.ui.main.mainCompose.body

import androidx.compose.foundation.layout.*
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import personal.lzy.androidres.ui.main.mainCompose.body.center.BodyCenterCompose
import personal.lzy.androidres.ui.main.mainCompose.body.left.BodyLeftCompose
import personal.lzy.androidres.ui.main.mainCompose.body.right.BodyRightCompose

@Composable
fun BodyCompose() {
    Row {
        BodyLeftCompose()
        VerticalDivider(Modifier.fillMaxHeight().width(1.dp), 1.dp, Color.Gray)
        Row (Modifier.fillMaxSize()){
            BoxWithConstraints(Modifier.fillMaxWidth()) {
                BodyCenterCompose(maxWidth * 0.7f)
//                BodyRightCompose(maxWidth * 0.3f)
            }
        }
    }
}