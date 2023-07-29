package com.pgzxc.wanandroid_composeui.ext

import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import com.pgzxc.wanandroid_composeui.WanApplication

/**
 * @explain:常量
 * */
object Constants {
    const val BASE_URL = "https://www.wanandroid.com/"

    val PAGE_START = 0

    val PAGE_SIZE = 20

    //永久存储Cookie单例
    val persistentCookieJar = PersistentCookieJar(
        SetCookieCache(), SharedPrefsCookiePersistor(
        WanApplication.context)
    )
}