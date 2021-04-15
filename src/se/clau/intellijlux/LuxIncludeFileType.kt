package se.clau.intellijlux

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class LuxIncludeFileType private constructor() : LanguageFileType(LuxLanguage.INSTANCE) {
    override fun getName(): String {
        return "Lux Include"
    }

    override fun getDescription(): String {
        return "Lucid Expect"
    }

    override fun getDefaultExtension(): String {
        return "luxinc"
    }

    override fun getIcon(): Icon? {
        return LuxIcons.FILE_INC
    }

    companion object {
        val INSTANCE = LuxIncludeFileType()
    }
}