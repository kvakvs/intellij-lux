package se.clau.intellijlux

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class LuxFileType private constructor() : LanguageFileType(LuxLanguage.INSTANCE) {
    override fun getName(): String {
        return "Lux Script"
    }

    override fun getDescription(): String {
        return "Lucid Expect"
    }

    override fun getDefaultExtension(): String {
        return "lux"
    }

    override fun getIcon(): Icon? {
        return LuxIcons.FILE
    }

    companion object {
        @JvmField
        val INSTANCE = LuxFileType()
    }
}