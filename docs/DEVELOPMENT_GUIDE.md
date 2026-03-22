# 个人助手应用开发环境搭建指南

本项目是一个基于 Kotlin 开发的 Android 个人管理类应用，针对 Mac M1 芯片和小米 13 Ultra（Android 16）进行了优化。

## 1. 开发环境要求

*   **操作系统**: macOS (推荐 M1/M2/M3 芯片)
*   **IDE**: Android Studio Hedgehog (2023.1.1) 或更高版本
*   **JDK**: Java 17 (Android Studio 自带)
*   **Android SDK**: API 36 (Android 16)
*   **Gradle**: 8.2 (禁止升级至 Gradle 9.x，以避免插件不兼容问题)
*   **JDK**: Java 17 (与 Gradle 8.2 兼容)

## 2. 搭建步骤

1.  **下载并安装 Android Studio**:
    *   从 [Android 开发者官网](https://developer.android.com/studio) 下载适用于 Mac (Apple Chip) 的版本。
2.  **配置 SDK 与 Gradle**:
    *   打开 Android Studio -> Settings -> Languages & Frameworks -> Android SDK。
    *   在 SDK Platforms 中勾选 "Android 16.0 (VanillaIceCream)" 或对应 API 36 的版本。
    *   在 `Settings > Build Tools > Gradle` 中，将 `Gradle JVM` 指向 JDK 17，并选择 `Use Gradle from: 'gradle-wrapper.properties'`。
    *   **重要**: 如果遇到 `HasConvention` 错误，请确保 `gradle/wrapper/gradle-wrapper.properties` 中的 `distributionUrl` 指向 8.2 或 8.5 版本，并建议使用腾讯云镜像加速：
        ```properties
        distributionUrl=https\://mirrors.cloud.tencent.com/gradle/gradle-8.2-bin.zip
        ```
        并执行 `./gradlew clean build --refresh-dependencies`。
3.  **导入项目**:
    *   选择 "Open" 并指向项目根目录 `PersonalManagement`。
    *   等待 Gradle 同步完成。由于是 M1 芯片，同步速度会非常快。
4.  **运行项目**:
    *   连接小米 13 Ultra 手机，开启 "开发者选项" 和 "USB 调试"。
    *   在 Android Studio 顶部运行配置中选择你的设备，点击绿色运行按钮。

## 3. 代码结构说明

*   `com.personal.management`: 根包名。
    *   `MainActivity`: 主界面，控制底部导航。
    *   `data`: 数据层。
        *   `AppDatabase`: Room 数据库入口。
        *   `Bill`, `BillDao`: 记账模块实体与 DAO。
        *   `Task`, `TaskDao`: 日程模块实体与 DAO。
    *   `ui`: 界面层。
        *   `accounting`: 记账模块（Fragment, ViewModel, Activity, Adapter）。
        *   `schedule`: 日程模块（Fragment, ViewModel, Activity, Adapter）。
*   `res`: 资源文件。
    *   `layout`: 布局 XML。
    *   `menu`: 菜单定义。
    *   `navigation`: 导航图定义。

## 4. 技术选型理由

*   **Kotlin**: 官方推荐语言，语法简洁，空安全，适合初学者。
*   **Room (SQLite)**: Google 推荐的本地存储方案，比原始 SQLite 更易用且安全。
*   **Jetpack Navigation**: 简化 Fragment 切换逻辑。
*   **ViewBinding**: 替代 `findViewById`，减少模板代码并提高类型安全。
*   **MPAndroidChart**: 轻量级图表库，满足统计报表需求。
