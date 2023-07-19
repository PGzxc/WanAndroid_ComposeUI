package com.pgzxc.wanandroid_composeui.ui.entry

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.graphics.vector.ImageVector
import com.pgzxc.wanandroid_composeui.R

sealed class BottomNavRoute(var routeName: String,
                            @StringRes var stringId: Int,
                            var icon: ImageVector) {
 object Home:BottomNavRoute(RouteName.HOME, R.string.home,Icons.Default.Home)
 object Tree:BottomNavRoute(RouteName.TREE, R.string.tree,Icons.Default.List)
 object Project:BottomNavRoute(RouteName.PROJECT, R.string.project,Icons.Default.DateRange)
 object Msg:BottomNavRoute(RouteName.MSG, R.string.msg,Icons.Default.Email)
 object Me:BottomNavRoute(RouteName.ME, R.string.me,Icons.Default.Person)


}