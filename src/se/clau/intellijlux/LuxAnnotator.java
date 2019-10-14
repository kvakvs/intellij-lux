package se.clau.intellijlux;

import com.intellij.lang.annotation.*;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import se.clau.intellijlux.psi.*;
import org.jetbrains.annotations.NotNull;

public class LuxAnnotator implements Annotator {
  @Override
  public void annotate(@NotNull final PsiElement element, @NotNull AnnotationHolder holder) {
    if (element instanceof LuxSend) {
      annotateKeyword(element, holder, "Send ⯈");
    } else if (element instanceof LuxSendLn) {
      annotateKeyword(element, holder, "Send (+newline) ⯈");
    } else if (element instanceof LuxExpectVerbatim) {
      annotateKeyword(element, holder, "Expect (verbatim) ⯇");
    } else if (element instanceof LuxExpectTemplate) {
      annotateKeyword(element, holder, "Expect (template) ⯇");
    } else if (element instanceof LuxExpectMaybeRegex) {
      annotateKeyword(element, holder, "Expect (maybe regex) ⯇?");
    } else if (element instanceof LuxExpectRegex) {
      annotateKeyword(element, holder, "Expect (regex) ⯇?");
    } else if (element instanceof LuxFlush) {
      annotateKeyword(element, holder, "Flush");
    } else if (element instanceof LuxSetSuccess) {
      annotateKeyword(element, holder, "Set success");
    } else if (element instanceof LuxSetFailure) {
      annotateKeyword(element, holder, "Set failure");
    } else if (element instanceof LuxSetLoopBreak) {
      annotateKeyword(element, holder, "Set loop break");
    }
  }

  private void annotateKeyword(@NotNull final PsiElement element,
                               @NotNull AnnotationHolder holder,
                               String text) {
    int startOffset = element.getTextRange().getStartOffset();
    // First child element going to be the keyword, so take its width and highlight
    int width = element.getFirstChild().getTextLength();
    TextRange range = new TextRange(startOffset, startOffset + width);
    Annotation annotation = holder.createInfoAnnotation(range, text);

    annotation.setTextAttributes(DefaultLanguageHighlighterColors.KEYWORD);
  }
}