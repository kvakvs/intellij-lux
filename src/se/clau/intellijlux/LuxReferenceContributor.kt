package se.clau.intellijlux

import com.intellij.openapi.util.TextRange
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.*
import com.intellij.util.ProcessingContext
import se.clau.intellijlux.psi.LuxIdent

class LuxReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        val refProvider = object : PsiReferenceProvider() {
            override fun getReferencesByElement(
                    idntElement: PsiElement,
                    context: ProcessingContext): Array<PsiReference> {
                val idnt = idntElement as LuxIdent
                val idntName = idnt.text
                return arrayOf(
                        LuxReference(
                                idntElement,
                                TextRange(1, idntName.length))
                )
            }
        }
        registrar.registerReferenceProvider(
                PlatformPatterns.psiElement(LuxIdent::class.java),
                refProvider)
    }
}