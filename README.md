## 一  开发工具及环境

* Android Studio：Android Studio Flamingo| 2022.2.1 Patch2
* Java：17.0.6
* Gradle：8.0-bin
* Kotlin：1.7.20

## 二 开发周期

### 2.1 v1.0—网络请求及解析

* 网络请求：okhttp3+retrofit2
* cookie缓存：PersistentCookieJar
* 网络json转换：converter-gson
* MVVM模式：lifecycle-viewmodel-ktx、lifecycle-viewmodel-compose

### 2.2 V2.0—底部导航项目框架搭建

* Scaffold的bottomBar设置底部导航条
* NavHost导航切换时，显示对应界面

### 2.3 V3.0—首页

* accompanist-pager：定义Banner轮播图
* accompanist-swiperefresh：下拉刷新和下拉加载
* lottie-compose：多状态布局中动画
* Theme中定义全局CompositionLocalProvider，并设置系统状态栏
* navigation-compose：RouteUtils工具类，点击Banner和文章跳转网页显示
* accompanist-webview：显示网页内容

### 2.4 V4.0—导航

* accompanist-flowlayout：流式布局

### 2.5 V5.0—项目

* ScrollableTabRow+HorizontalPager：Tab标题+滚动页面



## 三 项目中用到的资源

* Icons：https://fonts.google.com/icons