// This is a generated file. Not intended for manual editing.
package se.clau.intellijlux.gen.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static se.clau.intellijlux.gen.psi.LuxTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import se.clau.intellijlux.gen.psi.*;
import se.clau.intellijlux.psi.impl.LuxPsiImplUtil;

public class LuxExpectTemplateImpl extends ASTWrapperPsiElement implements LuxExpectTemplate {

  public LuxExpectTemplateImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LuxVisitor visitor) {
    visitor.visitExpectTemplate(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LuxVisitor) accept((LuxVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getKExpTemplate() {
    return findChildByType(K_EXP_TEMPLATE);
  }

  @Override
  @Nullable
  public PsiElement getKMlExpTemplate() {
    return findChildByType(K_ML_EXP_TEMPLATE);
  }

  @Override
  @Nullable
  public PsiElement getTTripleQuote() {
    return findChildByType(T_TRIPLE_QUOTE);
  }

}
