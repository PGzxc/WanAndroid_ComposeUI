package com.pgzxc.wanandroid_composeui.ui.msg

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pgzxc.wanandroid_composeui.theme.themeColor
import com.pgzxc.wanandroid_composeui.ui.msg.viewmodel.MessageViewModel
import com.pgzxc.wanandroid_composeui.ui.msg.widget.MessageList
import com.pgzxc.wanandroid_composeui.widget.TitleBar
import kotlinx.coroutines.launch

/**
 * 消息
 */

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MsgPage(viewModel: MessageViewModel = MessageViewModel()) {

    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    val messageList = viewModel.messageTitle
    //var index by rememberSaveable { mutableStateOf(0) }


    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        //TitleBar(title = "消息")
        TabRow(
            //modifier =  Modifier.fillMaxWidth().height(54.dp),
            selectedTabIndex = pagerState.currentPage,
            backgroundColor = themeColor,
            contentColor = Color.Red
        ) {
            messageList.forEachIndexed { index, title ->
                Tab(text = { Text(text = title,
                            style = MaterialTheme.typography.titleMedium,
                            color = if (pagerState.currentPage == index) Color.Red else Color.White
                        )
                    },
                    selected = pagerState.currentPage == index,
                    onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                )
            }
        }
        HorizontalPager(pageCount = messageList.size,
            state = pagerState,
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            key = { messageList[it] }) { pageIndex ->
            MessageList(viewModel = viewModel, index = pageIndex)
        }
    }
}