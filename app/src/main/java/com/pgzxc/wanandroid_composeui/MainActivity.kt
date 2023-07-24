package com.pgzxc.wanandroid_composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
//import androidx.compose.material.Button
//import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pgzxc.wanandroid_composeui.theme.WanAndroid_ComposeUITheme
import com.pgzxc.wanandroid_composeui.ui.entry.AppScaffold
import com.pgzxc.wanandroid_composeui.ui.home.viewmodel.HomeViewModel

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WanAndroid_ComposeUITheme {
                AppScaffold()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val homeViewModel: HomeViewModel = viewModel()
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "接口测试", modifier = Modifier)
        Button(onClick = { homeViewModel.getHomeBannerData() }) {
            Text(text = "首页-轮播图")
        }
        Button(onClick = { homeViewModel.getHomeArticleData(pageIndex = 0) }) {
            Text(text = "首页-文章列表")
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WanAndroid_ComposeUITheme {
        AppScaffold()
        //Greeting("Android")
    }
}