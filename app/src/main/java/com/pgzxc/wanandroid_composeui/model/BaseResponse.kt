package com.pgzxc.wanandroid_composeui.model

import androidx.annotation.Keep

/**
 * @desc:服务器返回的数据基类
 */
@Keep
data class BaseResponse(

    //接口数据
    val data: Any?,

    //接口状态码
    val errorCode: Int,

    //接口出错消息
    val errorMsg: String = ""
) {
    companion object {
        const val SERVER_CODE_SUCCESS = 0 //接口请求响应业务处理 成功
    }
}