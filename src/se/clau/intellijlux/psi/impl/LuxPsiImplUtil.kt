package se.clau.intellijlux.psi.impl

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import se.clau.intellijlux.psi.LuxElementFactory
import se.clau.intellijlux.psi.LuxIdent
import se.clau.intellijlux.psi.LuxTypes

class LuxPsiImplUtil {
  fun getName(element: LuxIdent?): String? {
    return element?.text
  }

  fun setName(element: LuxIdent, newName: String?): PsiElement? {
    val keyNode: ASTNode? = element.node.findChildByType(LuxTypes.IDENT)
    val property: LuxIdent = LuxElementFactory.createProperty(element.project, newName)
    val newKeyNode: ASTNode = property.firstChild.node

    if (keyNode != null) {
      element.node.replaceChild(keyNode, newKeyNode)
    }

    return element
  }

  fun getNameIdentifier(element: LuxIdent): PsiElement? {
    val keyNode = element.node.findChildByType(LuxTypes.IDENT)
    return keyNode?.psi
  }
}