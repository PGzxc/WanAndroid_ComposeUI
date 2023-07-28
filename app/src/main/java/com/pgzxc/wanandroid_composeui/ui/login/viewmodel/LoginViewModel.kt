package com.pgzxc.wanandroid_composeui.ui.login.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.pgzxc.wanandroid_composeui.base.BaseViewModel
import com.pgzxc.wanandroid_composeui.ext.onBizError
import com.pgzxc.wanandroid_composeui.ext.onBizOK
import com.pgzxc.wanandroid_composeui.ext.onFailure
import com.pgzxc.wanandroid_composeui.ext.onSuccess
import com.pgzxc.wanandroid_composeui.ext.serverData
import com.pgzxc.wanandroid_composeui.http.ApiCall
import com.pgzxc.wanandroid_composeui.ui.login.model.UserInfo
import com.pgzxc.wanandroid_composeui.utils.RouteUtils.back
import com.pgzxc.wanandroid_composeui.utils.TokenUtils
import com.talhafaki.composablesweettoast.util.SweetToastUtil
import kotlinx.coroutines.launch


class LoginViewModel : BaseViewModel() {

    //此处的修改无法改变，放在LoginPage中
    var isLogin by mutableStateOf(true)
    var account by mutableStateOf("")
    var password by mutableStateOf("")
    var rePassword by mutableStateOf("")

    fun updateUserName(temp: String) {
        account = temp
    }

    fun updatePassword(temp: String) {
        password = temp
    }

    fun updateRePassword(temp: String) {
        rePassword = temp
    }


    fun login(userName: String, passWord: String, navCtrl: NavHostController, context: Context) =
        serverAwait {
            Log.e("--", "${userName}--${passWord}")
            if (userName.isEmpty() || passWord.isEmpty()) {
                Toast.makeText(context, "用户名或密码为空", Toast.LENGTH_SHORT).show()
                //showToast("用户名或密码为空")
                return@serverAwait
            }
            ApiCall.get().login(userName, passWord).serverData().onSuccess {
                onBizError { code, message ->
                    Log.e("xxx", "登录 接口异常 $message")
                    Toast.makeText(context, "$message", Toast.LENGTH_SHORT).show()
                }
                onBizOK<UserInfo> { code, data, message ->
                    data?.let {
                        TokenUtils.setUserInfo(data)
                        navCtrl.back()
                    } //登录出灯光保存用户信息
                    Log.e("xxx", "登录 接口 $code---$data---$message")
                }
            }.onFailure {
                Toast.makeText(context, "$it", Toast.LENGTH_SHORT).show()
                Log.e("xxx", "登录 接口异常 $it")
            }
        }

    fun register(userName: String,
                 passWord: String,
                 rePassWord: String,
                 navCtrl: NavHostController,
                 context: Context) = serverAwait {
        Log.e("--", "${userName}--${passWord}--${rePassWord}")
        if (userName.isEmpty() || passWord.isEmpty() || rePassWord.isEmpty()) {
            Toast.makeText(context, "用户名或密码或确认密码为空", Toast.LENGTH_SHORT).show()
            return@serverAwait
        }
        if (userName != passWord) {
            Toast.makeText(context, "密码和确认密码不同", Toast.LENGTH_SHORT).show()
            return@serverAwait
        }
        ApiCall.get().register(userName, passWord, rePassWord).serverData().onSuccess {
            onBizError { code, message ->
                Toast.makeText(context, "$message", Toast.LENGTH_SHORT).show()
                Log.e("xxx", "注册 接口异常 $code---$message")
            }
            onBizOK<UserInfo> { code, data, message ->
                Log.e("xxx", "注册 接口 $code---$data---$message")
                data?.let {
                    TokenUtils.setUserInfo(data)
                    navCtrl.back()
                }
            }
        }
            .onFailure {
                Log.e("xxx", "登录 接口异常 $it")
                Toast.makeText(context, "$it", Toast.LENGTH_SHORT).show()
            }
    }

}