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
    fun getProjectItem(@Path("page") page: Int = 0, @Query("cid") cid: Long): Call<BaseResponse>

    //登录----接口
    @POST("user/login")
    fun login(@Query("username") username: String,
              @Query("password") password: String): Call<BaseResponse>

    //注册----接口
    @POST("user/register")
    fun register(@Query("username") username: String,
                 @Query("password") password: String,
                 @Query("repassword") repassword: String): Call<BaseResponse>
    //积分---接口
    @GET("lg/coin/userinfo/json") //获取个人积分，需要登录后访问
    fun getCoinUserInfo(): Call<BaseResponse>

}