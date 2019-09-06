package se.clau.intellijlux;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import se.clau.intellijlux.*;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class LuxFile extends PsiFileBase {
  public LuxFile(@NotNull FileViewProvider viewProvider) {
    super(viewProvider, LuxLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public FileType getFileType() {
    return LuxFileType.INSTANCE;
  }

  @Override
  public String toString() {
    return "Lux Script";
  }

  @Override
  public Icon getIcon(int flags) {
    return super.getIcon(flags);
  }
}