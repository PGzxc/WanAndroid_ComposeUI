package com.pgzxc.wanandroid_composeui.ui.entry

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.statusBarsPadding
import com.pgzxc.wanandroid_composeui.ui.home.HomePage
import com.pgzxc.wanandroid_composeui.ui.me.MePage
import com.pgzxc.wanandroid_composeui.ui.msg.MsgPage
import com.pgzxc.wanandroid_composeui.ui.project.ProjectPage
import com.pgzxc.wanandroid_composeui.ui.tree.TreePage
import com.pgzxc.wanandroid_composeui.widget.BottomNavBarView


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun AppScaffold() {
    val navCtrl = rememberNavController()
    val navBackStackEntry by navCtrl.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding(),
        bottomBar = {
            when (currentDestination?.route) {
                RouteName.HOME -> BottomNavBarView(navCtrl = navCtrl)
                RouteName.TREE -> BottomNavBarView(navCtrl = navCtrl)
                RouteName.PROJECT -> BottomNavBarView(navCtrl = navCtrl)
                RouteName.MSG -> BottomNavBarView(navCtrl = navCtrl)
                RouteName.ME -> BottomNavBarView(navCtrl = navCtrl)
            }
        },
        content = {
            var homeIndex = remember { 0 }
            var categoryIndex = remember { 0 }

            NavHost(
                modifier = Modifier.background(MaterialTheme.colors.background),
                navController = navCtrl,
                startDestination = RouteName.HOME
            ) {
                //首页
                composable(route = RouteName.HOME) {
                    HomePage()
                }

                //分类
                composable(route = RouteName.TREE) {
                    TreePage()
                }

                //项目
                composable(route = RouteName.PROJECT) {
                    ProjectPage()
                }
                //消息
                composable(route = RouteName.MSG) {
                    MsgPage()
                }
                //我的
                composable(route = RouteName.ME) {
                    MePage()
                }
            }
        },
    )
}