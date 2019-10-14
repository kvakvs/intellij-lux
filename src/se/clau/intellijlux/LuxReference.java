package se.clau.intellijlux;

import com.intellij.codeInsight.lookup.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import se.clau.intellijlux.psi.LuxIdent;
import org.jetbrains.annotations.*;

import java.util.*;

public class LuxReference
        extends PsiReferenceBase<PsiElement>
        implements PsiPolyVariantReference {
  private String key;

  public LuxReference(@NotNull PsiElement element, TextRange textRange) {
    super(element, textRange);
    key = element.getText().substring(textRange.getStartOffset(), textRange.getEndOffset());
  }

  @NotNull
  @Override
  public ResolveResult[] multiResolve(boolean incompleteCode) {
    Project project = myElement.getProject();
    final List<LuxIdent> properties = LuxUtil.findIdentifiers(project);
    List<ResolveResult> results = new ArrayList<>();
    for (LuxIdent property : properties) {
      results.add(new PsiElementResolveResult(property));
    }
    return results.toArray(new ResolveResult[results.size()]);
  }

  @Nullable
  @Override
  public PsiElement resolve() {
    ResolveResult[] resolveResults = multiResolve(false);
    return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
  }

  @NotNull
  @Override
  public Object[] getVariants() {
    Project project = myElement.getProject();
    List<LuxIdent> idents = LuxUtil.findIdentifiers(project);
    List<LookupElement> variants = new ArrayList<>();
    for (final LuxIdent idnt : idents) {
      if (idnt.getText() != null && idnt.getText().length() > 0) {
        variants.add(LookupElementBuilder.create(idnt)
                .withIcon(LuxIcons.FILE)
                .withTypeText(idnt.getContainingFile().getName())
        );
      }
    }
    return variants.toArray();
  }
}