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

public class LuxMetaShellImpl extends ASTWrapperPsiElement implements LuxMetaShell {

  public LuxMetaShellImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LuxVisitor visitor) {
    visitor.visitMetaShell(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LuxVisitor) accept((LuxVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LuxIdent getIdent() {
    return findChildByClass(LuxIdent.class);
  }

  @Override
  @Nullable
  public PsiElement getEndMeta() {
    return findChildByType(END_META);
  }

  @Override
  @Nullable
  public PsiElement getKShell() {
    return findChildByType(K_SHELL);
  }

  @Override
  @Nullable
  public PsiElement getKShellOnly() {
    return findChildByType(K_SHELL_ONLY);
  }

}
