# androidResKmp

一个面向 Android 开发资源整理场景的桌面工具（`Kotlin Multiplatform + Compose Multiplatform`），当前主要在 **Desktop (JVM)** 端使用。

## 项目简介

在 Android 开发中，同一张图往往需要多尺寸版本（如 `drawable-xhdpi`、`drawable-xxhdpi`、`drawable-xxxhdpi`）。  
但设计资源下载后常出现两个问题：

- 多个尺寸文件混在同一个目录里
- 文件名是 UI 命名，不是项目内最终可用命名

本项目就是为了解决这个整理过程：  
将这些“来源杂乱、命名不统一”的图片，快速整理为 **不同尺寸目录下、同一业务名称** 的标准 Android 资源文件。

当前默认资源根目录配置在：

- `composeApp/src/commonMain/kotlin/personal/lzy/androidres/ui/GlobalModel.kt`
- 常量：`GlobalModel.RES_PATH`

## 主要功能（当前实现）

- 读取资源根目录，展示当前可用的归类目录与图片项
- 新建归类目录（例如新增一组待整理资源）
- 选择源文件并放入目标目录，完成基础归档
- 以“目标文件名”为单位补齐缺失尺寸图片（同名补全）
- 在系统文件管理器中直接打开资源目录（Desktop）

## 平台支持现状

- Desktop (JVM)：已实现主要功能，入口为 `MainScreen`
- Android：入口仍为示例 `App()`，文件能力未完整实现
- iOS：文件能力未实现（占位实现）

## 项目结构

- `composeApp/src/commonMain`：跨平台共享逻辑与 UI
  - `ui/main`：主界面、事件与业务流程
  - `platform/PlatformFileApi.kt`：文件操作抽象接口（`expect`）
- `composeApp/src/jvmMain`：Desktop 实现（`actual`），包含可运行入口
- `composeApp/src/androidMain`：Android 入口与 Android 平台实现（当前为占位）
- `composeApp/src/iosMain`：iOS 平台实现（当前为占位）
- `iosApp`：iOS 容器工程

## 运行方式（Windows）

### 运行 Desktop 应用（推荐）

```powershell
.\gradlew.bat :composeApp:run
```

### 构建 Android Debug 包

```powershell
.\gradlew.bat :composeApp:assembleDebug
```

## 技术栈

- Kotlin Multiplatform
- Compose Multiplatform
- Material 3
- Gradle Kotlin DSL
