package se.clau.intellijlux

import com.intellij.lexer.FlexAdapter
import se.clau.intellijlux.gen.lexer._LuxLexer;
import java.io.Reader

class LuxLexerAdapter : FlexAdapter(_LuxLexer(null as Reader?))
