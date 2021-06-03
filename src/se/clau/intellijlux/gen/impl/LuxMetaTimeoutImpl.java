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

public class LuxMetaTimeoutImpl extends ASTWrapperPsiElement implements LuxMetaTimeout {

  public LuxMetaTimeoutImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LuxVisitor visitor) {
    visitor.visitMetaTimeout(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LuxVisitor) accept((LuxVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getKTimeout() {
    return findChildByType(K_TIMEOUT);
  }

  @Override
  @Nullable
  public PsiElement getKTimeoutOnly() {
    return findChildByType(K_TIMEOUT_ONLY);
  }

  @Override
  @Nullable
  public PsiElement getTNumber() {
    return findChildByType(T_NUMBER);
  }

  @Override
  @Nullable
  public PsiElement getTSqrClose() {
    return findChildByType(T_SQR_CLOSE);
  }

}
