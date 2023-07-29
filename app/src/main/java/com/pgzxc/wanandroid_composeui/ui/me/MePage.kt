package com.pgzxc.wanandroid_composeui.ui.me

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.pgzxc.wanandroid_composeui.ext.LocalNavController
import com.pgzxc.wanandroid_composeui.ui.entry.RouteName
import com.pgzxc.wanandroid_composeui.ui.me.viewmodel.MeViewModel
import com.pgzxc.wanandroid_composeui.ui.me.widget.HeadTools
import com.pgzxc.wanandroid_composeui.ui.me.widget.MeHead
import com.pgzxc.wanandroid_composeui.utils.RouteUtils
import com.pgzxc.wanandroid_composeui.utils.TokenUtils
import com.pgzxc.wanandroid_composeui.widget.TitleBar

/**
 * 我的
 */

@Composable
fun MePage(viewModel: MeViewModel = MeViewModel()) {
    val navCtrl = LocalNavController.current
    LaunchedEffect(true) {
        if (TokenUtils.getUserInfo() != null) {
            viewModel.getCoinInfo()
        }
    }
    Column {

        TitleBar(title = "我的", rightIcon = Icons.Default.Settings, rightCallBack = {
           RouteUtils.navTo(navCtrl,RouteName.SETTING)
        })
        MeHead(viewModel = viewModel)
        HeadTools(viewModel = viewModel)
    }

}