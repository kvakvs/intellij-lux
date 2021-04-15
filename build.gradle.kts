//import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
//    id("kotlin") version "1.4.30"
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

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version = "2021.1"
    // not found?    apply(plugin = "copyright")
    apply(plugin = "java")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

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