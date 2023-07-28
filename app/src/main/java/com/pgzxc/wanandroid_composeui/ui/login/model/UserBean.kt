package com.pgzxc.wanandroid_composeui.ui.login.model

import com.google.gson.annotations.SerializedName

/**
 * @desc：登录接口实体类
 */
data class UserBean(@SerializedName("name") var data: UserInfo? = null,
                    @SerializedName("errorCode") val errorCode: Long,
                    @SerializedName("errorMsg") val errorMsg: String)

data class UserInfo(
        @SerializedName("admin") val admin: Boolean = false,
        @SerializedName("chapterTops") val chapterTops: List<Any?> = emptyList(),
        @SerializedName("coinCount") val coinCount: Long = 0,
        @SerializedName("collectIds") val collectIds: List<Long> = emptyList(),
        @SerializedName("email") val email: String = "",
        @SerializedName("icon") val icon: String = "",
        @SerializedName("id") val id: Long = 0,
        @SerializedName("nickname") val nickname: String = "",
        @SerializedName("password") val password: String = "",
        @SerializedName("publicName") val publicName: String = "",
        @SerializedName("token") val token: String = "",
        @SerializedName("type") val type: Long = 0,
        @SerializedName("username") val username: String = ""
)