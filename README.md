**项目预览**


| ![][com-az-1] | ![][com-az-2]  | ![][com-az-3]  | ![][com-az-4]  |
| ------------- | -------------- | -------------- | -------------- |
| ![][com-az-5] | ![][com-az-6]  | ![][com-az-7]  | ![][com-az-8]  |
| ![][com-az-9] | ![][com-az-10] | ![][com-az-11] | ![][com-az-12] |




## 一  开发工具及环境

* Android Studio：Android Studio Flamingo| 2022.2.1 Patch2
* Java：17.0.6
* Gradle：8.0-bin
* Kotlin：1.7.20

## 二 开发周期

###  v1.0—网络请求及解析

* 网络请求：okhttp3+retrofit2
* cookie缓存：PersistentCookieJar
* 网络json转换：converter-gson
* MVVM模式：lifecycle-viewmodel-ktx、lifecycle-viewmodel-compose

###  V2.0—底部导航项目框架搭建

* Scaffold的bottomBar设置底部导航条
* NavHost导航切换时，显示对应界面

###  V3.0—首页

* accompanist-pager：定义Banner轮播图
* accompanist-swiperefresh：下拉刷新和下拉加载
* lottie-compose：多状态布局中动画
* Theme中定义全局CompositionLocalProvider，并设置系统状态栏
* navigation-compose：RouteUtils工具类，点击Banner和文章跳转网页显示
* accompanist-webview：显示网页内容

###  V4.0—导航

* accompanist-flowlayout：流式布局

### V5.0—项目

* ScrollableTabRow+HorizontalPager：Tab标题+滚动页面

### V6.0—我的+登录/注册

依赖：

* mmkv：保存用户信息
* ComposableSweetToast：弹窗

界面：

* 我的(未登录+已登录)
* 登录/注册

###  V7.0—消息

* 未读消息列表/已读消息列表

### V8.0—用户设置

* 退出(清除用户信息，清除Cookie，清楚Session)

### v9.0—CLI打包

* 添加action，打Tag包后，输出apk到Assets目录下

## 三 项目中用到的资源

* Icons：https://fonts.google.com/icons

## 四 compose基础

* [B站韦爵爷—合集·一起学习 Jetpack Compose 基础姿势](https://space.bilibili.com/1789177732/channel/collectiondetail?sid=193557)
* [B站韦爵爷—一起学习 Jetpack Compose 项目实战](https://www.bilibili.com/video/BV1aS4y1D7dv/)




[com-az-1]:https://cdn.staticaly.com/gh/PGzxc/CDN/master/blog-resume/compose-az-home-1.png
[com-az-2]:https://cdn.staticaly.com/gh/PGzxc/CDN/master/blog-resume/compose-az-tree-2.png
[com-az-3]:https://cdn.staticaly.com/gh/PGzxc/CDN/master/blog-resume/compose-az-project-3.png
[com-az-4]:https://cdn.staticaly.com/gh/PGzxc/CDN/master/blog-resume/compose-az-msg-4.png
[com-az-5]:https://cdn.staticaly.com/gh/PGzxc/CDN/master/blog-resume/compose-az-msg-5.png
[com-az-6]:https://cdn.staticaly.com/gh/PGzxc/CDN/master/blog-resume/compose-az-msg-6.png
[com-az-7]:https://cdn.staticaly.com/gh/PGzxc/CDN/master/blog-resume/compose-az-me-7.png
[com-az-8]:https://cdn.staticaly.com/gh/PGzxc/CDN/master/blog-resume/compose-az-me-8.png
[com-az-9]:https://cdn.staticaly.com/gh/PGzxc/CDN/master/blog-resume/compose-az-login-9.png
[com-az-10]:https://cdn.staticaly.com/gh/PGzxc/CDN/master/blog-resume/compose-az-login-10.png
[com-az-11]:https://cdn.staticaly.com/gh/PGzxc/CDN/master/blog-resume/compose-az-setting-11.png
[com-az-12]:https://cdn.staticaly.com/gh/PGzxc/CDN/master/blog-resume/compose-az-web-12.png