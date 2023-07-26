package com.pgzxc.wanandroid_composeui.ui.home.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.pgzxc.wanandroid_composeui.http.ApiCall
import com.pgzxc.wanandroid_composeui.base.BaseViewModel
import com.pgzxc.wanandroid_composeui.ext.onBizError
import com.pgzxc.wanandroid_composeui.ext.onBizOK
import com.pgzxc.wanandroid_composeui.ext.onFailure
import com.pgzxc.wanandroid_composeui.ext.onSuccess
import com.pgzxc.wanandroid_composeui.ext.serverData
import com.pgzxc.wanandroid_composeui.ui.home.model.Article
import com.pgzxc.wanandroid_composeui.ui.home.model.ArticleList
import com.pgzxc.wanandroid_composeui.ui.home.model.HomeBannerBean
import com.pgzxc.wanandroid_composeui.widget.BannerData

class HomeViewModel() : BaseViewModel() {
    val bannerLiveData by lazy {
        mutableStateListOf<BannerData>()
    }
    val articleList by lazy {
        mutableStateListOf<Article>()
    }
    val currentPage by lazy {
        mutableStateOf<Int>(0)
    }

    fun getHomeBannerData() = serverAwait {
        ApiCall.get().getHomeBanner().serverData().onSuccess {
            onBizError { code, message ->
                Log.e("xxx", "获取首页轮播图 接口异常 $code $message")
            }
            onBizOK<List<HomeBannerBean>> { code, data, message ->
                Log.e("xxx", "获取首页轮播图 接口正常 $code $data $message")
                val map = data?.map {
                    BannerData(title = it.title, imageUrl = it.imagePath, linkUrl = it.url)
                }
                bannerLiveData.addAll(map ?: emptyList())

            }
        }.onFailure {
            Log.e("xxx", "获取首页轮播图 接口异常 $it")
        }
    }

    fun getHomeArticleData(pageIndex: Int) = serverAwait {
        ApiCall.get().getHomeArticleList(page = pageIndex).serverData().onSuccess {
            onBizError { code, message ->
                Log.e("xxx", "获取首页文章列表 接口异常 $code $message")
                message?.let { this@HomeViewModel.showErrorUI(message) }
            }
            onBizOK<ArticleList> { code, data, message ->
                Log.e("xxx", "获取首页文章列表 接口正常 $code $data $message")
                currentPage.value++
                articleList.addAll(data?.datas ?: emptyList())
                if (data == null) {
                    this@HomeViewModel.showEmptyUI("EmptyUI")
                } else if (data.datas.size < 15) {
                    this@HomeViewModel.finishLoadMore(true)
                } else {
                    this@HomeViewModel.showContentUI()
                }

            }
        }.onFailure {
            Log.e("xxx", "获取首页文章列表 接口异常 $it")
            it.message?.let { msg -> this@HomeViewModel.showErrorUI(msg) }
        }
    }
}