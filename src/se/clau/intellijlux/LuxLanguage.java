package se.clau.intellijlux;

import com.intellij.lang.Language;

public class LuxLanguage extends Language {
  public static final LuxLanguage INSTANCE = new LuxLanguage();

  private LuxLanguage() {
    super("Lux");
  }
}