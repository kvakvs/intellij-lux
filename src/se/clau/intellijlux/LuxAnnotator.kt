package se.clau.intellijlux

import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import se.clau.intellijlux.psi.*

class LuxAnnotator : Annotator {
  override fun annotate(element: PsiElement, holder: AnnotationHolder) {
    when (element) {
      is LuxSend -> {
        annotateKeyword(element, holder, "Send text")
      }
      is LuxSendLn -> {
        annotateKeyword(element, holder, "Send text and newline")
      }
      is LuxExpectVerbatim -> {
        annotateKeyword(element, holder, "Expect (verbatim) text")
      }
      is LuxExpectTemplate -> {
        annotateKeyword(element, holder, "Expect (template) text")
      }
      is LuxExpectMaybeRegex -> {
        annotateKeyword(element, holder, "Expect (maybe regex)")
      }
      is LuxExpectRegex -> {
        annotateKeyword(element, holder, "Expect (regex)")
      }
      is LuxFlush -> {
        annotateKeyword(element, holder, "Flush")
      }
      is LuxSetSuccess -> {
        annotateKeyword(element, holder, "Set success")
      }
      is LuxSetFailure -> {
        annotateKeyword(element, holder, "Set failure")
      }
      is LuxSetLoopBreak -> {
        annotateKeyword(element, holder, "Set loop break")
      }
    }
  }

  private fun annotateKeyword(
    element: PsiElement,
    holder: AnnotationHolder,
    text: String
  ) {
    val startOffset = element.textRange.startOffset
    // First child element going to be the keyword, so take its width and highlight
    val width = element.firstChild.textLength
    val range = TextRange(startOffset, startOffset + width)

    holder.newAnnotation(HighlightSeverity.INFORMATION, text)
      .range(range)
      .highlightType(ProblemHighlightType.INFORMATION)
      .create()
  }
}