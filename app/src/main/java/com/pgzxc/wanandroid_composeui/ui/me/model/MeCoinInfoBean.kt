package com.pgzxc.wanandroid_composeui.ui.me.model

import com.google.gson.annotations.SerializedName

data class MeCoinInfoBean(
        @SerializedName("data") val data: CoinInfo,
        @SerializedName("errorCode") val errorCode: Long,
        @SerializedName("errorMsg") val errorMsg: String
)

data class CoinInfo(
        @SerializedName("coinCount") val coinCount: Long = 0,
        @SerializedName("level") val level: Long = 0,
        @SerializedName("nickname") val nickname: String = "",
        @SerializedName("rank") val rank: String = "",
        @SerializedName("userId") val userId: Long = 0,
        @SerializedName("username") val username: String = ""
)
