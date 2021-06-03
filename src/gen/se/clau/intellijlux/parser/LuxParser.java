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

  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    parseLight(root_, builder_);
    return builder_.getTreeBuilt();
  }

  public void parseLight(IElementType root_, PsiBuilder builder_) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, null);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    result_ = parse_root_(root_, builder_);
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType root_, PsiBuilder builder_) {
    return parse_root_(root_, builder_, 0);
  }

  static boolean parse_root_(IElementType root_, PsiBuilder builder_, int level_) {
    return lux_file(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // (K_EXP_MAYBE_REGEX inner_line)
  //     | (K_ML_EXP_MAYBE_REGEX inner_multiline T_TRIPLE_QUOTE)
  public static boolean expect_maybe_regex(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expect_maybe_regex")) return false;
    if (!nextTokenIs(builder_, "<expect maybe regex>", K_EXP_MAYBE_REGEX, K_ML_EXP_MAYBE_REGEX)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, EXPECT_MAYBE_REGEX, "<expect maybe regex>");
    result_ = expect_maybe_regex_0(builder_, level_ + 1);
    if (!result_) result_ = expect_maybe_regex_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // K_EXP_MAYBE_REGEX inner_line
  private static boolean expect_maybe_regex_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expect_maybe_regex_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_EXP_MAYBE_REGEX);
    result_ = result_ && inner_line(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // K_ML_EXP_MAYBE_REGEX inner_multiline T_TRIPLE_QUOTE
  private static boolean expect_maybe_regex_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expect_maybe_regex_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_ML_EXP_MAYBE_REGEX);
    result_ = result_ && inner_multiline(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, T_TRIPLE_QUOTE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // (K_EXP_REGEX inner_line)
  //     | (K_ML_EXP_REGEX inner_multiline T_TRIPLE_QUOTE)
  public static boolean expect_regex(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expect_regex")) return false;
    if (!nextTokenIs(builder_, "<expect regex>", K_EXP_REGEX, K_ML_EXP_REGEX)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, EXPECT_REGEX, "<expect regex>");
    result_ = expect_regex_0(builder_, level_ + 1);
    if (!result_) result_ = expect_regex_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // K_EXP_REGEX inner_line
  private static boolean expect_regex_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expect_regex_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_EXP_REGEX);
    result_ = result_ && inner_line(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // K_ML_EXP_REGEX inner_multiline T_TRIPLE_QUOTE
  private static boolean expect_regex_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expect_regex_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_ML_EXP_REGEX);
    result_ = result_ && inner_multiline(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, T_TRIPLE_QUOTE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // (K_EXP_TEMPLATE inner_line)
  //     | (K_ML_EXP_TEMPLATE inner_multiline T_TRIPLE_QUOTE)
  public static boolean expect_template(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expect_template")) return false;
    if (!nextTokenIs(builder_, "<expect template>", K_EXP_TEMPLATE, K_ML_EXP_TEMPLATE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, EXPECT_TEMPLATE, "<expect template>");
    result_ = expect_template_0(builder_, level_ + 1);
    if (!result_) result_ = expect_template_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // K_EXP_TEMPLATE inner_line
  private static boolean expect_template_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expect_template_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_EXP_TEMPLATE);
    result_ = result_ && inner_line(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // K_ML_EXP_TEMPLATE inner_multiline T_TRIPLE_QUOTE
  private static boolean expect_template_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expect_template_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_ML_EXP_TEMPLATE);
    result_ = result_ && inner_multiline(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, T_TRIPLE_QUOTE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // (K_EXP_VERBATIM inner_line)
  //     | (K_ML_EXP_VERBATIM inner_multiline T_TRIPLE_QUOTE)
  public static boolean expect_verbatim(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expect_verbatim")) return false;
    if (!nextTokenIs(builder_, "<expect verbatim>", K_EXP_VERBATIM, K_ML_EXP_VERBATIM)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, EXPECT_VERBATIM, "<expect verbatim>");
    result_ = expect_verbatim_0(builder_, level_ + 1);
    if (!result_) result_ = expect_verbatim_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // K_EXP_VERBATIM inner_line
  private static boolean expect_verbatim_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expect_verbatim_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_EXP_VERBATIM);
    result_ = result_ && inner_line(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // K_ML_EXP_VERBATIM inner_multiline T_TRIPLE_QUOTE
  private static boolean expect_verbatim_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expect_verbatim_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_ML_EXP_VERBATIM);
    result_ = result_ && inner_multiline(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, T_TRIPLE_QUOTE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // K_FLUSH
  public static boolean flush(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "flush")) return false;
    if (!nextTokenIs(builder_, K_FLUSH)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_FLUSH);
    exit_section_(builder_, marker_, FLUSH, result_);
    return result_;
  }

  /* ********************************************************** */
  // T_IDENT
  public static boolean ident(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ident")) return false;
    if (!nextTokenIs(builder_, T_IDENT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, T_IDENT);
    exit_section_(builder_, marker_, IDENT, result_);
    return result_;
  }

  /* ********************************************************** */
  // line_contents * CRLF
  static boolean inner_line(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "inner_line")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = inner_line_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, CRLF);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // line_contents *
  private static boolean inner_line_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "inner_line_0")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!line_contents(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "inner_line_0", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // multiline_contents *
  static boolean inner_multiline(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "inner_multiline")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!multiline_contents(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "inner_multiline", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // T_NUMBER T_SQR_CLOSE CRLF
  static boolean inner_number(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "inner_number")) return false;
    if (!nextTokenIs(builder_, T_NUMBER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, T_NUMBER, T_SQR_CLOSE, CRLF);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // ident T_EQUALS meta_contents
  static boolean inner_x_equals_y(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "inner_x_equals_y")) return false;
    if (!nextTokenIs(builder_, T_IDENT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = ident(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, T_EQUALS);
    result_ = result_ && meta_contents(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // TEXT | paste | LINE_CONTINUATION
  static boolean line_contents(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "line_contents")) return false;
    boolean result_;
    result_ = consumeToken(builder_, TEXT);
    if (!result_) result_ = paste(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, LINE_CONTINUATION);
    return result_;
  }

  /* ********************************************************** */
  // COMMENT | CRLF
  //     | meta_doc | K_END_DOC
  //     | meta_shell | meta_newshell
  //     | meta_timeout | meta_sleep
  //     | meta_config | meta_local | meta_global | meta_my
  //     | K_CLEANUP | meta_include
  //     | meta_invoke
  //     | meta_loop | K_END_LOOP
  //     | meta_progress
  //     | send | send_ln | expect_verbatim | expect_template | expect_regex
  //     | flush | expect_maybe_regex | set_failure | set_success | set_loop_break
  static boolean lux_command(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lux_command")) return false;
    boolean result_;
    result_ = consumeToken(builder_, COMMENT);
    if (!result_) result_ = consumeToken(builder_, CRLF);
    if (!result_) result_ = meta_doc(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, K_END_DOC);
    if (!result_) result_ = meta_shell(builder_, level_ + 1);
    if (!result_) result_ = meta_newshell(builder_, level_ + 1);
    if (!result_) result_ = meta_timeout(builder_, level_ + 1);
    if (!result_) result_ = meta_sleep(builder_, level_ + 1);
    if (!result_) result_ = meta_config(builder_, level_ + 1);
    if (!result_) result_ = meta_local(builder_, level_ + 1);
    if (!result_) result_ = meta_global(builder_, level_ + 1);
    if (!result_) result_ = meta_my(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, K_CLEANUP);
    if (!result_) result_ = meta_include(builder_, level_ + 1);
    if (!result_) result_ = meta_invoke(builder_, level_ + 1);
    if (!result_) result_ = meta_loop(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, K_END_LOOP);
    if (!result_) result_ = meta_progress(builder_, level_ + 1);
    if (!result_) result_ = send(builder_, level_ + 1);
    if (!result_) result_ = send_ln(builder_, level_ + 1);
    if (!result_) result_ = expect_verbatim(builder_, level_ + 1);
    if (!result_) result_ = expect_template(builder_, level_ + 1);
    if (!result_) result_ = expect_regex(builder_, level_ + 1);
    if (!result_) result_ = flush(builder_, level_ + 1);
    if (!result_) result_ = expect_maybe_regex(builder_, level_ + 1);
    if (!result_) result_ = set_failure(builder_, level_ + 1);
    if (!result_) result_ = set_success(builder_, level_ + 1);
    if (!result_) result_ = set_loop_break(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // lux_file_item *
  static boolean lux_file(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lux_file")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!lux_file_item(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "lux_file", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // meta_macro | lux_command
  static boolean lux_file_item(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lux_file_item")) return false;
    boolean result_;
    result_ = meta_macro(builder_, level_ + 1);
    if (!result_) result_ = lux_command(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // K_CONFIG inner_x_equals_y
  public static boolean meta_config(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "meta_config")) return false;
    if (!nextTokenIs(builder_, K_CONFIG)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_CONFIG);
    result_ = result_ && inner_x_equals_y(builder_, level_ + 1);
    exit_section_(builder_, marker_, META_CONFIG, result_);
    return result_;
  }

  /* ********************************************************** */
  // ( meta_element * ) END_META
  static boolean meta_contents(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "meta_contents")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = meta_contents_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, END_META);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // meta_element *
  private static boolean meta_contents_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "meta_contents_0")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!meta_element(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "meta_contents_0", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (K_DOC meta_contents) | (K_DOC_ONLY multiline_text K_END_DOC)
  public static boolean meta_doc(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "meta_doc")) return false;
    if (!nextTokenIs(builder_, "<meta doc>", K_DOC, K_DOC_ONLY)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, META_DOC, "<meta doc>");
    result_ = meta_doc_0(builder_, level_ + 1);
    if (!result_) result_ = meta_doc_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // K_DOC meta_contents
  private static boolean meta_doc_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "meta_doc_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_DOC);
    result_ = result_ && meta_contents(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // K_DOC_ONLY multiline_text K_END_DOC
  private static boolean meta_doc_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "meta_doc_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_DOC_ONLY);
    result_ = result_ && multiline_text(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, K_END_DOC);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // TEXT | paste
  static boolean meta_element(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "meta_element")) return false;
    boolean result_;
    result_ = consumeToken(builder_, TEXT);
    if (!result_) result_ = paste(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // K_GLOBAL inner_x_equals_y
  public static boolean meta_global(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "meta_global")) return false;
    if (!nextTokenIs(builder_, K_GLOBAL)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_GLOBAL);
    result_ = result_ && inner_x_equals_y(builder_, level_ + 1);
    exit_section_(builder_, marker_, META_GLOBAL, result_);
    return result_;
  }

  /* ********************************************************** */
  // K_INCLUDE meta_contents
  public static boolean meta_include(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "meta_include")) return false;
    if (!nextTokenIs(builder_, K_INCLUDE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_INCLUDE);
    result_ = result_ && meta_contents(builder_, level_ + 1);
    exit_section_(builder_, marker_, META_INCLUDE, result_);
    return result_;
  }

  /* ********************************************************** */
  // (K_INVOKE ident) meta_contents
  public static boolean meta_invoke(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "meta_invoke")) return false;
    if (!nextTokenIs(builder_, K_INVOKE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = meta_invoke_0(builder_, level_ + 1);
    result_ = result_ && meta_contents(builder_, level_ + 1);
    exit_section_(builder_, marker_, META_INVOKE, result_);
    return result_;
  }

  // K_INVOKE ident
  private static boolean meta_invoke_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "meta_invoke_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_INVOKE);
    result_ = result_ && ident(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // K_LOCAL inner_x_equals_y
  public static boolean meta_local(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "meta_local")) return false;
    if (!nextTokenIs(builder_, K_LOCAL)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_LOCAL);
    result_ = result_ && inner_x_equals_y(builder_, level_ + 1);
    exit_section_(builder_, marker_, META_LOCAL, result_);
    return result_;
  }

  /* ********************************************************** */
  // (K_LOOP ident) meta_contents
  public static boolean meta_loop(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "meta_loop")) return false;
    if (!nextTokenIs(builder_, K_LOOP)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = meta_loop_0(builder_, level_ + 1);
    result_ = result_ && meta_contents(builder_, level_ + 1);
    exit_section_(builder_, marker_, META_LOOP, result_);
    return result_;
  }

  // K_LOOP ident
  private static boolean meta_loop_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "meta_loop_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_LOOP);
    result_ = result_ && ident(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // (K_MACRO ident) meta_contents
  //     lux_command *
  //     K_END_MACRO
  public static boolean meta_macro(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "meta_macro")) return false;
    if (!nextTokenIs(builder_, K_MACRO)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = meta_macro_0(builder_, level_ + 1);
    result_ = result_ && meta_contents(builder_, level_ + 1);
    result_ = result_ && meta_macro_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, K_END_MACRO);
    exit_section_(builder_, marker_, META_MACRO, result_);
    return result_;
  }

  // K_MACRO ident
  private static boolean meta_macro_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "meta_macro_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_MACRO);
    result_ = result_ && ident(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // lux_command *
  private static boolean meta_macro_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "meta_macro_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!lux_command(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "meta_macro_2", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // K_MY inner_x_equals_y
  public static boolean meta_my(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "meta_my")) return false;
    if (!nextTokenIs(builder_, K_MY)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_MY);
    result_ = result_ && inner_x_equals_y(builder_, level_ + 1);
    exit_section_(builder_, marker_, META_MY, result_);
    return result_;
  }

  /* ********************************************************** */
  // K_NEWSHELL_ONLY | (K_NEWSHELL meta_contents)
  public static boolean meta_newshell(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "meta_newshell")) return false;
    if (!nextTokenIs(builder_, "<meta newshell>", K_NEWSHELL, K_NEWSHELL_ONLY)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, META_NEWSHELL, "<meta newshell>");
    result_ = consumeToken(builder_, K_NEWSHELL_ONLY);
    if (!result_) result_ = meta_newshell_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // K_NEWSHELL meta_contents
  private static boolean meta_newshell_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "meta_newshell_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_NEWSHELL);
    result_ = result_ && meta_contents(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // K_PROGRESS meta_contents
  public static boolean meta_progress(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "meta_progress")) return false;
    if (!nextTokenIs(builder_, K_PROGRESS)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_PROGRESS);
    result_ = result_ && meta_contents(builder_, level_ + 1);
    exit_section_(builder_, marker_, META_PROGRESS, result_);
    return result_;
  }

  /* ********************************************************** */
  // K_SHELL_ONLY | (K_SHELL ident meta_contents)
  public static boolean meta_shell(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "meta_shell")) return false;
    if (!nextTokenIs(builder_, "<meta shell>", K_SHELL, K_SHELL_ONLY)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, META_SHELL, "<meta shell>");
    result_ = consumeToken(builder_, K_SHELL_ONLY);
    if (!result_) result_ = meta_shell_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // K_SHELL ident meta_contents
  private static boolean meta_shell_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "meta_shell_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_SHELL);
    result_ = result_ && ident(builder_, level_ + 1);
    result_ = result_ && meta_contents(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // K_SLEEP inner_number
  public static boolean meta_sleep(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "meta_sleep")) return false;
    if (!nextTokenIs(builder_, K_SLEEP)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_SLEEP);
    result_ = result_ && inner_number(builder_, level_ + 1);
    exit_section_(builder_, marker_, META_SLEEP, result_);
    return result_;
  }

  /* ********************************************************** */
  // K_TIMEOUT_ONLY | (K_TIMEOUT inner_number)
  public static boolean meta_timeout(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "meta_timeout")) return false;
    if (!nextTokenIs(builder_, "<meta timeout>", K_TIMEOUT, K_TIMEOUT_ONLY)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, META_TIMEOUT, "<meta timeout>");
    result_ = consumeToken(builder_, K_TIMEOUT_ONLY);
    if (!result_) result_ = meta_timeout_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // K_TIMEOUT inner_number
  private static boolean meta_timeout_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "meta_timeout_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_TIMEOUT);
    result_ = result_ && inner_number(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // TEXT | paste | CRLF
  static boolean multiline_contents(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "multiline_contents")) return false;
    boolean result_;
    result_ = consumeToken(builder_, TEXT);
    if (!result_) result_ = paste(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, CRLF);
    return result_;
  }

  /* ********************************************************** */
  // TEXT | CRLF
  static boolean multiline_text(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "multiline_text")) return false;
    if (!nextTokenIs(builder_, "", CRLF, TEXT)) return false;
    boolean result_;
    result_ = consumeToken(builder_, TEXT);
    if (!result_) result_ = consumeToken(builder_, CRLF);
    return result_;
  }

  /* ********************************************************** */
  // T_DOLLAR | T_PASTE_VARIABLE | T_PASTE_CAPTURE | T_PASTE_EXITCODE
  static boolean paste(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "paste")) return false;
    boolean result_;
    result_ = consumeToken(builder_, T_DOLLAR);
    if (!result_) result_ = consumeToken(builder_, T_PASTE_VARIABLE);
    if (!result_) result_ = consumeToken(builder_, T_PASTE_CAPTURE);
    if (!result_) result_ = consumeToken(builder_, T_PASTE_EXITCODE);
    return result_;
  }

  /* ********************************************************** */
  // (K_SEND inner_line)
  //     | (K_ML_SEND inner_multiline T_TRIPLE_QUOTE)
  public static boolean send(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "send")) return false;
    if (!nextTokenIs(builder_, "<send>", K_ML_SEND, K_SEND)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, SEND, "<send>");
    result_ = send_0(builder_, level_ + 1);
    if (!result_) result_ = send_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // K_SEND inner_line
  private static boolean send_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "send_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_SEND);
    result_ = result_ && inner_line(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // K_ML_SEND inner_multiline T_TRIPLE_QUOTE
  private static boolean send_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "send_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_ML_SEND);
    result_ = result_ && inner_multiline(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, T_TRIPLE_QUOTE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // (K_SEND_LN inner_line)
  //     | (K_ML_SEND_LN inner_multiline T_TRIPLE_QUOTE)
  public static boolean send_ln(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "send_ln")) return false;
    if (!nextTokenIs(builder_, "<send ln>", K_ML_SEND_LN, K_SEND_LN)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, SEND_LN, "<send ln>");
    result_ = send_ln_0(builder_, level_ + 1);
    if (!result_) result_ = send_ln_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // K_SEND_LN inner_line
  private static boolean send_ln_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "send_ln_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_SEND_LN);
    result_ = result_ && inner_line(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // K_ML_SEND_LN inner_multiline T_TRIPLE_QUOTE
  private static boolean send_ln_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "send_ln_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_ML_SEND_LN);
    result_ = result_ && inner_multiline(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, T_TRIPLE_QUOTE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // K_SET_FAILURE_ONLY
  //     | (K_SET_FAILURE inner_line)
  //     | (K_ML_SET_FAILURE inner_multiline T_TRIPLE_QUOTE)
  public static boolean set_failure(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "set_failure")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, SET_FAILURE, "<set failure>");
    result_ = consumeToken(builder_, K_SET_FAILURE_ONLY);
    if (!result_) result_ = set_failure_1(builder_, level_ + 1);
    if (!result_) result_ = set_failure_2(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // K_SET_FAILURE inner_line
  private static boolean set_failure_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "set_failure_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_SET_FAILURE);
    result_ = result_ && inner_line(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // K_ML_SET_FAILURE inner_multiline T_TRIPLE_QUOTE
  private static boolean set_failure_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "set_failure_2")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_ML_SET_FAILURE);
    result_ = result_ && inner_multiline(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, T_TRIPLE_QUOTE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // K_SET_LOOP_BREAK_ONLY
  //     | (K_SET_LOOP_BREAK inner_line)
  //     | (K_ML_SET_LOOP_BREAK inner_multiline T_TRIPLE_QUOTE)
  public static boolean set_loop_break(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "set_loop_break")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, SET_LOOP_BREAK, "<set loop break>");
    result_ = consumeToken(builder_, K_SET_LOOP_BREAK_ONLY);
    if (!result_) result_ = set_loop_break_1(builder_, level_ + 1);
    if (!result_) result_ = set_loop_break_2(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // K_SET_LOOP_BREAK inner_line
  private static boolean set_loop_break_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "set_loop_break_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_SET_LOOP_BREAK);
    result_ = result_ && inner_line(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // K_ML_SET_LOOP_BREAK inner_multiline T_TRIPLE_QUOTE
  private static boolean set_loop_break_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "set_loop_break_2")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_ML_SET_LOOP_BREAK);
    result_ = result_ && inner_multiline(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, T_TRIPLE_QUOTE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // K_SET_SUCCESS_ONLY
  //     | (K_SET_SUCCESS inner_line)
  //     | (K_ML_SET_SUCCESS inner_multiline T_TRIPLE_QUOTE)
  public static boolean set_success(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "set_success")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, SET_SUCCESS, "<set success>");
    result_ = consumeToken(builder_, K_SET_SUCCESS_ONLY);
    if (!result_) result_ = set_success_1(builder_, level_ + 1);
    if (!result_) result_ = set_success_2(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // K_SET_SUCCESS inner_line
  private static boolean set_success_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "set_success_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_SET_SUCCESS);
    result_ = result_ && inner_line(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // K_ML_SET_SUCCESS inner_multiline T_TRIPLE_QUOTE
  private static boolean set_success_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "set_success_2")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, K_ML_SET_SUCCESS);
    result_ = result_ && inner_multiline(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, T_TRIPLE_QUOTE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

}
