package com.pgzxc.wanandroid_composeui.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.pgzxc.wanandroid_composeui.ui.tree.model.TreeBean
import com.pgzxc.wanandroid_composeui.ui.tree.model.TreeItemBean

@Composable
fun TreeItem(
        itemBean: TreeBean,
        onSelect: (itemBean: TreeItemBean) -> Unit = {},
) {
    Column(modifier = Modifier.fillMaxWidth().padding(top = 10.dp)) {
        if (!itemBean.children.isNullOrEmpty()) {
            FlowRow(modifier = Modifier.padding(horizontal = 10.dp)) {
                for (item in itemBean.children!!) {
                    LabelTextButton(
                        text = item.name ?: "android",
                        modifier = Modifier.padding(start = 5.dp, bottom = 5.dp),
                        onClick = { onSelect(item) }
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}