package com.pgzxc.wanandroid_composeui.widget

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.placeholder.material.placeholder
import com.pgzxc.wanandroid_composeui.theme.Gray
import com.pgzxc.wanandroid_composeui.theme.Purple
import com.pgzxc.wanandroid_composeui.theme.Purple40
import com.pgzxc.wanandroid_composeui.theme.Purple80
import com.pgzxc.wanandroid_composeui.theme.PurpleGrey40
import com.pgzxc.wanandroid_composeui.theme.White
import com.pgzxc.wanandroid_composeui.theme.themeColor
import com.pgzxc.wanandroid_composeui.ui.entry.BottomNavRoute
import com.pgzxc.wanandroid_composeui.ui.entry.RouteName
import org.jetbrains.annotations.NotNull


@Composable
fun BottomNavBarView(navCtrl: NavHostController) {
    val bottomNavList = listOf(
        BottomNavRoute.Home,
        BottomNavRoute.Tree,
        BottomNavRoute.Project,
        BottomNavRoute.Msg,
        BottomNavRoute.Me,
    )
    BottomNavigation {
        val navBackStackEntry by navCtrl.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination?.route ?: RouteName.HOME
        bottomNavList.forEach { screen ->
            BottomNavigationItem(
                modifier = Modifier.background(themeColor),
                icon = { Icon(imageVector = screen.icon, contentDescription = null) },
                label = { Text(text = stringResource(screen.stringId)) },
                selected = currentDestination == screen.routeName,
                onClick = {
                    println("BottomNavView当前路由 ===> ${currentDestination}")
                    println("当前路由栈 ===> ${navCtrl.graph.nodes}")
                    if (currentDestination != screen.routeName) {
                        navCtrl.navigate(screen.routeName) {
                            popUpTo(navCtrl.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                })
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LabelTextButton(
        @NotNull text: String,
        modifier: Modifier = Modifier,
        isSelect: Boolean = true,
        specTextColor: Color? = null,
        cornerValue: Dp = 25.dp / 2,
        isLoading: Boolean = false,
        onClick: (() -> Unit)? = null,
        onLongClick: (() -> Unit)? = null
) {
    Text(
        text = text,
        modifier = modifier
            .height(25.dp)
            //.clip(shape = RoundedCornerShape(cornerValue))
            .border(width = 1.dp, color = Purple, shape = RoundedCornerShape(3.dp) )
            //.background(color = if (isSelect && !isLoading) themeColor else PurpleGrey40,)
            .padding(horizontal = 5.dp, vertical = 3.dp)
            .combinedClickable(
                enabled = !isLoading,
                onClick = { onClick?.invoke() },
                onLongClick = { onLongClick?.invoke() }
            )
            //.placeholder(visible = isLoading, color = PurpleGrey40)
        ,
        fontSize = 13.sp,
        textAlign = TextAlign.Center,
        //color = specTextColor ?: if (isSelect) White else PurpleGrey40,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
    )
}

@Composable
fun ListTitle(
        modifier: Modifier = Modifier,
        title: String,
        subTitle: String = "",
        isLoading: Boolean = false,
        onSubtitleClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .placeholder(false)
            .fillMaxWidth()
            .height(45.dp)
            .background(color = Purple40),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            modifier = modifier.padding(horizontal = 10.dp),
            fontSize = 16.sp,
            color = White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Start
        )
    }
}




