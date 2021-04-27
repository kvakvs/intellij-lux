package se.clau.intellijlux.psi

import com.intellij.psi.tree.IElementType
import org.jetbrains.annotations.NonNls
import se.clau.intellijlux.LuxLanguage

class LuxElementType(@NonNls debugName: String) :
  IElementType(debugName, LuxLanguage)
