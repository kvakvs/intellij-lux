import org.gradle.api.internal.HasConvention
import org.jetbrains.grammarkit.tasks.GenerateLexer
import org.jetbrains.grammarkit.tasks.GenerateParser
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  idea
  java
  id("org.jetbrains.kotlin.jvm") version "1.4.32"
  id("org.jetbrains.intellij") version "0.7.2"
  id("org.jetbrains.grammarkit") version "2021.1"
}

val intelliLangPlugin = "org.intellij.intelliLang"
val psiViewerPluginVersion = prop("psiViewerPluginVersion")
val psiViewerPlugin = "PsiViewer:${prop("psiViewerPluginVersion")}"

repositories {
  mavenCentral()
}

intellij { // See https://github.com/JetBrains/gradle-intellij-plugin/
  version = "2021.1.2"
  // not found?    apply(plugin = "copyright")
  apply(plugin = "java")
}

java {
  sourceCompatibility = JavaVersion.VERSION_11
  targetCompatibility = JavaVersion.VERSION_11
}

//val compileKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks
//compileKotlin.kotlinOptions.freeCompilerArgs += "-Xjvm-default=enable"
//compileKotlin.kotlinOptions.jvmTarget = "11"
tasks.withType(KotlinCompile::class).all {
  kotlinOptions {
    jvmTarget = "11"
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
    val plugins = mutableListOf(
      intelliLangPlugin,
      psiViewerPlugin
    )
    setPlugins(*plugins.toTypedArray())
  }

  val generateLuxLexer = task<GenerateLexer>("generateLuxLexer") {
    source = "src/grammars/lux-lexer.flex"
    targetDir = "src/se/clau/intellijlux/gen/lexer"
    targetClass = "_LuxLexer"
    purgeOldFiles = true
  }

  val generateLuxParser = task<GenerateParser>("generateLuxParser") {
    source = "src/grammars/lux-parser.bnf"
    targetRoot = "src"
    pathToParser = "/se/clau/intellijlux/gen/parser/LuxParser.java"
    pathToPsiRoot = "/se/clau/intellijlux/gen/psi"
    purgeOldFiles = true
  }

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
