package se.clau.intellijlux

import com.intellij.lang.cacheBuilder.DefaultWordsScanner
import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.tree.TokenSet
import se.clau.intellijlux.gen.psi.*

class LuxFindUsagesProvider : FindUsagesProvider {
  override fun getWordsScanner(): WordsScanner? {
    return DefaultWordsScanner(
      LuxLexerAdapter(),
      TokenSet.create(LuxTypes.IDENT),
      TokenSet.create(LuxTypes.COMMENT),
      TokenSet.EMPTY
    )
  }

  override fun canFindUsagesFor(psiElement: PsiElement): Boolean {
    return psiElement is PsiNamedElement
  }

  override fun getHelpId(psiElement: PsiElement): String? {
    return null
  }

  override fun getType(element: PsiElement): String {
    return if (element is LuxIdent) {
      "simple property"
    } else {
      ""
    }
  }

  override fun getDescriptiveName(element: PsiElement): String {
    return if (element is LuxIdent) {
      element.name!!
    } else {
      ""
    }
  }

  override fun getNodeText(element: PsiElement, useFullName: Boolean): String {
    return if (element is LuxIdent) {
      element.name!!
    } else {
      ""
    }
  }
}