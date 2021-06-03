package se.clau.intellijlux

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import org.jetbrains.annotations.NotNull
import se.clau.intellijlux.LuxUtil.findIdentifiers


class LuxReference(
  @NotNull element: PsiElement,
  textRange: TextRange
) : PsiReferenceBase<PsiElement?>(element, textRange), PsiPolyVariantReference {

  private var name: String? = null

  init {
    name = element.text.substring(textRange.startOffset, textRange.endOffset)
  }

  override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
    val project = myElement!!.project
    val properties = findIdentifiers(project)
    val results: MutableList<ResolveResult> = ArrayList()
    for (property in properties) {
      results.add(PsiElementResolveResult(property))
    }
    return results.toTypedArray()
  }

  override fun resolve(): PsiElement? {
    val resolveResults = multiResolve(false)
    return if (resolveResults.size == 1) resolveResults[0].element else null
  }

  override fun getVariants(): Array<Any> {
    val project = myElement!!.project
    val idents = findIdentifiers(project)
    val variants: MutableList<LookupElement> = ArrayList()

    for (the_ident in idents) {
      if (the_ident.text != null && the_ident.text.isNotEmpty()) {
        variants.add(
          LookupElementBuilder.create(the_ident)
            .withIcon(LuxIcons.FILE)
            .withTypeText(the_ident.containingFile.name)
        )
      }
    }
    return variants.toTypedArray()
  }

}