package com.pgzxc.wanandroid_composeui.ui.login.model

import com.google.gson.annotations.SerializedName

/**
 * @desc：注册接口实体类
 */
data class RegisterBean(
        @SerializedName("data") val data: UserInfo,
        @SerializedName("errorCode") val errorCode: Long,
        @SerializedName("errorMsg") val errorMsg: String
)
//RegisterInfo==UserInfo
data class RegisterInfo(
        @SerializedName("admin") val admin: Boolean,
        @SerializedName("chapterTops") val chapterTops: List<Any?>,
        @SerializedName("coinCount") val coinCount: Long,
        @SerializedName("collectIDS") val collectIDS: List<Any?>,
        @SerializedName("email") val email: String,
        @SerializedName("icon") val icon: String,
        @SerializedName("id") val id: Long,
        @SerializedName("nickname") val nickname: String,
        @SerializedName("password") val password: String,
        @SerializedName("publicName") val publicName: String,
        @SerializedName("token") val token: String,
        @SerializedName("type") val type: Long,
        @SerializedName("username") val username: String
)