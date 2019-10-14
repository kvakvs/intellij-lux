package se.clau.intellijlux;

import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;
import se.clau.intellijlux.psi.LuxIdent;

public class LuxReferenceContributor extends PsiReferenceContributor {
  @Override
  public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
    registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(LuxIdent.class),
            new PsiReferenceProvider() {
              @NotNull
              @Override
              public PsiReference[] getReferencesByElement(
                      @NotNull PsiElement idntElement,
                      @NotNull ProcessingContext context) {
                LuxIdent idnt = (LuxIdent) idntElement;
                String idntName = idnt.getText();
                return new PsiReference[]{
                        new LuxReference(
                                idntElement,
                                new TextRange(1, idntName.length()))
                };
                // return PsiReference.EMPTY_ARRAY;
              }
            });
  }
}
