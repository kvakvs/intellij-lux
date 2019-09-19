package se.clau.intellijlux;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.*;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import se.clau.intellijlux.psi.LuxTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class LuxSyntaxHighlighter extends SyntaxHighlighterBase {
  public static final TextAttributesKey COMMENT =
          createTextAttributesKey("LUX_COMMENT",
                  DefaultLanguageHighlighterColors.LINE_COMMENT);
  public static final TextAttributesKey LINE_CONTENT =
          createTextAttributesKey("LUX_LINE_CONTENT",
                  DefaultLanguageHighlighterColors.STRING);
  public static final TextAttributesKey BAD_CHARACTER =
          createTextAttributesKey("LUX_BAD_CHARACTER",
                  HighlighterColors.BAD_CHARACTER);
  public static final TextAttributesKey KEYWORD =
          createTextAttributesKey("LUX_KEYWORD",
                  DefaultLanguageHighlighterColors.KEYWORD);
  public static final TextAttributesKey META =
          createTextAttributesKey("LUX_META",
                  DefaultLanguageHighlighterColors.CLASS_NAME);
  public static final TextAttributesKey IDENT =
          createTextAttributesKey("LUX_IDENT",
                  DefaultLanguageHighlighterColors.IDENTIFIER);

  private static final TextAttributesKey[] BAD_CHAR_KEYS
          = new TextAttributesKey[]{BAD_CHARACTER};
  private static final TextAttributesKey[] COMMENT_KEYS
          = new TextAttributesKey[]{COMMENT};
  private static final TextAttributesKey[] LINE_CONTENT_KEYS
          = new TextAttributesKey[]{LINE_CONTENT};
  private static final TextAttributesKey[] KEYWORD_KEYS
          = new TextAttributesKey[]{KEYWORD};
  private static final TextAttributesKey[] META_KEYS
          = new TextAttributesKey[]{META};
  private static final TextAttributesKey[] IDENT_KEYS
          = new TextAttributesKey[]{IDENT};
  private static final TextAttributesKey[] EMPTY_KEYS
          = new TextAttributesKey[0];

  @NotNull
  @Override
  public Lexer getHighlightingLexer() {
    return new LuxLexerAdapter();
  }

  @NotNull
  @Override
  public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
    if (tokenType.equals(LuxTypes.T_LINE_CONTENTS)) {
      return LINE_CONTENT_KEYS;
    } else if (tokenType.equals(LuxTypes.COMMENT)) {
      return COMMENT_KEYS;
    } else if (tokenType.equals(LuxTypes.T_IDENT)
            || tokenType.equals(LuxTypes.T_PASTE_VARIABLE)
            || tokenType.equals(LuxTypes.T_PASTE_CAPTURE)) {
      return IDENT_KEYS;
    } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
      return BAD_CHAR_KEYS;
    } else if (tokenType.equals(LuxTypes.K_EXP_MAYBE_REGEX)
            || tokenType.equals(LuxTypes.K_EXP_REGEX)
            || tokenType.equals(LuxTypes.K_EXP_TEMPLATE)
            || tokenType.equals(LuxTypes.K_EXP_VERBATIM)
            || tokenType.equals(LuxTypes.K_SEND)
            || tokenType.equals(LuxTypes.K_SEND_LN)
            || tokenType.equals(LuxTypes.K_SET_FAILURE)
            || tokenType.equals(LuxTypes.K_SET_FAILURE_ONLY)
            || tokenType.equals(LuxTypes.K_SET_LOOP_BREAK)
            || tokenType.equals(LuxTypes.K_SET_LOOP_BREAK_ONLY)
            || tokenType.equals(LuxTypes.K_SET_SUCCESS)
            || tokenType.equals(LuxTypes.K_SET_SUCCESS_ONLY)) {
      return KEYWORD_KEYS;
    } else if (tokenType.equals(LuxTypes.K_ML_EXP_MAYBE_REGEX)
            || tokenType.equals(LuxTypes.K_ML_EXP_REGEX)
            || tokenType.equals(LuxTypes.K_ML_EXP_TEMPLATE)
            || tokenType.equals(LuxTypes.K_ML_EXP_VERBATIM)
            || tokenType.equals(LuxTypes.K_ML_SEND)
            || tokenType.equals(LuxTypes.K_ML_SEND_LN)
            || tokenType.equals(LuxTypes.K_ML_SET_FAILURE)
            || tokenType.equals(LuxTypes.K_ML_SET_LOOP_BREAK)
            || tokenType.equals(LuxTypes.K_ML_SET_SUCCESS)) {
      return KEYWORD_KEYS;
    } else if (tokenType.equals(LuxTypes.K_CLEANUP)
            || tokenType.equals(LuxTypes.K_CONFIG)
            || tokenType.equals(LuxTypes.K_DOC)
            || tokenType.equals(LuxTypes.K_DOC_ONLY)
            || tokenType.equals(LuxTypes.K_END_DOC)
            || tokenType.equals(LuxTypes.K_END_LOOP)
            || tokenType.equals(LuxTypes.K_END_MACRO)
            || tokenType.equals(LuxTypes.K_GLOBAL)
            || tokenType.equals(LuxTypes.K_INCLUDE)
            || tokenType.equals(LuxTypes.K_INVOKE)
            || tokenType.equals(LuxTypes.K_LOCAL)
            || tokenType.equals(LuxTypes.K_LOOP)
            || tokenType.equals(LuxTypes.K_MACRO)
            || tokenType.equals(LuxTypes.K_MY)
            || tokenType.equals(LuxTypes.K_PROGRESS)
            || tokenType.equals(LuxTypes.K_SHELL)
            || tokenType.equals(LuxTypes.K_SHELL_ONLY)
            || tokenType.equals(LuxTypes.K_SLEEP)
            || tokenType.equals(LuxTypes.K_TIMEOUT)
            || tokenType.equals(LuxTypes.K_TIMEOUT_ONLY)) {
      return META_KEYS;
    } else {
      return EMPTY_KEYS;
    }
  }
}