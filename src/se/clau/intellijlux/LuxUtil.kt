package se.clau.intellijlux

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import se.clau.intellijlux.psi.LuxIdent
import java.util.*

object LuxUtil {
  @JvmStatic
  fun findIdentifiers(project: Project?): List<LuxIdent> {
    val result = ArrayList<LuxIdent>()
    val virtualFiles = FileTypeIndex.getFiles(
      LuxFileType,
      GlobalSearchScope.allScope(project!!)
    )
    for (virtualFile in virtualFiles) {
      val luxFile =
        PsiManager.getInstance(project).findFile(virtualFile!!) as LuxFile?
      if (luxFile != null) {
        val properties = PsiTreeUtil.getChildrenOfType(
          luxFile,  //PsiElement.class
          LuxIdent::class.java
        )
        if (properties != null) {
          Collections.addAll(result, *properties)
        }
      }
    }
    return result
  }
}