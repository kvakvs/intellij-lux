package se.clau.intellijlux.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.util.IncorrectOperationException
import se.clau.intellijlux.psi.LuxNamedElement

abstract class LuxNamedElementImpl(node: ASTNode) : ASTWrapperPsiElement(node),
  LuxNamedElement
