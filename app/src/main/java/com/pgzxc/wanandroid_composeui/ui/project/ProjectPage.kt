package com.pgzxc.wanandroid_composeui.ui.project

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import com.pgzxc.wanandroid_composeui.ui.project.viewmodel.ProjectViewModel
import com.pgzxc.wanandroid_composeui.ui.project.widget.ProjectScreen

/**
 * 项目
 */

@Composable
fun ProjectPage(projectViewModel: ProjectViewModel = ProjectViewModel()) {

    LaunchedEffect(true) {
        projectViewModel.getProjectListData()
    }

    ProjectScreen(viewModel = projectViewModel)

}