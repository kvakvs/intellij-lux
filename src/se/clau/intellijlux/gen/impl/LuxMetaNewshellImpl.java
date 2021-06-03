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

public class LuxMetaNewshellImpl extends ASTWrapperPsiElement implements LuxMetaNewshell {

  public LuxMetaNewshellImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LuxVisitor visitor) {
    visitor.visitMetaNewshell(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LuxVisitor) accept((LuxVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getEndMeta() {
    return findChildByType(END_META);
  }

  @Override
  @Nullable
  public PsiElement getKNewshell() {
    return findChildByType(K_NEWSHELL);
  }

  @Override
  @Nullable
  public PsiElement getKNewshellOnly() {
    return findChildByType(K_NEWSHELL_ONLY);
  }

}
