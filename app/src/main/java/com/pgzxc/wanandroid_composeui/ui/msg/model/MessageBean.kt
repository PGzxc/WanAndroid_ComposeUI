package com.pgzxc.wanandroid_composeui.ui.msg.model

import com.google.gson.annotations.SerializedName

data class MessageResult(
        @SerializedName("data") val data: MessageBeanData,
        @SerializedName("errorCode") val errorCode: Long,
        @SerializedName("errorMsg") val errorMsg: String
)

data class MessageBeanData(
        @SerializedName("curPage") val curPage: Long = 0,
        @SerializedName("datas") val datas: List<MessageItem> = emptyList(),
        @SerializedName("offset") val offset: Long = 0,
        @SerializedName("over") val over: Boolean = false,
        @SerializedName("pageCount") val pageCount: Long = 0,
        @SerializedName("size") val size: Long = 0,
        @SerializedName("total") val total: Long = 0
)

data class MessageItem(
        @SerializedName("category") val category: Long = 0,
        @SerializedName("date") val date: Long = 0,
        @SerializedName("fromUser") val fromUser: String = "",
        @SerializedName("fromUserId") val fromUserId: Long = 0,
        @SerializedName("fullLink") val fullLink: String = "",
        @SerializedName("id") val id: Long = 0,
        @SerializedName("isRead") val isRead: Long = 0,
        @SerializedName("link") val link: String = "",
        @SerializedName("message") val message: String = "",
        @SerializedName("niceDate") val niceDate: String = "",
        @SerializedName("tag") val tag: String = "",
        @SerializedName("title") val title: String = "",
        @SerializedName("userId") val userId: Long = 0
)