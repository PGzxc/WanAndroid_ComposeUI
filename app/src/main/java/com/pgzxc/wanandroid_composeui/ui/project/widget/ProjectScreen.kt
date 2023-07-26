package com.pgzxc.wanandroid_composeui.ui.project.widget

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.pgzxc.wanandroid_composeui.ui.project.model.ProjectBean
import com.pgzxc.wanandroid_composeui.ui.project.viewmodel.ProjectViewModel
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProjectScreen(viewModel: ProjectViewModel) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    val projectBeanList: List<ProjectBean> = viewModel.projectListData

    Column(modifier = Modifier.fillMaxSize()) {
        if (projectBeanList.isNotEmpty()) {
            ScrollableTabRow(
                selectedTabIndex = pagerState.currentPage,
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = MaterialTheme.colorScheme.onBackground,
            ) {
                projectBeanList.forEachIndexed { index, title ->
                    Tab(text = { Text(text = title.name, style = MaterialTheme.typography.titleMedium) },
                        selected = pagerState.currentPage == index,
                        onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } }
                    )
                }
            }
            HorizontalPager(
                pageCount = projectBeanList.size, state = pagerState,
                contentPadding = PaddingValues(0.dp), modifier = Modifier.weight(1f).fillMaxWidth(),
                key = { projectBeanList[it].id }
            ) { pageIndex ->
                ProjectChileScreen(viewModel = viewModel, cid = projectBeanList[pageIndex].id)
            }
        }else{
            Card {
                Box(Modifier.fillMaxSize()) {
                    Text(text = "暂无数据", modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)
                }
            }
        }
    }
}

