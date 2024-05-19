import extension.commonDependencies
import extension.setFrameworkBaseName
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    id("com.escodro.multiplatform")
    id("kotlin-parcelize")
    alias(libs.plugins.compose)
}

kotlin {
    setFrameworkBaseName("navigation")

    commonDependencies {
        implementation(projects.libraries.parcelable)
        implementation(compose.runtime)
        implementation(compose.material)

        api(libs.voyager.navigator)
        api(libs.voyager.bottomsheet)

        implementation(libs.moko.parcelize)
    }

    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            freeCompilerArgs.addAll(
                "-P",
                "plugin:org.jetbrains.kotlin.parcelize:additionalAnnotation=com.escodro.parcelable.CommonParcelize"
            )
        }
    }
}

android {
    namespace = "com.escodro.navigation"
}
