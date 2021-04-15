//import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    id("org.jetbrains.kotlin.jvm") version "1.4.32"
    id("org.jetbrains.intellij") version "0.7.2"
}

//group "se.clau.intellij-lux"
//version "1.0"

repositories {
    mavenCentral()
}
//dependencies {
//    testImplementation(group: "junit", name: "junit", version: "4.12")
//}

intellij { // See https://github.com/JetBrains/gradle-intellij-plugin/
    version = "2021.1"
    // not found?    apply(plugin = "copyright")
    apply(plugin = "java")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

val compileKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks
compileKotlin.kotlinOptions.freeCompilerArgs += "-Xjvm-default=enable"
compileKotlin.kotlinOptions.jvmTarget = "11"

//compileJava { options.encoding = "UTF-8" }

allprojects {
    sourceSets {
        main {
            java.srcDirs("src", "gen")
            resources.srcDirs("resources")
        }
    }
}

//tasks.withType<KotlinCompile>().configureEach {
//    kotlinOptions {
//        useIR = true
//    }
//}