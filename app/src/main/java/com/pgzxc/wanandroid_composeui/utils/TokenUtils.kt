package com.pgzxc.wanandroid_composeui.utils

import android.content.Context
import com.google.gson.Gson
import com.pgzxc.wanandroid_composeui.ext.Constants
import com.pgzxc.wanandroid_composeui.ui.login.model.UserInfo
import com.tencent.mmkv.MMKV

/**
 * Token管理工具
 *
 */
object TokenUtils {


    private const val KEY_PROFILE = "com.pgzxc.utils.KEY_PROFILE"

    /**
     * 初始化Token信息
     */
    fun init(context: Context?) {
        MMKV.initialize(context)
        MMKV.defaultMMKV()
    }

    private fun cleanCookie() {
        Constants.persistentCookieJar.clear() //清除Cookie
        Constants.persistentCookieJar.clearSession() //清除Session

    }

    /**
     * 处理登出的事件
     */
    fun handleLogoutSuccess() {
        //登出时，清除账号信息
        //clearToken()
        cleanCookie()
        clearProfile()
    }

    fun getUserInfo(): UserInfo? {
        if (MMKV.defaultMMKV().containsKey(KEY_PROFILE)) {
            val s = MMKV.defaultMMKV().getString(KEY_PROFILE, null)
            if (!s!!.isEmpty()) {
                return Gson().fromJson(s, UserInfo::class.java)
            }
        }
        return null
    }

    fun setUserInfo(userInfo: UserInfo) {
        val p = Gson().toJson(userInfo)
        MMKV.defaultMMKV().putString(KEY_PROFILE, p)
    }


    fun clearProfile() {
        MMKV.defaultMMKV().remove(KEY_PROFILE)
    }

}