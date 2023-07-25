package com.pgzxc.wanandroid_composeui.ui.tree.model

import com.google.gson.annotations.SerializedName

/**
 * @desc：导航数据类
 */
data class TreeListBean(
        val data: List<TreeBean>,
        val errorCode: Long,
        val errorMsg: String
)

data class TreeBean(
        @SerializedName("articleList") val articleList: List<Any?> = listOf(),
        @SerializedName("author") val author: String = "",
        @SerializedName("children") val children: List<TreeItemBean> = listOf(),
        @SerializedName("courseId") val courseId: Long = 0,
        @SerializedName("cover") val cover: String = "",
        @SerializedName("desc") val desc: String = "",
        @SerializedName("id") val id: Long = 0,
        @SerializedName("lisense") val lisense: String = "",
        @SerializedName("lisenseLink") val lisenseLink: String = "",
        @SerializedName("name") val name: String = "",
        @SerializedName("order") val order: Long = 0,
        @SerializedName("parentChapterId") val parentChapterId: Long,
        @SerializedName("type") val type: Long = 0,
        @SerializedName("userControlSetTop") val userControlSetTop: Boolean = false,
        @SerializedName("visible") val visible: Long = 0
)

data class TreeItemBean(
        @SerializedName("articleList") val articleList: List<ArticleList> = listOf(),
        @SerializedName("author") val author: String = "",
        @SerializedName("children") val children: List<Any?> = listOf(),
        @SerializedName("courseId") val courseId: Long,
        @SerializedName("cover") val cover: String = "",
        @SerializedName("desc") val desc: String = "",
        @SerializedName("id") val id: Long = 0,
        @SerializedName("lisense") val lisense: String = "",
        @SerializedName("lisenseLink") val lisenseLink: String = "",
        @SerializedName("name") val name: String = "",
        @SerializedName("order") val order: Long = 0,
        @SerializedName("parentChapterId") val parentChapterId: Long = 0,
        @SerializedName("type") val type: Long = 0,
        @SerializedName("userControlSetTop") val userControlSetTop: Boolean = false,
        @SerializedName("visible") val visible: Long = 0
)

data class ArticleList(
        @SerializedName("adminAdd") val adminAdd: Boolean,
        @SerializedName("apkLink") val apkLink: String,
        @SerializedName("audit") val audit: Long,
        @SerializedName("author") val author: String,
        @SerializedName("canEdit") val canEdit: Boolean,
        @SerializedName("chapterId") val chapterId: Long,
        @SerializedName("chapterName") val chapterName: String,
        @SerializedName("collect") val collect: Boolean,
        @SerializedName("courseId") val courseId: Long,
        @SerializedName("desc") val desc: String,
        @SerializedName("descMd") val descMd: String,
        @SerializedName("envelopePic") val envelopePic: String,
        @SerializedName("fresh") val fresh: Boolean,
        @SerializedName("host") val host: String,
        @SerializedName("id") val id: Long,
        @SerializedName("isAdminAdd") val isAdminAdd: Boolean,
        @SerializedName("link") val link: String,
        @SerializedName("niceDate") val niceDate: String,
        @SerializedName("niceShareDate") val niceShareDate: String,
        @SerializedName("origin") val origin: String,
        @SerializedName("prefix") val prefix: String,
        @SerializedName("projectLink") val projectLink: String,
        @SerializedName("publishTime") val publishTime: Long,
        @SerializedName("realSuperChapterId") val realSuperChapterId: Long,
        @SerializedName("selfVisible") val selfVisible: Long,
        @SerializedName("shareDate") val shareDate: Long,
        @SerializedName("shareUser") val shareUser: String,
        @SerializedName("superChapterId") val superChapterId: Long,
        @SerializedName("superChapterName") val superChapterName: String,
        @SerializedName("tags") val tags: List<Any?>,
        @SerializedName("title") val title: String,
        @SerializedName("type") val type: Long,
        @SerializedName("userId") val userId: Long,
        @SerializedName("visible") val visible: Long,
        @SerializedName("zan") val zan: Long
)