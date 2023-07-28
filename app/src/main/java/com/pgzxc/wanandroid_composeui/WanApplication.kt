package com.pgzxc.wanandroid_composeui

import android.app.Application
import android.content.Context
import com.pgzxc.wanandroid_composeui.utils.TokenUtils

class WanApplication : Application() {
    companion object {
        lateinit var context: Context
    }
    override fun onCreate() {
        super.onCreate()
        context = this
        TokenUtils.init(context)
    }
}