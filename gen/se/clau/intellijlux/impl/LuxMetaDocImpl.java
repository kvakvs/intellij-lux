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

public class LuxMetaDocImpl extends ASTWrapperPsiElement implements LuxMetaDoc {

  public LuxMetaDocImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LuxVisitor visitor) {
    visitor.visitMetaDoc(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LuxVisitor) accept((LuxVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getCrlf() {
    return findChildByType(CRLF);
  }

  @Override
  @Nullable
  public PsiElement getKDoc() {
    return findChildByType(K_DOC);
  }

  @Override
  @Nullable
  public PsiElement getKDocOnly() {
    return findChildByType(K_DOC_ONLY);
  }

  @Override
  @Nullable
  public PsiElement getKEndDoc() {
    return findChildByType(K_END_DOC);
  }

  @Override
  @Nullable
  public PsiElement getTSqrClose() {
    return findChildByType(T_SQR_CLOSE);
  }

}
