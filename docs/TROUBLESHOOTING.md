# 常见问题及调试建议

在开发或使用过程中，如果遇到问题，可以参考以下解决方案。

## 1. 编译运行问题

*   **问题**: Gradle 同步失败，提示找不到 SDK。
    *   **解决**: 请确保在 Android Studio 中安装了 API 36 (Android 16)。如果尚未正式发布，请检查 `build.gradle.kts` 中的 `compileSdk` 和 `targetSdk` 是否与已安装的最高版本匹配。
*   **问题**: 在 M1 Mac 上运行模拟器非常慢。
    *   **解决**: 确保使用的是 "arm64-v8a" 架构的模拟器镜像。M1 芯片不支持 x86 镜像。
*   **问题**: 提示 "Execution failed for task ':app:kspDebugKotlin'".
    *   **解决**: 这是 Room 编译器的常见问题。请尝试 `./gradlew clean` 然后重新编译。确保 KSP 版本与 Kotlin 版本匹配。

## 2. 运行崩溃问题

*   **问题**: 点击保存账单时应用崩溃。
    *   **解决**: 检查 `etAmount.text.toString().toDouble()` 是否因为输入了非法字符导致 `NumberFormatException`。代码中已使用 `toDoubleOrNull()` 进行处理，请确保逻辑正确。
*   **问题**: 数据库操作报错。
    *   **解决**: 检查 `AppDatabase` 的版本号。如果修改了 `Bill` 或 `Task` 实体类，需要增加 `version` 并提供迁移逻辑，或者在开发阶段直接卸载应用重新安装。

## 3. 调试建议

*   **查看日志**: 使用 Android Studio 底部的 `Logcat` 工具，过滤 `TAG` 为 "PersonalManagement" 或查看 "Error" 级别的日志。
*   **数据库查看**: 使用 Android Studio 的 `App Inspection` 工具，可以实时查看和修改手机本地的 SQLite 数据库内容。
*   **布局检查**: 使用 `Layout Inspector` 检查 Material Design 组件的间距和层级，确保符合设计规范。
