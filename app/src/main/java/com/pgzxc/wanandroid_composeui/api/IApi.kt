package com.pgzxc.wanandroid_composeui.api

import com.pgzxc.wanandroid_composeui.model.BaseResponse
import retrofit2.Call
import retrofit2.http.*

/**
 *@desc：接口
 */
interface IApi {

    @GET("banner/json")
    fun getHomeBanner(): Call<BaseResponse>

    @GET("article/list/{page}/json")
     fun getHomeArticleList(@Path("page") page: Int = 0): Call<BaseResponse>


}