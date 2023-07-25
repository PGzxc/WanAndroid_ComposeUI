package com.pgzxc.wanandroid_composeui.ui.home

import android.util.Log
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import com.pgzxc.wanandroid_composeui.ext.LocalNavController
import com.pgzxc.wanandroid_composeui.ui.entry.RouteName
import com.pgzxc.wanandroid_composeui.ui.home.viewmodel.HomeViewModel
import com.pgzxc.wanandroid_composeui.utils.RouteUtils
import com.pgzxc.wanandroid_composeui.widget.ArticleListItem
import com.pgzxc.wanandroid_composeui.widget.Banner
import com.pgzxc.wanandroid_composeui.widget.TitleBar
import com.pgzxc.wanandroid_composeui.widget.refresh.SwipeLazyColum
import com.pgzxc.wanandroid_composeui.widget.state.StatefulContent

/**
 * 首页
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(homeViewModel: HomeViewModel = HomeViewModel()) {
    //val homeViewModel by lazy { HomeViewModel() }
    val navCtrl: NavHostController = LocalNavController.current
    LaunchedEffect(true) {
        homeViewModel.getHomeBannerData()
        homeViewModel.getHomeArticleData(pageIndex = 0)
    }
    StatefulContent(content = {
        SwipeLazyColum(
            swipeLazyColumState = homeViewModel.swipeLazyColumState,
            onRefreshCallBack = {
                homeViewModel.articleList.clear()
                homeViewModel.bannerLiveData.clear()
                homeViewModel.currentPage.value = 0
                homeViewModel.getHomeBannerData()
                homeViewModel.getHomeArticleData(pageIndex = 0)
            },
            loadMoreCallBack = {
                homeViewModel.getHomeArticleData(homeViewModel.currentPage.value)
            },
        ) {
            item {
                //轮播图
                TitleBar(title = "首页", rightIcon = Icons.Default.Search, rightCallBack = {

                })
            }
            item {
                Banner(list = homeViewModel.bannerLiveData, onClick = { link, title ->
                    RouteUtils.navTo(navCtrl, RouteName.WEB_VIEW + "?link=${link}&title=${title}")
                })
            }
            itemsIndexed(homeViewModel.articleList) { index, temp ->
                ArticleListItem(item = temp, itemClick = { url ->
                    RouteUtils.navTo(
                        navCtrl,
                        RouteName.WEB_VIEW + "?link=${temp.link}&title=${temp.title}"
                    )
                }) {

                }
            }
        }
    }, state = homeViewModel.statefulState) {
        //clickCallBack-失败重试
        homeViewModel.getHomeBannerData()
        homeViewModel.getHomeArticleData(pageIndex = 0)
    }
}