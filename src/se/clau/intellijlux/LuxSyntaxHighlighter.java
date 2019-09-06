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
//  public static final TextAttributesKey SEPARATOR =
//          createTextAttributesKey("SIMPLE_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
//  public static final TextAttributesKey KEY =
//          createTextAttributesKey("SIMPLE_KEY", DefaultLanguageHighlighterColors.KEYWORD);
//  public static final TextAttributesKey VALUE =
//          createTextAttributesKey("SIMPLE_VALUE", DefaultLanguageHighlighterColors.STRING);
  public static final TextAttributesKey COMMENT =
          createTextAttributesKey("LUX_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
  public static final TextAttributesKey LINE_CONTENT =
          createTextAttributesKey("LUX_LINE_CONTENT", DefaultLanguageHighlighterColors.STRING);
  public static final TextAttributesKey BAD_CHARACTER =
          createTextAttributesKey("LUX_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
  public static final TextAttributesKey KEYWORD =
          createTextAttributesKey("LUX_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);

  private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
//  private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
//  private static final TextAttributesKey[] KEY_KEYS = new TextAttributesKey[]{KEY};
//  private static final TextAttributesKey[] VALUE_KEYS = new TextAttributesKey[]{VALUE};
  private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
  private static final TextAttributesKey[] LINE_CONTENT_KEYS = new TextAttributesKey[]{LINE_CONTENT};
  private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
  private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

  @NotNull
  @Override
  public Lexer getHighlightingLexer() {
    return new LuxLexerAdapter();
  }

  @NotNull
  @Override
  public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
//    if (tokenType.equals(SimpleTypes.SEPARATOR)) {
//      return SEPARATOR_KEYS;
//    } else if (tokenType.equals(SimpleTypes.KEY)) {
//      return KEY_KEYS;
//    } else if (tokenType.equals(SimpleTypes.VALUE)) {
//      return VALUE_KEYS;
//  } else
    if (tokenType.equals(LuxTypes.T_LINE_CONTENTS)) {
      return LINE_CONTENT_KEYS;
    } else if (tokenType.equals(LuxTypes.COMMENT)) {
      return COMMENT_KEYS;
    } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
      return BAD_CHAR_KEYS;
    } else if (tokenType.equals(LuxTypes.K_SEND)
            || tokenType.equals(LuxTypes.K_SEND_LN)
            || tokenType.equals(LuxTypes.K_EXP_VERBATIM)
            || tokenType.equals(LuxTypes.K_EXP_TEMPLATE)
            || tokenType.equals(LuxTypes.K_EXP_MAYBE_REGEX)
            || tokenType.equals(LuxTypes.K_EXP_REGEX)
            || tokenType.equals(LuxTypes.K_SET_FAILURE)
            || tokenType.equals(LuxTypes.K_SET_FAILURE_ONLY)
            || tokenType.equals(LuxTypes.K_SET_SUCCESS)
            || tokenType.equals(LuxTypes.K_SET_SUCCESS_ONLY)
            || tokenType.equals(LuxTypes.K_SET_LOOP_BREAK)
            || tokenType.equals(LuxTypes.K_SET_LOOP_BREAK_ONLY)) {
      return KEYWORD_KEYS;
    } else {
      return EMPTY_KEYS;
    }
  }
}