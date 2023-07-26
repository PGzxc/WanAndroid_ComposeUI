package com.pgzxc.wanandroid_composeui.ui.project.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.pgzxc.wanandroid_composeui.base.BaseViewModel
import com.pgzxc.wanandroid_composeui.ext.onBizError
import com.pgzxc.wanandroid_composeui.ext.onBizOK
import com.pgzxc.wanandroid_composeui.ext.onFailure
import com.pgzxc.wanandroid_composeui.ext.onSuccess
import com.pgzxc.wanandroid_composeui.ext.serverData
import com.pgzxc.wanandroid_composeui.http.ApiCall
import com.pgzxc.wanandroid_composeui.ui.home.model.Article
import com.pgzxc.wanandroid_composeui.ui.project.model.ProjectBean
import com.pgzxc.wanandroid_composeui.ui.project.model.ProjectItemListBeanData

class ProjectViewModel : BaseViewModel() {

    val projectListData by lazy {
        mutableStateListOf<ProjectBean>()
    }
    val projectItemListData by lazy {
        mutableStateListOf<Article>()
    }
    val currentPage by lazy {
        mutableStateOf<Int>(0)
    }

    fun getProjectListData() = serverAwait {
        ApiCall.get().getProject().serverData().onSuccess {
            onBizError { code, message ->
                Log.e("xxx", "获取项目 接口异常 $code $message")
            }
            onBizOK<List<ProjectBean>> { code, data, message ->
                Log.e("xxx", "获取项目 接口正常 $code $data $message")
                projectListData.addAll(data ?: emptyList())

            }
        }.onFailure {
            Log.e("xxx", "获取项目 接口异常 $it")
        }
    }

    fun getProjectItemListData(page: Int, cid: Long) = serverAwait {
        ApiCall.get().getProjectItem(page = page, cid = cid).serverData().onSuccess {

            onBizError { code, message ->
                Log.e("xxx", "获取项目-Item 接口异常 $code $message")
                message?.let { this@ProjectViewModel.showErrorUI(message) }
            }
            onBizOK<ProjectItemListBeanData> { code, data, message ->

                currentPage.value++
                projectItemListData.addAll(data?.datas ?: emptyList())
                if (data == null) {
                    this@ProjectViewModel.showEmptyUI("EmptyUI")
                } else if (data.datas.size < 15) {
                    this@ProjectViewModel.finishLoadMore(true)
                } else {
                    this@ProjectViewModel.showContentUI()
                }
            }

        }.onFailure {
            Log.e("xxx", "获取项目-Item 接口异常 $it")
            it.message?.let { msg -> this@ProjectViewModel.showErrorUI(msg) }
        }
    }
}