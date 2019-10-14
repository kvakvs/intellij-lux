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

public class LuxMetaShellImpl extends ASTWrapperPsiElement implements LuxMetaShell {

  public LuxMetaShellImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LuxVisitor visitor) {
    visitor.visitMetaShell(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LuxVisitor) accept((LuxVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LuxIdent getIdent() {
    return findChildByClass(LuxIdent.class);
  }

}
