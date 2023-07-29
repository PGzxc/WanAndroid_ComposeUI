package com.pgzxc.wanandroid_composeui.ui.msg.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.pgzxc.wanandroid_composeui.ext.LocalNavController
import com.pgzxc.wanandroid_composeui.ui.entry.RouteName
import com.pgzxc.wanandroid_composeui.ui.msg.model.MessageItem
import com.pgzxc.wanandroid_composeui.utils.RouteUtils


@Composable
fun MessageView(messageItem: MessageItem) {
    val navCtrl: NavHostController = LocalNavController.current
    Column(
        modifier = Modifier
            .padding(horizontal = 5.dp, vertical = 5.dp)
            .clickable {
                RouteUtils.navTo(
                    navCtrl,
                    RouteName.WEB_VIEW + "?link=${messageItem.fullLink}&title=${messageItem.title}"
                )
            }) {
        //第一行
        Row(verticalAlignment = Alignment.CenterVertically) {

            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .background(Color.Blue, shape = RoundedCornerShape(2.dp))
                    .padding(horizontal = 5.dp, vertical = 2.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    Modifier.size(20.dp)
                )
                Text(text = messageItem.fromUser, fontSize = 12.sp)
            }
            Text(
                text = messageItem.tag, fontSize = 12.sp, modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .background(Color.Red, shape = RoundedCornerShape(2.dp))
                    .padding(horizontal = 5.dp, vertical = 2.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Row {
                Icon(
                    imageVector = Icons.Default.Schedule,
                    contentDescription = null,
                    Modifier.size(20.dp)
                )
                Text(text = messageItem.niceDate, fontSize = 12.sp)
            }
        }
        //第二行-回复了
        Text(
            text = messageItem.title, modifier = Modifier
                .padding(vertical = 20.dp)
                .background(Color.Red, shape = RoundedCornerShape(2.dp))
                .padding(horizontal = 5.dp, vertical = 2.dp)
                .fillMaxWidth()
        )
        //第三行-内容
        Text(
            text = messageItem.message, modifier = Modifier
                .padding(vertical = 0.dp)
                .padding(horizontal = 5.dp, vertical = 2.dp)
                .fillMaxWidth(), maxLines = 3, overflow = TextOverflow.Ellipsis
        )


    }
    //间隔
    Spacer(
        modifier = Modifier
            .height(10.dp)
            .background(Color.LightGray)
            .fillMaxWidth()
    )
}

@Preview
@Composable
fun Preview_MessageView() {

    MessageView(
        messageItem = MessageItem(
            category = 2,
            date = 1690355527000,
            fromUser = "我是廿六啊",
            fromUserId = 133259,
            fullLink = "https://wanandroid.com/wenda/show/8857",
            id = 759423,
            isRead = 1,
            link = "/wenda/show/8857",
            message = "Android原生系统设置开发，Android O之后支持用户对应用单通知渠道（NotificationChannel）进行管理，请问有大佬知道对单渠道进行管理采用什么方式吗？小白看源码真是找不着啊。。",
            niceDate = "2天前",
            tag = "新回答",
            title = "回答了：每日一问 问答征集",
            userId = 26707
        )
    )
}
