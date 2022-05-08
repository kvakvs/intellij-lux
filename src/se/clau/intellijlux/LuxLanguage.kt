package se.clau.intellijlux

import com.intellij.lang.Language

object LuxLanguage : Language("Lux", "text/lux") {
  override fun isCaseSensitive() = true
  override fun getDisplayName() = "Lux"
}
