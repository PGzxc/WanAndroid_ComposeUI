package com.pgzxc.wanandroid_composeui.ext

import kotlinx.coroutines.Job

/**
 * @desc:添加Job到list中,Job扩展
 */
fun Job.addTo(list: MutableList<Job>) {
    list.add(this)
}