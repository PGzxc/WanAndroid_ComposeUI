package com.pgzxc.wanandroid_composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pgzxc.wanandroid_composeui.theme.WanAndroid_ComposeUITheme
import com.pgzxc.wanandroid_composeui.ui.home.viewmodel.HomeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WanAndroid_ComposeUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Greeting("Android")
                }
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
        Button(onClick = { homeViewModel.getHomeArticleData() }) {
            Text(text = "首页-文章列表")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WanAndroid_ComposeUITheme {
        Greeting("Android")
    }
}