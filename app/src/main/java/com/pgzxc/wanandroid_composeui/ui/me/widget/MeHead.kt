package com.pgzxc.wanandroid_composeui.ui.me.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.pgzxc.wanandroid_composeui.ext.LocalNavController
import com.pgzxc.wanandroid_composeui.ui.entry.RouteName
import com.pgzxc.wanandroid_composeui.ui.me.model.MeInfoBean
import com.pgzxc.wanandroid_composeui.ui.me.viewmodel.MeViewModel
import com.pgzxc.wanandroid_composeui.utils.RouteUtils
import com.pgzxc.wanandroid_composeui.utils.TokenUtils

/**
 * 我的——Widget——头部
 */
@Composable
fun MeHead(viewModel: MeViewModel) {
    val navCtrl: NavHostController = LocalNavController.current
    Column() {
        //1-用户信息
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(vertical = 30.dp, horizontal = 30.dp)
                .clickable {
                    if (TokenUtils.getUserInfo() == null) {
                        RouteUtils.navTo(navCtrl, RouteName.LOGIN)
                    }
                }) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                modifier = Modifier
                    .size(width = 80.dp, height = 80.dp)
                    .background(Color.LightGray, shape = CircleShape)
                    .padding(20.dp)
            )
            Text(
                text = if (TokenUtils.getUserInfo() != null) TokenUtils.getUserInfo()!!.nickname else "欢迎登录",
                modifier = Modifier.weight(1f).padding(horizontal = 5.dp)
            )
            Icon(imageVector = Icons.Default.ArrowForwardIos, contentDescription = null)

        }
        Row {
            MeInfo(
                MeInfoBean(
                    name = "等级",
                    value = if (TokenUtils.getUserInfo() != null) viewModel.coinInfo.level.toString() else "—"
                ), modifier = Modifier.weight(1f)
            )
            MeInfo(
                MeInfoBean(
                    name = "排名",
                    value = if (TokenUtils.getUserInfo() != null) viewModel.coinInfo.rank else "—"
                ), modifier = Modifier.weight(1f)
            )
            MeInfo(
                MeInfoBean(
                    name = "收藏",
                    value = if (TokenUtils.getUserInfo() != null) TokenUtils.getUserInfo()?.collectIds?.count()
                        .toString() else "—"
                ), modifier = Modifier.weight(1f)
            )
            MeInfo(
                MeInfoBean(
                    name = "积分",
                    value = if (TokenUtils.getUserInfo() != null) viewModel.coinInfo.coinCount.toString() else "—"
                ), modifier = Modifier.weight(1f)
            )
        }
    }
}