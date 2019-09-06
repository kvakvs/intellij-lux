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
  // COMMENT | CRLF |
  //     meta_doc | meta_config | meta_shell | meta_newshell |
  //     meta_timeout
  static boolean item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item")) return false;
    boolean r;
    r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    if (!r) r = meta_doc(b, l + 1);
    if (!r) r = meta_config(b, l + 1);
    if (!r) r = meta_shell(b, l + 1);
    if (!r) r = meta_newshell(b, l + 1);
    if (!r) r = meta_timeout(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // item *
  static boolean luxFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "luxFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "luxFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // K_CONFIG T_WORD T_EQUALS T_META_CONTENTS T_SQR_CLOSE CRLF
  public static boolean meta_config(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_config")) return false;
    if (!nextTokenIs(b, K_CONFIG)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_CONFIG, T_WORD, T_EQUALS, T_META_CONTENTS, T_SQR_CLOSE, CRLF);
    exit_section_(b, m, META_CONFIG, r);
    return r;
  }

  /* ********************************************************** */
  // (K_DOC_ONLY |
  //     (K_DOC T_META_CONTENTS T_SQR_CLOSE)) CRLF
  public static boolean meta_doc(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_doc")) return false;
    if (!nextTokenIs(b, "<meta doc>", K_DOC, K_DOC_ONLY)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, META_DOC, "<meta doc>");
    r = meta_doc_0(b, l + 1);
    r = r && consumeToken(b, CRLF);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // K_DOC_ONLY |
  //     (K_DOC T_META_CONTENTS T_SQR_CLOSE)
  private static boolean meta_doc_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_doc_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_DOC_ONLY);
    if (!r) r = meta_doc_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // K_DOC T_META_CONTENTS T_SQR_CLOSE
  private static boolean meta_doc_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_doc_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_DOC, T_META_CONTENTS, T_SQR_CLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (K_NEWSHELL_ONLY |
  //     (K_NEWSHELL T_META_CONTENTS T_SQR_CLOSE)) CRLF
  public static boolean meta_newshell(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_newshell")) return false;
    if (!nextTokenIs(b, "<meta newshell>", K_NEWSHELL, K_NEWSHELL_ONLY)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, META_NEWSHELL, "<meta newshell>");
    r = meta_newshell_0(b, l + 1);
    r = r && consumeToken(b, CRLF);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // K_NEWSHELL_ONLY |
  //     (K_NEWSHELL T_META_CONTENTS T_SQR_CLOSE)
  private static boolean meta_newshell_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_newshell_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_NEWSHELL_ONLY);
    if (!r) r = meta_newshell_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // K_NEWSHELL T_META_CONTENTS T_SQR_CLOSE
  private static boolean meta_newshell_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_newshell_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_NEWSHELL, T_META_CONTENTS, T_SQR_CLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (K_SHELL_ONLY |
  //     (K_SHELL T_META_CONTENTS T_SQR_CLOSE)) CRLF
  public static boolean meta_shell(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_shell")) return false;
    if (!nextTokenIs(b, "<meta shell>", K_SHELL, K_SHELL_ONLY)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, META_SHELL, "<meta shell>");
    r = meta_shell_0(b, l + 1);
    r = r && consumeToken(b, CRLF);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // K_SHELL_ONLY |
  //     (K_SHELL T_META_CONTENTS T_SQR_CLOSE)
  private static boolean meta_shell_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_shell_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_SHELL_ONLY);
    if (!r) r = meta_shell_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // K_SHELL T_META_CONTENTS T_SQR_CLOSE
  private static boolean meta_shell_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_shell_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_SHELL, T_META_CONTENTS, T_SQR_CLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (K_TIMEOUT_ONLY |
  //     (K_TIMEOUT T_NUMBER T_SQR_CLOSE)) CRLF
  public static boolean meta_timeout(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_timeout")) return false;
    if (!nextTokenIs(b, "<meta timeout>", K_TIMEOUT, K_TIMEOUT_ONLY)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, META_TIMEOUT, "<meta timeout>");
    r = meta_timeout_0(b, l + 1);
    r = r && consumeToken(b, CRLF);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // K_TIMEOUT_ONLY |
  //     (K_TIMEOUT T_NUMBER T_SQR_CLOSE)
  private static boolean meta_timeout_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_timeout_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_TIMEOUT_ONLY);
    if (!r) r = meta_timeout_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // K_TIMEOUT T_NUMBER T_SQR_CLOSE
  private static boolean meta_timeout_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_timeout_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_TIMEOUT, T_NUMBER, T_SQR_CLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

}
