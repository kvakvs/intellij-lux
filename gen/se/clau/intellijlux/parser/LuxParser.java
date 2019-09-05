// This is a generated file. Not intended for manual editing.
package se.clau.intellijlux.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static se.clau.intellijlux.psi.LuxTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class LuxParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return luxFile(b, l + 1);
  }

  /* ********************************************************** */
  // SEND | SENDLN | EXPECT_VERBATIM | EXPECT_TEMPLATE | EXPECT_REGEXP
  //             | FLUSH | EXPECT_MAYBEREGEXP
  //             | SET_FAILURE | SET_SUCCESS | SET_LOOPBREAK
  public static boolean command(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMAND, "<command>");
    r = consumeToken(b, SEND);
    if (!r) r = consumeToken(b, SENDLN);
    if (!r) r = consumeToken(b, EXPECT_VERBATIM);
    if (!r) r = consumeToken(b, EXPECT_TEMPLATE);
    if (!r) r = consumeToken(b, EXPECT_REGEXP);
    if (!r) r = consumeToken(b, FLUSH);
    if (!r) r = consumeToken(b, EXPECT_MAYBEREGEXP);
    if (!r) r = consumeToken(b, SET_FAILURE);
    if (!r) r = consumeToken(b, SET_SUCCESS);
    if (!r) r = consumeToken(b, SET_LOOPBREAK);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // command | META | COMMENT | CRLF
  static boolean item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item")) return false;
    boolean r;
    r = command(b, l + 1);
    if (!r) r = consumeToken(b, META);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    return r;
  }

  /* ********************************************************** */
  // item*
  static boolean luxFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "luxFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "luxFile", c)) break;
    }
    return true;
  }

}
