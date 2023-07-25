package com.pgzxc.wanandroid_composeui.ui.tree

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.pgzxc.wanandroid_composeui.ui.tree.viewmodel.TreeViewModel
import com.pgzxc.wanandroid_composeui.widget.ListTitle
import com.pgzxc.wanandroid_composeui.widget.TitleBar
import com.pgzxc.wanandroid_composeui.widget.TreeItem
import com.pgzxc.wanandroid_composeui.widget.state.StatefulContent

/**
 * 导航
 */

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TreePage(treeViewModel: TreeViewModel = TreeViewModel()) {

    LaunchedEffect(true) {
        treeViewModel.getTreeData()
    }
    StatefulContent(content = {
        LazyColumn() {
            item { TitleBar(title = "体系") }
            treeViewModel.treeListData.forEachIndexed { index, treeBean ->
                stickyHeader { ListTitle(title = treeBean.name ?: "标题") }
                item {
                    TreeItem(treeBean, onSelect = { parent -> })
                }
            }
        }
    }, state = treeViewModel.statefulState) {
        treeViewModel.getTreeData() //clickCallBack-失败重试
    }
}