package com.pgzxc.wanandroid_composeui

import android.app.Application
import android.content.Context

class WanApplication : Application() {
    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}