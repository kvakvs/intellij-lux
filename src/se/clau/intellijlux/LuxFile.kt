package se.clau.intellijlux

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import javax.swing.Icon

class LuxFile(viewProvider: FileViewProvider) :
  PsiFileBase(viewProvider, LuxLanguage) {
  override fun getFileType(): FileType = LuxFileType

  override fun toString(): String = "Lux Script"
}