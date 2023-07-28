package com.pgzxc.wanandroid_composeui.ui.me.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.pgzxc.wanandroid_composeui.base.BaseViewModel
import com.pgzxc.wanandroid_composeui.ext.onBizError
import com.pgzxc.wanandroid_composeui.ext.onBizOK
import com.pgzxc.wanandroid_composeui.ext.onFailure
import com.pgzxc.wanandroid_composeui.ext.onSuccess
import com.pgzxc.wanandroid_composeui.ext.serverData
import com.pgzxc.wanandroid_composeui.http.ApiCall
import com.pgzxc.wanandroid_composeui.ui.me.model.CoinInfo
import com.pgzxc.wanandroid_composeui.ui.me.model.MeToolBean
import com.pgzxc.wanandroid_composeui.widget.BannerData

class MeViewModel : BaseViewModel() {
    val meToolsData by lazy {
        mutableStateListOf<MeToolBean>(
            MeToolBean("工具", Color.Blue),
            MeToolBean("问答", Color.Cyan),
            MeToolBean("消息", Color.Green),
            MeToolBean("课程", Color.Magenta),
            MeToolBean("待办清单", Color.LightGray),
            MeToolBean("分享文章", Color.Red),
        )
    }
    var coinInfo by mutableStateOf(CoinInfo())

    fun getCoinInfo() = serverAwait {
        ApiCall.get().getCoinUserInfo().serverData().onSuccess {
            onBizError { code, message ->
                Log.e("xxx", "积分 接口异常 $code---$message")
            }
            onBizOK<CoinInfo> { code, data, message ->
                Log.e("xxx", "积分 接口 $code---$data---$message")
                data?.let { coinInfo = data }
                print(coinInfo)
            }
        }.onFailure {
            Log.e("xxx", "积分 接口异常 $it")
        }
    }

}