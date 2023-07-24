package com.pgzxc.wanandroid_composeui.widget

import androidx.compose.foundation.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.pgzxc.wanandroid_composeui.theme.themeColor
import com.pgzxc.wanandroid_composeui.ui.entry.BottomNavRoute
import com.pgzxc.wanandroid_composeui.ui.entry.RouteName


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
        val currentDestination = navBackStackEntry?.destination?.route?:RouteName.HOME
        bottomNavList.forEach { screen ->
            BottomNavigationItem(
                modifier = Modifier.background(themeColor),
                icon = { Icon(imageVector = screen.icon, contentDescription = null) },
                label = { Text(text = stringResource(screen.stringId)) },
                selected = currentDestination== screen.routeName,
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





