// This is a generated file. Not intended for manual editing.
package se.clau.intellijlux.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static se.clau.intellijlux.psi.LuxTypes.*;
import se.clau.intellijlux.psi.impl.LuxNamedElementImpl;
import se.clau.intellijlux.psi.*;
import se.clau.intellijlux.psi.impl.LuxPsiImplUtil;

public class LuxIdentImpl extends LuxNamedElementImpl implements LuxIdent {

  public LuxIdentImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LuxVisitor visitor) {
    visitor.visitIdent(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LuxVisitor) accept((LuxVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getTIdent() {
    return findNotNullChildByType(T_IDENT);
  }

}
