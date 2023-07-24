package com.pgzxc.wanandroid_composeui.widget

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.insets.systemBarsPadding
import com.pgzxc.wanandroid_composeui.theme.White
import com.pgzxc.wanandroid_composeui.theme.themeColor


@Composable
fun TitleBar(title: String, leftIcon: ImageVector? = null,leftCallBack: (() -> Unit)? = null,rightIcon: ImageVector? = null, rightCallBack: (() -> Unit)? = null) {

    Row(
        modifier = Modifier
            .background(themeColor)
            .fillMaxWidth()
            .height(50.dp)
            .padding(horizontal = 16.dp)
            .systemBarsPadding(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(visible = (leftIcon != null)) {
            Icon(
                imageVector = leftIcon?:Icons.Default.ArrowBackIos,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        if (leftCallBack != null) {
                            leftCallBack()
                        }
                    }
            )
        }

        Text(
            text = title,
            modifier = Modifier.weight(1f, true),
            color = White,
            textAlign = TextAlign.Center,
            fontSize = 18.sp
        )
        AnimatedVisibility(visible = (rightIcon != null)) {
            if (rightIcon != null) {
                Icon(
                    imageVector = rightIcon,
                    contentDescription = null, tint = Color.White,
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            if (rightCallBack != null) {
                                rightCallBack()
                            }
                        }
                )
            }
        }
    }
}

@Preview(name = "TitleBar")
@Composable
private fun PreviewTitleBar() {
    TitleBar(title = "首页")
}