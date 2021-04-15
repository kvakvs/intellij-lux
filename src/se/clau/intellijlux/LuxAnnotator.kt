package se.clau.intellijlux

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import se.clau.intellijlux.psi.*

class LuxAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is LuxSend) {
            annotateKeyword(element, holder, "Send ⯈")
        } else if (element is LuxSendLn) {
            annotateKeyword(element, holder, "Send (+newline) ⯈")
        } else if (element is LuxExpectVerbatim) {
            annotateKeyword(element, holder, "Expect (verbatim) ⯇")
        } else if (element is LuxExpectTemplate) {
            annotateKeyword(element, holder, "Expect (template) ⯇")
        } else if (element is LuxExpectMaybeRegex) {
            annotateKeyword(element, holder, "Expect (maybe regex) ⯇?")
        } else if (element is LuxExpectRegex) {
            annotateKeyword(element, holder, "Expect (regex) ⯇?")
        } else if (element is LuxFlush) {
            annotateKeyword(element, holder, "Flush")
        } else if (element is LuxSetSuccess) {
            annotateKeyword(element, holder, "Set success")
        } else if (element is LuxSetFailure) {
            annotateKeyword(element, holder, "Set failure")
        } else if (element is LuxSetLoopBreak) {
            annotateKeyword(element, holder, "Set loop break")
        }
    }

    private fun annotateKeyword(element: PsiElement,
                                holder: AnnotationHolder,
                                text: String) {
        val startOffset = element.textRange.startOffset
        // First child element going to be the keyword, so take its width and highlight
        val width = element.firstChild.textLength
        val range = TextRange(startOffset, startOffset + width)

        val annotation = holder.createInfoAnnotation(range, text)
        // val annotation = holder.newAnnotation(HighlightSeverity.INFORMATION, text)
        // annotation.textAttributes(DefaultLanguageHighlighterColors.KEYWORD)
        annotation.textAttributes = DefaultLanguageHighlighterColors.KEYWORD
    }
}