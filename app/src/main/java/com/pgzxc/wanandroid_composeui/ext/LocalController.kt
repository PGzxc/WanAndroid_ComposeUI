package com.pgzxc.wanandroid_composeui.ext

import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.SystemUiController


val LocalNavController = compositionLocalOf<NavHostController> {
    error("Not Init LocalNavController")
}
val LocalSystemUiController = compositionLocalOf<SystemUiController> {
    error("Not Init LocalSystemUiController")
}