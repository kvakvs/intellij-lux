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

public class LuxSetSuccessImpl extends ASTWrapperPsiElement implements LuxSetSuccess {

  public LuxSetSuccessImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LuxVisitor visitor) {
    visitor.visitSetSuccess(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LuxVisitor) accept((LuxVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getKMlSetSuccess() {
    return findChildByType(K_ML_SET_SUCCESS);
  }

  @Override
  @Nullable
  public PsiElement getKSetSuccess() {
    return findChildByType(K_SET_SUCCESS);
  }

  @Override
  @Nullable
  public PsiElement getKSetSuccessOnly() {
    return findChildByType(K_SET_SUCCESS_ONLY);
  }

  @Override
  @Nullable
  public PsiElement getTTripleQuote() {
    return findChildByType(T_TRIPLE_QUOTE);
  }

}
