package com.pgzxc.wanandroid_composeui.ui.msg.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.pgzxc.wanandroid_composeui.base.BaseViewModel
import com.pgzxc.wanandroid_composeui.ext.onBizError
import com.pgzxc.wanandroid_composeui.ext.onBizOK
import com.pgzxc.wanandroid_composeui.ext.onFailure
import com.pgzxc.wanandroid_composeui.ext.onSuccess
import com.pgzxc.wanandroid_composeui.ext.serverData
import com.pgzxc.wanandroid_composeui.http.ApiCall
import com.pgzxc.wanandroid_composeui.ui.msg.model.MessageBeanData
import com.pgzxc.wanandroid_composeui.ui.msg.model.MessageItem

class MessageViewModel : BaseViewModel() {
    val currentPage by lazy {
        mutableStateOf<Int>(1)
    }

    val messageTitle = listOf("未读消息", "已读消息")
    val messageReadList by lazy { mutableStateListOf<MessageItem>() }
    val messageUnReadList by lazy { mutableStateListOf<MessageItem>() }

    fun getMessageUnread() = serverAwait {
        ApiCall.get().getMessageUnRead().serverData().onSuccess {
            onBizError { code, message ->
                Log.e("xxx", "消息未读 接口异常 $code---$message")
            }
            onBizOK<MessageBeanData> { code, data, message ->
                Log.e("xxx", "消息未读 接口 $code---$data---$message")
                messageUnReadList.addAll(data?.datas ?: emptyList())
            }
        }.onFailure {
            Log.e("xxx", "消息未读 接口异常 $it")
        }
    }

    fun getMessageRead(page: Int) = serverAwait {
        ApiCall.get().getMessageRead(page).serverData().onSuccess {
            onBizError { code, message ->
                Log.e("xxx", "消息已读 接口onBizError $code---$message")
                message?.let { this@MessageViewModel.showErrorUI(message) }
            }
            onBizOK<MessageBeanData> { code, data, message ->
                Log.e("xxx", "消息已读 接口 $code---$data---$message")
                if (data == null) {
                    this@MessageViewModel.showEmptyUI("EmptyUI")
                } else if (data.datas.size < 10) { //通过Api中的page_size设置
                    this@MessageViewModel.finishLoadMore(true)
                } else {
                    currentPage.value++
                    messageReadList.addAll(data?.datas ?: emptyList())
                    this@MessageViewModel.showContentUI()
                }
            }
        }.onFailure {
            Log.e("xxx", "消息已读 接口onFailure $it")
            it.message?.let { msg -> this@MessageViewModel.showErrorUI(msg) }
        }
    }

}