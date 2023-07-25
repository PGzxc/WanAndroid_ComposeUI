package com.pgzxc.wanandroid_composeui.ui.tree.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import com.pgzxc.wanandroid_composeui.base.BaseViewModel
import com.pgzxc.wanandroid_composeui.ext.onBizError
import com.pgzxc.wanandroid_composeui.ext.onBizOK
import com.pgzxc.wanandroid_composeui.ext.onFailure
import com.pgzxc.wanandroid_composeui.ext.onSuccess
import com.pgzxc.wanandroid_composeui.ext.serverData
import com.pgzxc.wanandroid_composeui.http.ApiCall
import com.pgzxc.wanandroid_composeui.ui.tree.model.TreeBean

class TreeViewModel : BaseViewModel() {

    val treeListData by lazy {
        mutableStateListOf<TreeBean>()
    }

    fun getTreeData() = serverAwait {
        ApiCall.get().getTree().serverData().onSuccess {
            onBizError { code, message ->
                Log.e("xxx", "获取体系Tree接口异常 $code $message")
                message?.let { this@TreeViewModel.showErrorUI(message) }
            }
            onBizOK<List<TreeBean>> { code, data, message ->
                Log.e("xxx", "获取体系Tree 接口正常 $code $data $message")
                treeListData.addAll(data ?: emptyList())
                this@TreeViewModel.showContentUI()
            }
        }.onFailure {
            Log.e("xxx", "获获取体系Tree接口 接口异常 $it")
            it.message?.let { msg -> this@TreeViewModel.showErrorUI(msg) }
        }
    }
}