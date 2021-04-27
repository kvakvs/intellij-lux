package se.clau.intellijlux.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.Nullable;
import se.clau.intellijlux.psi.LuxNamedElement;
import org.jetbrains.annotations.NotNull;

public class LuxNamedElementImpl
        extends ASTWrapperPsiElement
        implements LuxNamedElement {
  public LuxNamedElementImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Nullable
  @Override
  public PsiElement getNameIdentifier() {
    return this;
  }

  @Override
  public PsiElement setName(@NotNull String s) throws IncorrectOperationException {
    return null;
  }
}