package com.pgzxc.wanandroid_composeui.ui.msg.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.pgzxc.wanandroid_composeui.R
import com.pgzxc.wanandroid_composeui.ext.LocalNavController
import com.pgzxc.wanandroid_composeui.ui.entry.RouteName
import com.pgzxc.wanandroid_composeui.ui.msg.viewmodel.MessageViewModel
import com.pgzxc.wanandroid_composeui.utils.RouteUtils
import com.pgzxc.wanandroid_composeui.utils.TokenUtils
import com.pgzxc.wanandroid_composeui.widget.refresh.SwipeLazyColum
import com.pgzxc.wanandroid_composeui.widget.state.StatefulContent

@Composable
fun MessageList(viewModel: MessageViewModel, index: Int) {

    val navCtrl: NavHostController = LocalNavController.current

    val loadingComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.empty_box),
        cacheKey = null
    )
    //index-0-未读消息，1-已读消息
//    LaunchedEffect(true) {
//        if (index == 0) {
//            viewModel.getMessageUnread()
//        } else if (index == 1) {
//            viewModel.getMessageRead(viewModel.currentPage.value)
//        }
//    }


    if (index == 0) {
        viewModel.getMessageUnread()
        if (viewModel.messageUnReadList.isEmpty()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize().clickable {
                    if (TokenUtils.getUserInfo() == null){
                        RouteUtils.navTo(navCtrl, RouteName.LOGIN)
                    }
                }
            ) {
                LottieAnimation(loadingComposition, iterations = LottieConstants.IterateForever,)
                Text(
                    text = if (TokenUtils.getUserInfo() != null) "没有未读消息" else "用户未登录",
                    textAlign = TextAlign.Center
                )
            }

        } else {
            LazyColumn() {
                itemsIndexed(viewModel.messageUnReadList) { index, messageItem ->
                    MessageView(messageItem = messageItem)
                }
            }
        }

    } else if (index == 1) {
        viewModel.getMessageRead(viewModel.currentPage.value)
        if (viewModel.messageReadList.isEmpty()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize().clickable {
                    if (TokenUtils.getUserInfo() == null){
                        RouteUtils.navTo(navCtrl, RouteName.LOGIN)
                    }
                }
            ) {
                LottieAnimation(loadingComposition, iterations = LottieConstants.IterateForever)
                Text(
                    text = if (TokenUtils.getUserInfo() != null) "没有已读消息" else "用户未登录",
                    textAlign = TextAlign.Center
                )
            }
        } else {
            StatefulContent(content = {
                SwipeLazyColum(
                    swipeLazyColumState = viewModel.swipeLazyColumState,
                    onRefreshCallBack = {
                        viewModel.messageReadList.clear()
                        viewModel.currentPage.value = 0
                        viewModel.getMessageRead(viewModel.currentPage.value)
                    },
                    loadMoreCallBack = { viewModel.getMessageRead(viewModel.currentPage.value) },
                ) {
                    itemsIndexed(viewModel.messageReadList) { index, messageItem ->
                        MessageView(messageItem = messageItem)
                    }
                }
            }, state = viewModel.statefulState) {
                viewModel.getMessageRead(viewModel.currentPage.value)
            }
        }
    }

}