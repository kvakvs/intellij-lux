package se.clau.intellijlux;

import com.intellij.lexer.FlexAdapter;
import java.io.Reader;

public class LuxLexerAdapter extends FlexAdapter {
  public LuxLexerAdapter() {
    super(new LuxLexer((Reader) null));
  }
}
