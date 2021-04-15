package se.clau.intellijlux

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import javax.swing.Icon

class LuxFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, LuxLanguage.INSTANCE) {
    override fun getFileType(): FileType {
        return LuxFileType.INSTANCE
    }

    override fun toString(): String {
        return "Lux Script"
    }

    override fun getIcon(flags: Int): Icon? {
        return super.getIcon(flags)
    }
}