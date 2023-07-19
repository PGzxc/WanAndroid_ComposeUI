package com.pgzxc.wanandroid_composeui.ui.home.viewmodel

import android.util.Log
import com.pgzxc.wanandroid_composeui.http.ApiCall
import com.pgzxc.wanandroid_composeui.base.BaseViewModel
import com.pgzxc.wanandroid_composeui.ext.onBizError
import com.pgzxc.wanandroid_composeui.ext.onBizOK
import com.pgzxc.wanandroid_composeui.ext.onFailure
import com.pgzxc.wanandroid_composeui.ext.onSuccess
import com.pgzxc.wanandroid_composeui.ext.serverData
import com.pgzxc.wanandroid_composeui.ui.home.model.ArticleList
import com.pgzxc.wanandroid_composeui.ui.home.model.HomeBannerData

class HomeViewModel : BaseViewModel() {

    fun getHomeBannerData() = serverAwait {

        ApiCall.get().getHomeBanner().serverData().onSuccess {
            onBizError { code, message ->
                Log.e("xxx", "获取首页轮播图 接口异常 $code $message")
            }
            onBizOK<List<HomeBannerData>> { code, data, message ->

                Log.e("xxx", "获取首页轮播图 接口正常 $code $data $message")
            }
        }.onFailure {
            Log.e("xxx", "获取首页轮播图 接口异常 $it")
        }
    }

    fun getHomeArticleData() = serverAwait {
        ApiCall.get().getHomeArticleList().serverData().onSuccess {
            onBizError { code, message ->
                Log.e("xxx", "获取首页文章列表 接口异常 $code $message")
            }
            onBizOK<ArticleList> { code, data, message ->
                Log.e("xxx", "获取首页文章列表 接口正常 $code $data $message")
            }
        }.onFailure {
            Log.e("xxx", "获取首页文章列表 接口异常 $it")
        }

    }

}