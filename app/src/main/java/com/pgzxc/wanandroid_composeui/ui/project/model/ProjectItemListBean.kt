package com.pgzxc.wanandroid_composeui.ui.project.model

import com.google.gson.annotations.SerializedName
import com.pgzxc.wanandroid_composeui.ui.home.model.Article

data class ProjectItemListBean(
        @SerializedName("data") val data: ProjectItemListBeanData,
        @SerializedName("errorCode") val errorCode: Long,
        @SerializedName("errorMsg") val errorMsg: String
)

data class ProjectItemListBeanData(
        @SerializedName("curPage") val curPage: Long,
        @SerializedName("datas") val datas: List<Article>,
        @SerializedName("offset") val offset: Long,
        @SerializedName("over") val over: Boolean,
        @SerializedName("pageCount") val pageCount: Long,
        @SerializedName("size") val size: Long,
        @SerializedName("total") val total: Long
)

//data class ProjectItem(
//        @SerializedName("adminAdd") val adminAdd: Boolean,
//        @SerializedName("apkLink") val apkLink: String,
//        @SerializedName("audit") val audit: Long,
//        @SerializedName("author") val author: String,
//        @SerializedName("canEdit") val canEdit: Boolean,
//        @SerializedName("chapterId") val chapterId: Long,
//        @SerializedName("chapterName") val chapterName: String,
//        @SerializedName("collect") val collect: Boolean,
//        @SerializedName("courseId") val courseId: Long,
//        @SerializedName("desc") val desc: String,
//        @SerializedName("descMd") val descMd: String,
//        @SerializedName("envelopePic") val envelopePic: String,
//        @SerializedName("fresh") val fresh: Boolean,
//        @SerializedName("host") val host: String,
//        @SerializedName("id") val id: Long,
//        @SerializedName("isAdminAdd") val isAdminAdd: Boolean,
//        @SerializedName("link") val link: String,
//        @SerializedName("niceDate") val niceDate: String,
//        @SerializedName("niceShareDate") val niceShareDate: String,
//        @SerializedName("origin") val origin: String,
//        @SerializedName("prefix") val prefix: String,
//        @SerializedName("projectLink") val projectLink: String,
//        @SerializedName("publishTime") val publishTime: Long,
//        @SerializedName("realSuperChapterId") val realSuperChapterId: Long,
//        @SerializedName("selfVisible") val selfVisible: Long,
//        @SerializedName("shareDate") val shareDate: Long,
//        @SerializedName("shareUser") val shareUser: String,
//        @SerializedName("superChapterId") val superChapterId: Long,
//        @SerializedName("superChapterName") val superChapterName: String,
//        @SerializedName("tags") val tags: List<Tag>,
//        @SerializedName("title") val title: String,
//        @SerializedName("type") val type: Long,
//        @SerializedName("userId") val userId: Long,
//        @SerializedName("visible") val visible: Long,
//        @SerializedName("zan") val zan: Long
//)
//
//data class Tag(
//        @SerializedName("name") val name: String,
//        @SerializedName("url") val url: String
//)