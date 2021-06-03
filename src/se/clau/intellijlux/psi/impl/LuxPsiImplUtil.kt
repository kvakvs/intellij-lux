package se.clau.intellijlux.psi.impl

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import se.clau.intellijlux.gen.psi.LuxIdent
import se.clau.intellijlux.gen.psi.LuxTypes
import se.clau.intellijlux.psi.LuxElementFactory

class LuxPsiImplUtil {
  companion object {
    @JvmStatic @Override
    fun getName(element: LuxIdent?): String? {
      return element?.text
    }

    @JvmStatic @Override
    fun setName(element: LuxIdent, newName: String?): PsiElement? {
      val keyNode: ASTNode? = element.node.findChildByType(LuxTypes.IDENT)
      val property: LuxIdent = LuxElementFactory.createProperty(element.project, newName)
      val newKeyNode: ASTNode = property.firstChild.node

      if (keyNode != null) {
        element.node.replaceChild(keyNode, newKeyNode)
      }

      return element
    }

    @JvmStatic @Override
    fun getNameIdentifier(element: LuxIdent): PsiElement? {
      val keyNode = element.node.findChildByType(LuxTypes.IDENT)
      return keyNode?.psi
    }
  }
}