import org.gradle.api.internal.HasConvention
//import org.jetbrains.grammarkit.tasks.GenerateLexerTask
//import org.jetbrains.grammarkit.tasks.GenerateParserTask
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  idea
  java
  id("org.jetbrains.kotlin.jvm") version "1.8.22"
  id("org.jetbrains.intellij") version "1.17.3"
  id("org.jetbrains.grammarkit") version "2022.3.2.2"
}

val intellijVersion = prop("intellijVersion")
val intelliLangPlugin = "org.intellij.intelliLang"
val psiViewerPluginVersion = prop("psiViewerPluginVersion")
val psiViewerPlugin = "PsiViewer:${prop("psiViewerPluginVersion")}"

repositories {
  // mavenCentral()
  maven("https://oss.sonatype.org/content/repositories/snapshots/")
  gradlePluginPortal()
}

allprojects {
  intellij {
    // See https://github.com/JetBrains/gradle-intellij-plugin/
    version.set(intellijVersion)
    apply(plugin = "java")
  }
}

java {
  sourceCompatibility = JavaVersion.VERSION_17
  targetCompatibility = JavaVersion.VERSION_17
}

//val compileKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks
//compileKotlin.kotlinOptions.freeCompilerArgs += "-Xjvm-default=enable"
//compileKotlin.kotlinOptions.jvmTarget = "17"
tasks.withType(KotlinCompile::class).all {
  kotlinOptions {
    jvmTarget = "17"
    freeCompilerArgs = listOf("-Xjvm-default=enable")
  }
}

allprojects {
  sourceSets {
    main {
      java.srcDirs("src")
      kotlin.srcDirs("src")

      resources.srcDirs("resources")
    }
  }

  idea {
    module {
      generatedSourceDirs.add(file("src/se/clau/intellijlux/gen/"))
    }
  }

  intellij {
    plugins.set(
      listOf(
        intelliLangPlugin,
        // psiViewerPlugin
      )
    )
  }

//  val generateLuxLexer = task<GenerateLexerTask>("generateLuxLexer") {
//    source = "src/grammars/lux-lexer.flex"
//    targetDir = "src/se/clau/intellijlux/gen/lexer"
//    targetClass = "_LuxLexer"
//    purgeOldFiles = true
//  }
//
//  val generateLuxParser = task<GenerateParserTask>("generateLuxParser") {
//    source = "src/grammars/lux-parser.bnf"
//    targetRoot = "src"
//    pathToParser = "/se/clau/intellijlux/gen/parser/LuxParser.java"
//    pathToPsiRoot = "/se/clau/intellijlux/gen/psi"
//    purgeOldFiles = true
//  }

//  tasks.withType<KotlinCompile> {
//    dependsOn(
//      generateLuxLexer, generateLuxParser
//    )
//  }

  tasks {
    runIde {
      jvmArgs("-Xmx2000m")
    }
  }
}

fun prop(name: String): String =
  extra.properties[name] as? String
    ?: error("Property `$name` is not defined in gradle.properties")

val SourceSet.kotlin: SourceDirectorySet
  get() =
    (this as HasConvention)
      .convention
      .getPlugin(KotlinSourceSet::class.java)
      .kotlin
