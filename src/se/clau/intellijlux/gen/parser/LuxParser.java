// This is a generated file. Not intended for manual editing.
package se.clau.intellijlux.gen.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static se.clau.intellijlux.gen.psi.LuxTypes.*;
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
    return lux_file(b, l + 1);
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
  // expect_maybe_regex | ml_expect_maybe_regex
  static boolean expect_maybe_regex_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expect_maybe_regex_")) return false;
    if (!nextTokenIs(b, "", K_EXP_MAYBE_REGEX, K_ML_EXP_MAYBE_REGEX)) return false;
    boolean r;
    r = expect_maybe_regex(b, l + 1);
    if (!r) r = ml_expect_maybe_regex(b, l + 1);
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
  // expect_regex | ml_expect_regex
  static boolean expect_regex_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expect_regex_")) return false;
    if (!nextTokenIs(b, "", K_EXP_REGEX, K_ML_EXP_REGEX)) return false;
    boolean r;
    r = expect_regex(b, l + 1);
    if (!r) r = ml_expect_regex(b, l + 1);
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
  // expect_template | ml_expect_template
  static boolean expect_template_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expect_template_")) return false;
    if (!nextTokenIs(b, "", K_EXP_TEMPLATE, K_ML_EXP_TEMPLATE)) return false;
    boolean r;
    r = expect_template(b, l + 1);
    if (!r) r = ml_expect_template(b, l + 1);
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
  // expect_verbatim | ml_expect_verbatim
  static boolean expect_verbatim_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expect_verbatim_")) return false;
    if (!nextTokenIs(b, "", K_EXP_VERBATIM, K_ML_EXP_VERBATIM)) return false;
    boolean r;
    r = expect_verbatim(b, l + 1);
    if (!r) r = ml_expect_verbatim(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // K_FLUSH
  public static boolean flush(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flush")) return false;
    if (!nextTokenIs(b, K_FLUSH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_FLUSH);
    exit_section_(b, m, FLUSH, r);
    return r;
  }

  /* ********************************************************** */
  // T_IDENT
  public static boolean ident(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ident")) return false;
    if (!nextTokenIs(b, T_IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_IDENT);
    exit_section_(b, m, IDENT, r);
    return r;
  }

  /* ********************************************************** */
  // line_contents *
  static boolean inner_line(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inner_line")) return false;
    while (true) {
      int c = current_position_(b);
      if (!line_contents(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "inner_line", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // multiline_contents *
  static boolean inner_multiline(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inner_multiline")) return false;
    while (true) {
      int c = current_position_(b);
      if (!multiline_contents(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "inner_multiline", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // T_NUMBER T_SQR_CLOSE
  static boolean inner_number(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inner_number")) return false;
    if (!nextTokenIs(b, T_NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_NUMBER, T_SQR_CLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ident T_EQUALS meta_contents
  static boolean inner_x_equals_y(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inner_x_equals_y")) return false;
    if (!nextTokenIs(b, T_IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ident(b, l + 1);
    r = r && consumeToken(b, T_EQUALS);
    r = r && meta_contents(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TEXT | paste | LINE_CONTINUATION
  static boolean line_contents(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line_contents")) return false;
    boolean r;
    r = consumeToken(b, TEXT);
    if (!r) r = paste(b, l + 1);
    if (!r) r = consumeToken(b, LINE_CONTINUATION);
    return r;
  }

  /* ********************************************************** */
  // COMMENT
  //     | meta_doc | K_END_DOC
  //     | meta_shell | meta_newshell
  //     | meta_timeout | meta_sleep
  //     | meta_config | meta_local | meta_global | meta_my
  //     | K_CLEANUP | meta_include
  //     | meta_invoke
  //     | meta_loop | K_END_LOOP
  //     | meta_progress
  //     | send_ | send_ln_ | expect_verbatim_ | expect_template_ | expect_regex_
  //     | flush | expect_maybe_regex_ | set_failure_ | set_success_
  //     | set_loop_break_
  static boolean lux_command(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lux_command")) return false;
    boolean r;
    r = consumeToken(b, COMMENT);
    if (!r) r = meta_doc(b, l + 1);
    if (!r) r = consumeToken(b, K_END_DOC);
    if (!r) r = meta_shell(b, l + 1);
    if (!r) r = meta_newshell(b, l + 1);
    if (!r) r = meta_timeout(b, l + 1);
    if (!r) r = meta_sleep(b, l + 1);
    if (!r) r = meta_config(b, l + 1);
    if (!r) r = meta_local(b, l + 1);
    if (!r) r = meta_global(b, l + 1);
    if (!r) r = meta_my(b, l + 1);
    if (!r) r = consumeToken(b, K_CLEANUP);
    if (!r) r = meta_include(b, l + 1);
    if (!r) r = meta_invoke(b, l + 1);
    if (!r) r = meta_loop(b, l + 1);
    if (!r) r = consumeToken(b, K_END_LOOP);
    if (!r) r = meta_progress(b, l + 1);
    if (!r) r = send_(b, l + 1);
    if (!r) r = send_ln_(b, l + 1);
    if (!r) r = expect_verbatim_(b, l + 1);
    if (!r) r = expect_template_(b, l + 1);
    if (!r) r = expect_regex_(b, l + 1);
    if (!r) r = flush(b, l + 1);
    if (!r) r = expect_maybe_regex_(b, l + 1);
    if (!r) r = set_failure_(b, l + 1);
    if (!r) r = set_success_(b, l + 1);
    if (!r) r = set_loop_break_(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // lux_file_item *
  static boolean lux_file(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lux_file")) return false;
    while (true) {
      int c = current_position_(b);
      if (!lux_file_item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "lux_file", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // meta_macro | lux_command
  static boolean lux_file_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lux_file_item")) return false;
    boolean r;
    r = meta_macro(b, l + 1);
    if (!r) r = lux_command(b, l + 1);
    return r;
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
  // ( meta_element * ) END_META
  static boolean meta_contents(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_contents")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = meta_contents_0(b, l + 1);
    r = r && consumeToken(b, END_META);
    exit_section_(b, m, null, r);
    return r;
  }

  // meta_element *
  private static boolean meta_contents_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_contents_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!meta_element(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "meta_contents_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (K_DOC meta_contents) | (K_DOC_ONLY multiline_text K_END_DOC)
  public static boolean meta_doc(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_doc")) return false;
    if (!nextTokenIs(b, "<meta doc>", K_DOC, K_DOC_ONLY)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, META_DOC, "<meta doc>");
    r = meta_doc_0(b, l + 1);
    if (!r) r = meta_doc_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // K_DOC meta_contents
  private static boolean meta_doc_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_doc_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_DOC);
    r = r && meta_contents(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // K_DOC_ONLY multiline_text K_END_DOC
  private static boolean meta_doc_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_doc_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_DOC_ONLY);
    r = r && multiline_text(b, l + 1);
    r = r && consumeToken(b, K_END_DOC);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TEXT | paste
  static boolean meta_element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_element")) return false;
    boolean r;
    r = consumeToken(b, TEXT);
    if (!r) r = paste(b, l + 1);
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
  // K_INCLUDE meta_contents
  public static boolean meta_include(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_include")) return false;
    if (!nextTokenIs(b, K_INCLUDE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_INCLUDE);
    r = r && meta_contents(b, l + 1);
    exit_section_(b, m, META_INCLUDE, r);
    return r;
  }

  /* ********************************************************** */
  // (K_INVOKE ident) meta_contents
  public static boolean meta_invoke(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_invoke")) return false;
    if (!nextTokenIs(b, K_INVOKE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = meta_invoke_0(b, l + 1);
    r = r && meta_contents(b, l + 1);
    exit_section_(b, m, META_INVOKE, r);
    return r;
  }

  // K_INVOKE ident
  private static boolean meta_invoke_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_invoke_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_INVOKE);
    r = r && ident(b, l + 1);
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
  // (K_LOOP ident) meta_contents
  public static boolean meta_loop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_loop")) return false;
    if (!nextTokenIs(b, K_LOOP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = meta_loop_0(b, l + 1);
    r = r && meta_contents(b, l + 1);
    exit_section_(b, m, META_LOOP, r);
    return r;
  }

  // K_LOOP ident
  private static boolean meta_loop_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_loop_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_LOOP);
    r = r && ident(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (K_MACRO ident) meta_contents
  //     lux_command *
  //     K_END_MACRO
  public static boolean meta_macro(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_macro")) return false;
    if (!nextTokenIs(b, K_MACRO)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = meta_macro_0(b, l + 1);
    r = r && meta_contents(b, l + 1);
    r = r && meta_macro_2(b, l + 1);
    r = r && consumeToken(b, K_END_MACRO);
    exit_section_(b, m, META_MACRO, r);
    return r;
  }

  // K_MACRO ident
  private static boolean meta_macro_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_macro_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_MACRO);
    r = r && ident(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // lux_command *
  private static boolean meta_macro_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_macro_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!lux_command(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "meta_macro_2", c)) break;
    }
    return true;
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
  // K_NEWSHELL_ONLY | (K_NEWSHELL meta_contents)
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

  // K_NEWSHELL meta_contents
  private static boolean meta_newshell_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_newshell_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_NEWSHELL);
    r = r && meta_contents(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // K_PROGRESS meta_contents
  public static boolean meta_progress(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_progress")) return false;
    if (!nextTokenIs(b, K_PROGRESS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_PROGRESS);
    r = r && meta_contents(b, l + 1);
    exit_section_(b, m, META_PROGRESS, r);
    return r;
  }

  /* ********************************************************** */
  // K_SHELL_ONLY | (K_SHELL ident meta_contents)
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

  // K_SHELL ident meta_contents
  private static boolean meta_shell_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_shell_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_SHELL);
    r = r && ident(b, l + 1);
    r = r && meta_contents(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // K_SLEEP inner_number
  public static boolean meta_sleep(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_sleep")) return false;
    if (!nextTokenIs(b, K_SLEEP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_SLEEP);
    r = r && inner_number(b, l + 1);
    exit_section_(b, m, META_SLEEP, r);
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
  // K_ML_EXP_MAYBE_REGEX inner_multiline T_TRIPLE_QUOTE
  public static boolean ml_expect_maybe_regex(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ml_expect_maybe_regex")) return false;
    if (!nextTokenIs(b, K_ML_EXP_MAYBE_REGEX)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_ML_EXP_MAYBE_REGEX);
    r = r && inner_multiline(b, l + 1);
    r = r && consumeToken(b, T_TRIPLE_QUOTE);
    exit_section_(b, m, ML_EXPECT_MAYBE_REGEX, r);
    return r;
  }

  /* ********************************************************** */
  // K_ML_EXP_REGEX inner_multiline T_TRIPLE_QUOTE
  public static boolean ml_expect_regex(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ml_expect_regex")) return false;
    if (!nextTokenIs(b, K_ML_EXP_REGEX)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_ML_EXP_REGEX);
    r = r && inner_multiline(b, l + 1);
    r = r && consumeToken(b, T_TRIPLE_QUOTE);
    exit_section_(b, m, ML_EXPECT_REGEX, r);
    return r;
  }

  /* ********************************************************** */
  // K_ML_EXP_TEMPLATE inner_multiline T_TRIPLE_QUOTE
  public static boolean ml_expect_template(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ml_expect_template")) return false;
    if (!nextTokenIs(b, K_ML_EXP_TEMPLATE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_ML_EXP_TEMPLATE);
    r = r && inner_multiline(b, l + 1);
    r = r && consumeToken(b, T_TRIPLE_QUOTE);
    exit_section_(b, m, ML_EXPECT_TEMPLATE, r);
    return r;
  }

  /* ********************************************************** */
  // K_ML_EXP_VERBATIM inner_multiline T_TRIPLE_QUOTE
  public static boolean ml_expect_verbatim(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ml_expect_verbatim")) return false;
    if (!nextTokenIs(b, K_ML_EXP_VERBATIM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_ML_EXP_VERBATIM);
    r = r && inner_multiline(b, l + 1);
    r = r && consumeToken(b, T_TRIPLE_QUOTE);
    exit_section_(b, m, ML_EXPECT_VERBATIM, r);
    return r;
  }

  /* ********************************************************** */
  // K_ML_SEND inner_multiline T_TRIPLE_QUOTE
  public static boolean ml_send(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ml_send")) return false;
    if (!nextTokenIs(b, K_ML_SEND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_ML_SEND);
    r = r && inner_multiline(b, l + 1);
    r = r && consumeToken(b, T_TRIPLE_QUOTE);
    exit_section_(b, m, ML_SEND, r);
    return r;
  }

  /* ********************************************************** */
  // K_ML_SEND_LN inner_multiline T_TRIPLE_QUOTE
  public static boolean ml_send_ln(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ml_send_ln")) return false;
    if (!nextTokenIs(b, K_ML_SEND_LN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_ML_SEND_LN);
    r = r && inner_multiline(b, l + 1);
    r = r && consumeToken(b, T_TRIPLE_QUOTE);
    exit_section_(b, m, ML_SEND_LN, r);
    return r;
  }

  /* ********************************************************** */
  // K_ML_SET_FAILURE inner_multiline T_TRIPLE_QUOTE
  public static boolean ml_set_failure(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ml_set_failure")) return false;
    if (!nextTokenIs(b, K_ML_SET_FAILURE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_ML_SET_FAILURE);
    r = r && inner_multiline(b, l + 1);
    r = r && consumeToken(b, T_TRIPLE_QUOTE);
    exit_section_(b, m, ML_SET_FAILURE, r);
    return r;
  }

  /* ********************************************************** */
  // K_ML_SET_LOOP_BREAK inner_multiline T_TRIPLE_QUOTE
  public static boolean ml_set_loop_break(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ml_set_loop_break")) return false;
    if (!nextTokenIs(b, K_ML_SET_LOOP_BREAK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_ML_SET_LOOP_BREAK);
    r = r && inner_multiline(b, l + 1);
    r = r && consumeToken(b, T_TRIPLE_QUOTE);
    exit_section_(b, m, ML_SET_LOOP_BREAK, r);
    return r;
  }

  /* ********************************************************** */
  // K_ML_SET_SUCCESS inner_multiline T_TRIPLE_QUOTE
  public static boolean ml_set_success(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ml_set_success")) return false;
    if (!nextTokenIs(b, K_ML_SET_SUCCESS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_ML_SET_SUCCESS);
    r = r && inner_multiline(b, l + 1);
    r = r && consumeToken(b, T_TRIPLE_QUOTE);
    exit_section_(b, m, ML_SET_SUCCESS, r);
    return r;
  }

  /* ********************************************************** */
  // TEXT | paste | CRLF
  static boolean multiline_contents(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiline_contents")) return false;
    boolean r;
    r = consumeToken(b, TEXT);
    if (!r) r = paste(b, l + 1);
    if (!r) r = consumeToken(b, CRLF);
    return r;
  }

  /* ********************************************************** */
  // TEXT | CRLF
  static boolean multiline_text(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiline_text")) return false;
    if (!nextTokenIs(b, "", CRLF, TEXT)) return false;
    boolean r;
    r = consumeToken(b, TEXT);
    if (!r) r = consumeToken(b, CRLF);
    return r;
  }

  /* ********************************************************** */
  // T_DOLLAR | T_PASTE_VARIABLE | T_PASTE_CAPTURE | T_PASTE_EXITCODE
  static boolean paste(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paste")) return false;
    boolean r;
    r = consumeToken(b, T_DOLLAR);
    if (!r) r = consumeToken(b, T_PASTE_VARIABLE);
    if (!r) r = consumeToken(b, T_PASTE_CAPTURE);
    if (!r) r = consumeToken(b, T_PASTE_EXITCODE);
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
  // send | ml_send
  static boolean send_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "send_")) return false;
    if (!nextTokenIs(b, "", K_ML_SEND, K_SEND)) return false;
    boolean r;
    r = send(b, l + 1);
    if (!r) r = ml_send(b, l + 1);
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
  // send_ln | ml_send_ln
  static boolean send_ln_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "send_ln_")) return false;
    if (!nextTokenIs(b, "", K_ML_SEND_LN, K_SEND_LN)) return false;
    boolean r;
    r = send_ln(b, l + 1);
    if (!r) r = ml_send_ln(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // K_SET_FAILURE inner_line
  public static boolean set_failure(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_failure")) return false;
    if (!nextTokenIs(b, K_SET_FAILURE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_SET_FAILURE);
    r = r && inner_line(b, l + 1);
    exit_section_(b, m, SET_FAILURE, r);
    return r;
  }

  /* ********************************************************** */
  // set_failure | set_failure_only | ml_set_failure
  static boolean set_failure_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_failure_")) return false;
    boolean r;
    r = set_failure(b, l + 1);
    if (!r) r = set_failure_only(b, l + 1);
    if (!r) r = ml_set_failure(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // K_SET_FAILURE_ONLY
  public static boolean set_failure_only(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_failure_only")) return false;
    if (!nextTokenIs(b, K_SET_FAILURE_ONLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_SET_FAILURE_ONLY);
    exit_section_(b, m, SET_FAILURE_ONLY, r);
    return r;
  }

  /* ********************************************************** */
  // K_SET_LOOP_BREAK inner_line
  public static boolean set_loop_break(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_loop_break")) return false;
    if (!nextTokenIs(b, K_SET_LOOP_BREAK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_SET_LOOP_BREAK);
    r = r && inner_line(b, l + 1);
    exit_section_(b, m, SET_LOOP_BREAK, r);
    return r;
  }

  /* ********************************************************** */
  // set_loop_break_only | set_loop_break | ml_set_loop_break
  static boolean set_loop_break_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_loop_break_")) return false;
    boolean r;
    r = set_loop_break_only(b, l + 1);
    if (!r) r = set_loop_break(b, l + 1);
    if (!r) r = ml_set_loop_break(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // K_SET_LOOP_BREAK_ONLY
  public static boolean set_loop_break_only(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_loop_break_only")) return false;
    if (!nextTokenIs(b, K_SET_LOOP_BREAK_ONLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_SET_LOOP_BREAK_ONLY);
    exit_section_(b, m, SET_LOOP_BREAK_ONLY, r);
    return r;
  }

  /* ********************************************************** */
  // K_SET_SUCCESS inner_line
  public static boolean set_success(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_success")) return false;
    if (!nextTokenIs(b, K_SET_SUCCESS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_SET_SUCCESS);
    r = r && inner_line(b, l + 1);
    exit_section_(b, m, SET_SUCCESS, r);
    return r;
  }

  /* ********************************************************** */
  // set_success | set_success_only | ml_set_success
  static boolean set_success_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_success_")) return false;
    boolean r;
    r = set_success(b, l + 1);
    if (!r) r = set_success_only(b, l + 1);
    if (!r) r = ml_set_success(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // K_SET_SUCCESS_ONLY
  public static boolean set_success_only(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_success_only")) return false;
    if (!nextTokenIs(b, K_SET_SUCCESS_ONLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_SET_SUCCESS_ONLY);
    exit_section_(b, m, SET_SUCCESS_ONLY, r);
    return r;
  }

}
