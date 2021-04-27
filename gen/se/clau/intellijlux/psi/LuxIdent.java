// This is a generated file. Not intended for manual editing.
package se.clau.intellijlux.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LuxIdent extends LuxNamedElement {

  @NotNull
  PsiElement getTIdent();

  @Nullable
  String getName();

  @Nullable
  PsiElement setName(@Nullable String newName);

  @Nullable
  PsiElement getNameIdentifier();

}
