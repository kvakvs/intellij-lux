package se.clau.intellijlux;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class LuxIncludeFileType extends LanguageFileType {
  public static final LuxIncludeFileType INSTANCE = new LuxIncludeFileType();

  private LuxIncludeFileType() {
    super(LuxLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public String getName() {
    return "Lux Include";
  }

  @NotNull
  @Override
  public String getDescription() {
    return "Lucid Expect";
  }

  @NotNull
  @Override
  public String getDefaultExtension() {
    return "luxinc";
  }

  @Nullable
  @Override
  public Icon getIcon() {
    return LuxIcons.FILE_INC;
  }
}