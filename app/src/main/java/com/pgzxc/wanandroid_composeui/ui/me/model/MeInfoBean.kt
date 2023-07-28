package com.pgzxc.wanandroid_composeui.ui.me.model

import com.google.gson.annotations.SerializedName

data class MeInfoBean(@SerializedName("name") var name: String? = null,
                      @SerializedName("value") var value: String? = null) {
}