package com.pgzxc.wanandroid_composeui.widget

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.pgzxc.wanandroid_composeui.R
import com.pgzxc.wanandroid_composeui.theme.Black
import com.pgzxc.wanandroid_composeui.theme.Blue
import com.pgzxc.wanandroid_composeui.theme.Gray
import com.pgzxc.wanandroid_composeui.theme.Purple
import com.pgzxc.wanandroid_composeui.theme.Purple40
import com.pgzxc.wanandroid_composeui.theme.Purple80
import com.pgzxc.wanandroid_composeui.theme.Red
import com.pgzxc.wanandroid_composeui.theme.White
import com.pgzxc.wanandroid_composeui.ui.home.model.Article

/**
 * 文章列表项
 * @param item Data
 */
@OptIn(ExperimentalAnimationApi::class, ExperimentalAnimationApi::class)
@Composable
fun ArticleListItem(
        item: Article,
        itemClick: (String) -> Unit,
        collectClick: (() -> Unit)?
) {

    Column(modifier = Modifier
        .clickable {
            itemClick(item.link!!)
        }
        .padding(vertical = 8.dp, horizontal = 10.dp)) {
        //第一行
        Row(verticalAlignment = Alignment.CenterVertically) {
            //Tag-新
            AnimatedVisibility(visible = item.fresh) {
                Text(
                    text = if (item.fresh) "新" else "",
                    Modifier
                        .background(Red, shape = RoundedCornerShape(2.dp))
                        .padding(horizontal = 5.dp),
                    color = White,
                    fontSize = 12.sp
                )
            }
            //Tag-项目
            AnimatedVisibility(visible = item.tags.isNotEmpty()) {
                Text(
                    modifier = Modifier
                        .padding(start = if (item.fresh) 8.dp else 0.dp)
                        .background(Blue, shape = RoundedCornerShape(2.dp))
                        .padding(horizontal = 5.dp),

                    text = "${item.tags[0].name}",
                    color = White,
                    fontSize = 12.sp
                )
            }
            Row(modifier = Modifier.padding(start = 8.dp)) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = item.getAuthor(),
                    modifier = Modifier.padding(start = 3.dp),
                    fontSize = 12.sp,
                    color = Black
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Row() {
                Icon(
                    imageVector = Icons.Default.Schedule,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = "${item.niceDate}",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 3.dp),
                )
            }
        }
        //第2行
        Row() {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "${item.title}",
                    color = colorResource(id = R.color.text_black),
                    fontSize = 16.sp,
                    modifier = Modifier.padding(vertical = 5.dp)
                )
                AnimatedVisibility(visible = item.desc.isNotEmpty()) {
                    Text(
                        text = "${item.desc}",
                        color = colorResource(id = R.color.text_gray),
                        fontSize = 14.sp,
                        modifier = Modifier.padding(vertical = 5.dp)
                    )
                }
            }
            AnimatedVisibility(visible = item.envelopePic.isNotEmpty()) {
                Image(
                    painter = rememberImagePainter(item.envelopePic),
                    modifier = Modifier.size(width = 90.dp, height = 120.dp),
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
            }
        }

        //第3行
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "${item.superChapterName}",
                fontSize = 12.sp,
                color = colorResource(id = R.color.white), modifier = Modifier
                    .background(Purple, shape = RoundedCornerShape(2.dp))
                    .padding(horizontal = 5.dp)
            )
            Text(
                text = "${item.chapterName}",
                fontSize = 12.sp,
                color = colorResource(
                    id = R.color.white
                ), modifier = Modifier
                    .padding(start = 8.dp)
                    .background(Purple40, shape = RoundedCornerShape(2.dp))
                    .padding(horizontal = 5.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Box(modifier = Modifier) {
                Icon(
                    imageVector = if (item.collect) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    tint = if (item.collect) Color.Red else Color.Gray,
                    modifier = Modifier.clickable {
                        collectClick?.invoke()
                    }
                )

//                if (!item.collect) {
//                    Icon(
//                        imageVector = Icons.Default.Favorite,
//                        contentDescription = null,
//                        tint = Gray,
//                        modifier = Modifier.clickable {
//                            collectClick?.invoke()
//                        }
//                    )
//                }
//                this@Row.AnimatedVisibility(
//                    visible = item.collect,
//                    enter = scaleIn(),
//                    exit = scaleOut()
//                ) {
//                    Icon(
//                        imageVector = Icons.Default.FavoriteBorder,
//                        contentDescription = null,
//                        tint = Red,
//                        modifier = Modifier.clickable {
//                            collectClick?.invoke()
//                        }
//                    )
//                }

            }
        }
    }
    Divider(
        modifier = Modifier.padding(top = 8.dp), thickness = 2.dp, color = colorResource(
            id = R.color.line_color
        )
    )
}