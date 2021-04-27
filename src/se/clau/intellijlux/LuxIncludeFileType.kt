package se.clau.intellijlux

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.vfs.VirtualFile
import javax.swing.Icon

object LuxIncludeFileType : LanguageFileType(LuxLanguage) {
  override fun getName(): String = "Lux Include"

  override fun getDescription(): String = "Lux header"

  override fun getDefaultExtension(): String = "luxinc"

  override fun getIcon(): Icon = LuxIcons.FILE_INC

  override fun getCharset(file: VirtualFile, content: ByteArray): String = "UTF-8"
}