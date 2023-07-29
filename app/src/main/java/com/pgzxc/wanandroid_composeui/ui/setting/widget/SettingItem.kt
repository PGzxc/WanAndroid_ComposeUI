package com.pgzxc.wanandroid_composeui.ui.setting.widget

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Brightness4
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pgzxc.wanandroid_composeui.ui.setting.viewmodel.SettingBean

@Composable
fun SettingItemView(settingBean: SettingBean,
                    showBottom: Boolean = false,
                    callClick: () -> Unit = {}) {

    Row(modifier = Modifier.padding(horizontal = 5.dp).height(45.dp).clickable { callClick() },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = settingBean.icon, contentDescription = null, Modifier.size(30.dp))
        Text(text = settingBean.name, fontSize = 12.sp, modifier = Modifier.padding(start = 5.dp).weight(1f))
        Icon(imageVector = Icons.Default.ArrowForwardIos, contentDescription = null)
    }
    AnimatedVisibility(visible = showBottom) {
        Spacer(
            modifier = Modifier
                .height(2.dp)
                .fillMaxWidth()
                .background(Color.DarkGray)
        )
    }

}

@Preview
@Composable
fun Preview_SettingItemView() {

    SettingItemView(settingBean = SettingBean(Icons.Default.Brightness4, "主体"))

}