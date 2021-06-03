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

public class LuxMetaGlobalImpl extends ASTWrapperPsiElement implements LuxMetaGlobal {

  public LuxMetaGlobalImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LuxVisitor visitor) {
    visitor.visitMetaGlobal(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LuxVisitor) accept((LuxVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public LuxIdent getIdent() {
    return findNotNullChildByClass(LuxIdent.class);
  }

  @Override
  @NotNull
  public PsiElement getEndMeta() {
    return findNotNullChildByType(END_META);
  }

  @Override
  @NotNull
  public PsiElement getKGlobal() {
    return findNotNullChildByType(K_GLOBAL);
  }

  @Override
  @NotNull
  public PsiElement getTEquals() {
    return findNotNullChildByType(T_EQUALS);
  }

}