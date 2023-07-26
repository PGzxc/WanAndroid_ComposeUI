package com.pgzxc.wanandroid_composeui.api

import com.pgzxc.wanandroid_composeui.model.BaseResponse
import retrofit2.Call
import retrofit2.http.*

/**
 *@desc：接口
 */
interface IApi {

    //首页----接口
    @GET("banner/json")
    fun getHomeBanner(): Call<BaseResponse>

    @GET("article/list/{page}/json")
    fun getHomeArticleList(@Path("page") page: Int = 0): Call<BaseResponse>

    //导航----接口
    @GET("tree/json")
    fun getTree(): Call<BaseResponse>

    //项目----接口
    @GET("project/tree/json") //项目分类
    fun getProject(): Call<BaseResponse>

    @GET("project/list/{page}/json") //项目列表
    fun getProjectItem(@Path("page") page: Int = 0,@Query("cid") cid: Long): Call<BaseResponse>

}