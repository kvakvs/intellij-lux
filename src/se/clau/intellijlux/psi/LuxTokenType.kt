package se.clau.intellijlux.psi

import com.intellij.psi.tree.IElementType
import org.jetbrains.annotations.NonNls
import se.clau.intellijlux.LuxLanguage

class LuxTokenType(@NonNls debugName: String) :
  IElementType(debugName, LuxLanguage) {
  override fun toString(): String {
    return "LuxTokenType." + super.toString()
  }
}