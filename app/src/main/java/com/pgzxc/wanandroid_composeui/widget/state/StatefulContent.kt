package com.pgzxc.wanandroid_composeui.widget.state

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.pgzxc.wanandroid_composeui.R

/**
 * 带状态的的页面布局
 * @param modifier Modifier
 * @param state StatefulContentState
 * @param content [@androidx.compose.runtime.Composable] Function0<Unit>
 * @param clickCallBack Function0<Unit>
 */
@Composable
fun StatefulContent(
    modifier: Modifier = Modifier,
    state: StatefulStateBean = StatefulStateBean(StatefulContentState.content),
    content: @Composable () -> Unit,
    clickCallBack: () -> Unit
) {
    when (state.state) {
        StatefulContentState.content -> {
            content()
        }
        StatefulContentState.loading -> {
            Box(modifier = Modifier
                .fillMaxSize()
                .clickable {
                    clickCallBack()
                }, contentAlignment = Alignment.Center) {
                //Text(text = (if (state.msg.isNullOrBlank()) "加载中.." else state.msg))
                val loadingComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loader_ring), cacheKey = null)
                LottieAnimation(
                    loadingComposition,
                    iterations = LottieConstants.IterateForever,
                )
            }
        }
        StatefulContentState.error -> {
            Column(modifier = Modifier
                .fillMaxSize()
                .clickable {
                    clickCallBack()
                }, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                val noNetComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.no_internet_connection), cacheKey = null)
                LottieAnimation(noNetComposition, iterations = LottieConstants.IterateForever,)
                Text(text = (if (state.msg.isNullOrBlank()) "网络错误，请稍后重试！" else state.msg))
            }
        }
        StatefulContentState.empty -> {
            Box(modifier = Modifier
                .fillMaxSize()
                .clickable {
                    clickCallBack()
                }, contentAlignment = Alignment.Center) {
                //Text(text = (if (state.msg.isNullOrBlank()) "暂无数据，请稍后重试！" else state.msg))
                val emptyComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.empty_box), cacheKey = null)
                LottieAnimation(emptyComposition, iterations = LottieConstants.IterateForever)
            }
        }
    }
}

