package se.clau.intellijlux;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.*;

import javax.swing.*;

public class LuxFileType extends LanguageFileType {
  public static final LuxFileType INSTANCE = new LuxFileType();

  private LuxFileType() {
    super(LuxLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public String getName() {
    return "Lux Script";
  }

  @NotNull
  @Override
  public String getDescription() { return "Lucid Expect"; }

  @NotNull
  @Override
  public String getDefaultExtension() {
    return "lux";
  }

  @Nullable
  @Override
  public Icon getIcon() {
    return LuxIcons.FILE;
  }
}