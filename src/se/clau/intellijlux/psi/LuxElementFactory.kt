package se.clau.intellijlux.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory
import se.clau.intellijlux.LuxFile
import se.clau.intellijlux.LuxFileType

object LuxElementFactory {
  fun createProperty(project: Project?, name: String?): LuxIdent {
    val file = createFile(project, name)
    return file.firstChild as LuxIdent
  }

  fun createFile(project: Project?, text: String?): LuxFile {
    val name = "dummy.lux"
    return PsiFileFactory.getInstance(project)
      .createFileFromText(name, LuxFileType, text!!) as LuxFile
  }
}