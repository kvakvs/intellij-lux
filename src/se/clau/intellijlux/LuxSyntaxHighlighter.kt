package se.clau.intellijlux

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import se.clau.intellijlux.gen.psi.*

class LuxSyntaxHighlighter : SyntaxHighlighterBase() {
  override fun getHighlightingLexer(): Lexer {
    return LuxLexerAdapter()
  }

  override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
    return if (tokenType == LuxTypes.TEXT) {
      LINE_CONTENT_KEYS
    } else if (tokenType == LuxTypes.COMMENT) {
      COMMENT_KEYS
    } else if (tokenType == LuxTypes.T_IDENT
      || tokenType == LuxTypes.T_PASTE_VARIABLE
      || tokenType == LuxTypes.T_PASTE_EXITCODE
      || tokenType == LuxTypes.T_PASTE_CAPTURE
    ) {
      IDENT_KEYS
    } else if (tokenType == TokenType.BAD_CHARACTER) {
      BAD_CHAR_KEYS
    } else if (tokenType == LuxTypes.K_EXP_MAYBE_REGEX
      || tokenType == LuxTypes.K_EXP_REGEX
      || tokenType == LuxTypes.K_EXP_TEMPLATE
      || tokenType == LuxTypes.K_EXP_VERBATIM
      || tokenType == LuxTypes.K_SEND
      || tokenType == LuxTypes.K_SEND_LN
      || tokenType == LuxTypes.K_SET_FAILURE
      || tokenType == LuxTypes.K_SET_FAILURE_ONLY
      || tokenType == LuxTypes.K_SET_LOOP_BREAK
      || tokenType == LuxTypes.K_SET_LOOP_BREAK_ONLY
      || tokenType == LuxTypes.K_SET_SUCCESS
      || tokenType == LuxTypes.K_SET_SUCCESS_ONLY
    ) {
      KEYWORD_KEYS
    } else if (tokenType == LuxTypes.K_ML_EXP_MAYBE_REGEX
      || tokenType == LuxTypes.K_ML_EXP_REGEX
      || tokenType == LuxTypes.K_ML_EXP_TEMPLATE
      || tokenType == LuxTypes.K_ML_EXP_VERBATIM
      || tokenType == LuxTypes.K_ML_SEND
      || tokenType == LuxTypes.K_ML_SEND_LN
      || tokenType == LuxTypes.K_ML_SET_FAILURE
      || tokenType == LuxTypes.K_ML_SET_LOOP_BREAK
      || tokenType == LuxTypes.K_ML_SET_SUCCESS
    ) {
      KEYWORD_KEYS
    } else if (tokenType == LuxTypes.K_CLEANUP
      || tokenType == LuxTypes.K_CONFIG
      || tokenType == LuxTypes.K_DOC
      || tokenType == LuxTypes.K_DOC_ONLY
      || tokenType == LuxTypes.K_END_DOC
      || tokenType == LuxTypes.K_END_LOOP
      || tokenType == LuxTypes.K_END_MACRO
      || tokenType == LuxTypes.K_GLOBAL
      || tokenType == LuxTypes.K_INCLUDE
      || tokenType == LuxTypes.K_INVOKE
      || tokenType == LuxTypes.K_LOCAL
      || tokenType == LuxTypes.K_LOOP
      || tokenType == LuxTypes.K_MACRO
      || tokenType == LuxTypes.K_MY
      || tokenType == LuxTypes.K_PROGRESS
      || tokenType == LuxTypes.K_SHELL
      || tokenType == LuxTypes.K_SHELL_ONLY
      || tokenType == LuxTypes.K_SLEEP
      || tokenType == LuxTypes.K_TIMEOUT
      || tokenType == LuxTypes.K_TIMEOUT_ONLY
    ) {
      META_KEYS
    } else {
      EMPTY_KEYS
    }
  }

  companion object {
    val COMMENT = TextAttributesKey.createTextAttributesKey(
      "LUX_COMMENT",
      DefaultLanguageHighlighterColors.LINE_COMMENT
    )
    val LINE_CONTENT = TextAttributesKey.createTextAttributesKey(
      "LUX_LINE_CONTENT",
      DefaultLanguageHighlighterColors.STRING
    )
    val BAD_CHARACTER = TextAttributesKey.createTextAttributesKey(
      "LUX_BAD_CHARACTER",
      HighlighterColors.BAD_CHARACTER
    )
    val KEYWORD = TextAttributesKey.createTextAttributesKey(
      "LUX_KEYWORD",
      DefaultLanguageHighlighterColors.KEYWORD
    )
    val META = TextAttributesKey.createTextAttributesKey(
      "LUX_META",
      DefaultLanguageHighlighterColors.CLASS_NAME
    )
    val IDENT = TextAttributesKey.createTextAttributesKey(
      "LUX_IDENT",
      DefaultLanguageHighlighterColors.IDENTIFIER
    )

    private val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)
    private val COMMENT_KEYS = arrayOf(COMMENT)
    private val LINE_CONTENT_KEYS = arrayOf(LINE_CONTENT)
    private val KEYWORD_KEYS = arrayOf(KEYWORD)
    private val META_KEYS = arrayOf(META)
    private val IDENT_KEYS = arrayOf(IDENT)
    private val EMPTY_KEYS = arrayOf<TextAttributesKey>()
  }
}