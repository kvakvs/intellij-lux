package se.clau.intellijlux

import com.intellij.lexer.FlexAdapter
import java.io.Reader

class LuxLexerAdapter : FlexAdapter(LuxLexer(null as Reader?))