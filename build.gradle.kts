plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
    id("com.google.devtools.ksp") version "1.9.10-1.0.13" apply false
}

// 显式声明 Gradle 版本以覆盖 IDE 默认行为
tasks.wrapper {
    gradleVersion = "8.2"
    distributionType = Wrapper.DistributionType.BIN
}
