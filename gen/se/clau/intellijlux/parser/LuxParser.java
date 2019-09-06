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
  // K_EXP_MAYBE_REGEX inner_line
  public static boolean expect_maybe_regex(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expect_maybe_regex")) return false;
    if (!nextTokenIs(b, K_EXP_MAYBE_REGEX)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_EXP_MAYBE_REGEX);
    r = r && inner_line(b, l + 1);
    exit_section_(b, m, EXPECT_MAYBE_REGEX, r);
    return r;
  }

  /* ********************************************************** */
  // K_EXP_REGEX inner_line
  public static boolean expect_regex(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expect_regex")) return false;
    if (!nextTokenIs(b, K_EXP_REGEX)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_EXP_REGEX);
    r = r && inner_line(b, l + 1);
    exit_section_(b, m, EXPECT_REGEX, r);
    return r;
  }

  /* ********************************************************** */
  // K_EXP_TEMPLATE inner_line
  public static boolean expect_template(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expect_template")) return false;
    if (!nextTokenIs(b, K_EXP_TEMPLATE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_EXP_TEMPLATE);
    r = r && inner_line(b, l + 1);
    exit_section_(b, m, EXPECT_TEMPLATE, r);
    return r;
  }

  /* ********************************************************** */
  // K_EXP_VERBATIM inner_line
  public static boolean expect_verbatim(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expect_verbatim")) return false;
    if (!nextTokenIs(b, K_EXP_VERBATIM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_EXP_VERBATIM);
    r = r && inner_line(b, l + 1);
    exit_section_(b, m, EXPECT_VERBATIM, r);
    return r;
  }

  /* ********************************************************** */
  // T_LINE_CONTENTS
  static boolean inner_line(PsiBuilder b, int l) {
    return consumeToken(b, T_LINE_CONTENTS);
  }

  /* ********************************************************** */
  // T_META_CONTENTS
  static boolean inner_meta(PsiBuilder b, int l) {
    return consumeToken(b, T_META_CONTENTS);
  }

  /* ********************************************************** */
  // T_NUMBER
  static boolean inner_number(PsiBuilder b, int l) {
    return consumeToken(b, T_NUMBER);
  }

  /* ********************************************************** */
  // T_WORD T_EQUALS T_META_CONTENTS T_SQR_CLOSE CRLF
  static boolean inner_x_equals_y(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inner_x_equals_y")) return false;
    if (!nextTokenIs(b, T_WORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_WORD, T_EQUALS, T_META_CONTENTS, T_SQR_CLOSE, CRLF);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COMMENT | CRLF
  //     | meta_doc | meta_shell | meta_newshell | meta_timeout
  //     | meta_config | meta_local | meta_global | meta_my
  //     | K_CLEANUP | meta_include
  //     | meta_macro | K_END_MACRO | meta_invoke
  //     | meta_loop | K_END_LOOP
  //     | send | send_ln | expect_verbatim | expect_template | expect_regex
  //     | K_FLUSH | expect_maybe_regex | set_failure | set_success | set_loop_break
  static boolean item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item")) return false;
    boolean r;
    r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    if (!r) r = meta_doc(b, l + 1);
    if (!r) r = meta_shell(b, l + 1);
    if (!r) r = meta_newshell(b, l + 1);
    if (!r) r = meta_timeout(b, l + 1);
    if (!r) r = meta_config(b, l + 1);
    if (!r) r = meta_local(b, l + 1);
    if (!r) r = meta_global(b, l + 1);
    if (!r) r = meta_my(b, l + 1);
    if (!r) r = consumeToken(b, K_CLEANUP);
    if (!r) r = meta_include(b, l + 1);
    if (!r) r = meta_macro(b, l + 1);
    if (!r) r = consumeToken(b, K_END_MACRO);
    if (!r) r = meta_invoke(b, l + 1);
    if (!r) r = meta_loop(b, l + 1);
    if (!r) r = consumeToken(b, K_END_LOOP);
    if (!r) r = send(b, l + 1);
    if (!r) r = send_ln(b, l + 1);
    if (!r) r = expect_verbatim(b, l + 1);
    if (!r) r = expect_template(b, l + 1);
    if (!r) r = expect_regex(b, l + 1);
    if (!r) r = consumeToken(b, K_FLUSH);
    if (!r) r = expect_maybe_regex(b, l + 1);
    if (!r) r = set_failure(b, l + 1);
    if (!r) r = set_success(b, l + 1);
    if (!r) r = set_loop_break(b, l + 1);
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
  // K_CONFIG inner_x_equals_y
  public static boolean meta_config(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_config")) return false;
    if (!nextTokenIs(b, K_CONFIG)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_CONFIG);
    r = r && inner_x_equals_y(b, l + 1);
    exit_section_(b, m, META_CONFIG, r);
    return r;
  }

  /* ********************************************************** */
  // K_DOC_ONLY | (K_DOC inner_meta)
  public static boolean meta_doc(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_doc")) return false;
    if (!nextTokenIs(b, "<meta doc>", K_DOC, K_DOC_ONLY)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, META_DOC, "<meta doc>");
    r = consumeToken(b, K_DOC_ONLY);
    if (!r) r = meta_doc_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // K_DOC inner_meta
  private static boolean meta_doc_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_doc_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_DOC);
    r = r && inner_meta(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // K_GLOBAL inner_x_equals_y
  public static boolean meta_global(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_global")) return false;
    if (!nextTokenIs(b, K_GLOBAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_GLOBAL);
    r = r && inner_x_equals_y(b, l + 1);
    exit_section_(b, m, META_GLOBAL, r);
    return r;
  }

  /* ********************************************************** */
  // K_INCLUDE inner_meta
  public static boolean meta_include(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_include")) return false;
    if (!nextTokenIs(b, K_INCLUDE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_INCLUDE);
    r = r && inner_meta(b, l + 1);
    exit_section_(b, m, META_INCLUDE, r);
    return r;
  }

  /* ********************************************************** */
  // (K_INVOKE T_WORD) inner_meta
  public static boolean meta_invoke(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_invoke")) return false;
    if (!nextTokenIs(b, K_INVOKE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = meta_invoke_0(b, l + 1);
    r = r && inner_meta(b, l + 1);
    exit_section_(b, m, META_INVOKE, r);
    return r;
  }

  // K_INVOKE T_WORD
  private static boolean meta_invoke_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_invoke_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_INVOKE, T_WORD);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // K_LOCAL inner_x_equals_y
  public static boolean meta_local(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_local")) return false;
    if (!nextTokenIs(b, K_LOCAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_LOCAL);
    r = r && inner_x_equals_y(b, l + 1);
    exit_section_(b, m, META_LOCAL, r);
    return r;
  }

  /* ********************************************************** */
  // (K_LOOP T_WORD) inner_meta
  public static boolean meta_loop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_loop")) return false;
    if (!nextTokenIs(b, K_LOOP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = meta_loop_0(b, l + 1);
    r = r && inner_meta(b, l + 1);
    exit_section_(b, m, META_LOOP, r);
    return r;
  }

  // K_LOOP T_WORD
  private static boolean meta_loop_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_loop_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_LOOP, T_WORD);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // K_MACRO inner_meta
  public static boolean meta_macro(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_macro")) return false;
    if (!nextTokenIs(b, K_MACRO)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_MACRO);
    r = r && inner_meta(b, l + 1);
    exit_section_(b, m, META_MACRO, r);
    return r;
  }

  /* ********************************************************** */
  // K_MY inner_x_equals_y
  public static boolean meta_my(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_my")) return false;
    if (!nextTokenIs(b, K_MY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_MY);
    r = r && inner_x_equals_y(b, l + 1);
    exit_section_(b, m, META_MY, r);
    return r;
  }

  /* ********************************************************** */
  // K_NEWSHELL_ONLY | (K_NEWSHELL inner_meta)
  public static boolean meta_newshell(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_newshell")) return false;
    if (!nextTokenIs(b, "<meta newshell>", K_NEWSHELL, K_NEWSHELL_ONLY)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, META_NEWSHELL, "<meta newshell>");
    r = consumeToken(b, K_NEWSHELL_ONLY);
    if (!r) r = meta_newshell_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // K_NEWSHELL inner_meta
  private static boolean meta_newshell_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_newshell_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_NEWSHELL);
    r = r && inner_meta(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // K_SHELL_ONLY | (K_SHELL inner_meta)
  public static boolean meta_shell(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_shell")) return false;
    if (!nextTokenIs(b, "<meta shell>", K_SHELL, K_SHELL_ONLY)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, META_SHELL, "<meta shell>");
    r = consumeToken(b, K_SHELL_ONLY);
    if (!r) r = meta_shell_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // K_SHELL inner_meta
  private static boolean meta_shell_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_shell_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_SHELL);
    r = r && inner_meta(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // K_TIMEOUT_ONLY | (K_TIMEOUT inner_number)
  public static boolean meta_timeout(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_timeout")) return false;
    if (!nextTokenIs(b, "<meta timeout>", K_TIMEOUT, K_TIMEOUT_ONLY)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, META_TIMEOUT, "<meta timeout>");
    r = consumeToken(b, K_TIMEOUT_ONLY);
    if (!r) r = meta_timeout_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // K_TIMEOUT inner_number
  private static boolean meta_timeout_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_timeout_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_TIMEOUT);
    r = r && inner_number(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // K_SEND inner_line
  public static boolean send(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "send")) return false;
    if (!nextTokenIs(b, K_SEND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_SEND);
    r = r && inner_line(b, l + 1);
    exit_section_(b, m, SEND, r);
    return r;
  }

  /* ********************************************************** */
  // K_SEND_LN inner_line
  public static boolean send_ln(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "send_ln")) return false;
    if (!nextTokenIs(b, K_SEND_LN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_SEND_LN);
    r = r && inner_line(b, l + 1);
    exit_section_(b, m, SEND_LN, r);
    return r;
  }

  /* ********************************************************** */
  // K_SET_FAILURE_ONLY | K_SET_FAILURE inner_line
  public static boolean set_failure(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_failure")) return false;
    if (!nextTokenIs(b, "<set failure>", K_SET_FAILURE, K_SET_FAILURE_ONLY)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SET_FAILURE, "<set failure>");
    r = consumeToken(b, K_SET_FAILURE_ONLY);
    if (!r) r = set_failure_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // K_SET_FAILURE inner_line
  private static boolean set_failure_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_failure_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_SET_FAILURE);
    r = r && inner_line(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // K_SET_LOOP_BREAK_ONLY | K_SET_LOOP_BREAK inner_line
  public static boolean set_loop_break(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_loop_break")) return false;
    if (!nextTokenIs(b, "<set loop break>", K_SET_LOOP_BREAK, K_SET_LOOP_BREAK_ONLY)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SET_LOOP_BREAK, "<set loop break>");
    r = consumeToken(b, K_SET_LOOP_BREAK_ONLY);
    if (!r) r = set_loop_break_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // K_SET_LOOP_BREAK inner_line
  private static boolean set_loop_break_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_loop_break_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_SET_LOOP_BREAK);
    r = r && inner_line(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // K_SET_SUCCESS_ONLY | K_SET_SUCCESS inner_line
  public static boolean set_success(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_success")) return false;
    if (!nextTokenIs(b, "<set success>", K_SET_SUCCESS, K_SET_SUCCESS_ONLY)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SET_SUCCESS, "<set success>");
    r = consumeToken(b, K_SET_SUCCESS_ONLY);
    if (!r) r = set_success_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // K_SET_SUCCESS inner_line
  private static boolean set_success_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_success_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_SET_SUCCESS);
    r = r && inner_line(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

}
