package se.clau.intellijlux

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.vfs.VirtualFile
import javax.swing.Icon

object LuxFileType : LanguageFileType(LuxLanguage) {
  override fun getName(): String = "Lux Script"

  override fun getDescription(): String = "Lux test script"

  override fun getDefaultExtension(): String = "lux"

  override fun getIcon(): Icon = LuxIcons.FILE

  override fun getCharset(file: VirtualFile, content: ByteArray): String =
    "UTF-8"
}
