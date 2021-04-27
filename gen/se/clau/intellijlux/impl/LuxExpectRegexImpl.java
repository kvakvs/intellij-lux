// This is a generated file. Not intended for manual editing.
package se.clau.intellijlux.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static se.clau.intellijlux.psi.LuxTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import se.clau.intellijlux.psi.*;
import se.clau.intellijlux.psi.impl.LuxPsiImplUtil;

public class LuxExpectRegexImpl extends ASTWrapperPsiElement implements LuxExpectRegex {

  public LuxExpectRegexImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LuxVisitor visitor) {
    visitor.visitExpectRegex(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LuxVisitor) accept((LuxVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getKExpRegex() {
    return findChildByType(K_EXP_REGEX);
  }

  @Override
  @Nullable
  public PsiElement getKMlExpRegex() {
    return findChildByType(K_ML_EXP_REGEX);
  }

  @Override
  @Nullable
  public PsiElement getTTripleQuote() {
    return findChildByType(T_TRIPLE_QUOTE);
  }

}
