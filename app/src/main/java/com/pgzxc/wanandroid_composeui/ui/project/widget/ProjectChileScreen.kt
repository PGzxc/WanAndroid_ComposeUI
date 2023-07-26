package com.pgzxc.wanandroid_composeui.ui.project.widget

import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.pgzxc.wanandroid_composeui.ext.LocalNavController
import com.pgzxc.wanandroid_composeui.ui.entry.RouteName
import com.pgzxc.wanandroid_composeui.ui.project.viewmodel.ProjectViewModel
import com.pgzxc.wanandroid_composeui.utils.RouteUtils
import com.pgzxc.wanandroid_composeui.widget.ArticleListItem
import com.pgzxc.wanandroid_composeui.widget.refresh.SwipeLazyColum
import com.pgzxc.wanandroid_composeui.widget.state.StatefulContent

@Composable
internal fun ProjectChileScreen(
        viewModel: ProjectViewModel,
        cid: Long,
) {

    LaunchedEffect(true) {
        viewModel.projectItemListData.clear()
        viewModel.currentPage.value = 0
        viewModel.getProjectItemListData(page = viewModel.currentPage.value, cid = cid)
    }
    val projectItemListBean = viewModel.projectItemListData

    val navCtrl = LocalNavController.current
    StatefulContent(content = {
        SwipeLazyColum(
            swipeLazyColumState = viewModel.swipeLazyColumState,
            onRefreshCallBack = {
                viewModel.projectItemListData.clear()
                viewModel.currentPage.value = 0
                viewModel.getProjectItemListData(page = viewModel.currentPage.value, cid = cid)
            },
            loadMoreCallBack = {
                viewModel.getProjectItemListData(page = viewModel.currentPage.value, cid = cid)
            },
        ) {

            itemsIndexed(projectItemListBean) { index, temp ->
                ArticleListItem(item = temp, itemClick = { url ->
                    RouteUtils.navTo(
                        navCtrl,
                        RouteName.WEB_VIEW + "?link=${temp.link}&title=${temp.title}"
                    )
                }) {

                }
            }
        }
    }, state = viewModel.statefulState) {
        viewModel.getProjectItemListData(page = viewModel.currentPage.value, cid = cid)
    }

}