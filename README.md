# 个人助手 (Personal Management) Android 应用

这是一个专为小米 13 Ultra (Snapdragon 8 Gen 2, Android 16) 设计并开发的个人管理类 Android 应用。采用 Kotlin 编写，使用 Material 3 设计规范，具有简洁直观的 UI。

## 主要功能

*   **记账模块**: 
    *   手动录入、编辑、删除和查询账单。
    *   本地 SQLite (Room) 存储。
    *   日、月、季、年多维度支出统计图表。
*   **日程模块**:
    *   今日总结：记录已完成的事项及心得。
    *   明日安排：创建和管理待办事项，支持优先级和时间设置。
    *   事项勾选完成功能。

## 技术选型

*   **开发语言**: Kotlin
*   **架构模式**: MVVM (ViewModel + LiveData)
*   **本地存储**: Room (SQLite)
*   **界面组件**: Material Design 3, BottomNavigationView, ViewBinding
*   **图表库**: MPAndroidChart
*   **导航**: Jetpack Navigation

## 文档指引

*   [开发环境搭建指南](docs/DEVELOPMENT_GUIDE.md)
*   [安装及使用教程](docs/INSTALLATION_GUIDE.md)
*   [常见问题及调试建议](docs/TROUBLESHOOTING.md)

## 编译说明

在 Android Studio 中打开项目，点击 `Build` -> `Build Bundle(s) / APK(s)` -> `Build APK(s)` 即可生成安装包。生成的 APK 路径通常为 `app/build/outputs/apk/debug/app-debug.apk`。
