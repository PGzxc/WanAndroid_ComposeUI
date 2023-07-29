package com.pgzxc.wanandroid_composeui.ui.setting

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Brightness4
import androidx.compose.material.icons.filled.ClosedCaption
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import com.pgzxc.wanandroid_composeui.ext.LocalNavController
import com.pgzxc.wanandroid_composeui.ui.setting.viewmodel.SettingBean
import com.pgzxc.wanandroid_composeui.ui.setting.widget.SettingItemView
import com.pgzxc.wanandroid_composeui.utils.RouteUtils.back
import com.pgzxc.wanandroid_composeui.utils.TokenUtils
import com.pgzxc.wanandroid_composeui.widget.TitleBar

@Composable
fun SettingPage() {
    val navCtrl = LocalNavController.current
    Column {
        TitleBar(title = "设置", leftIcon = Icons.Default.ArrowBack, leftCallBack = {
            navCtrl.back()
        })
        SettingItemView(settingBean = SettingBean(Icons.Default.Brightness4, "主题"))
        SettingItemView(settingBean = SettingBean(Icons.Default.ClosedCaption, "语言"))
        SettingItemView(settingBean = SettingBean(Icons.Default.Delete, "退出"), callClick = {
            TokenUtils.handleLogoutSuccess()
            navCtrl.back()
        })
    }


}