// This is a generated file. Not intended for manual editing.
package se.clau.intellijlux.gen.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import se.clau.intellijlux.psi.LuxElementType;
import se.clau.intellijlux.psi.LuxTokenType;
import se.clau.intellijlux.gen.impl.*;

public interface LuxTypes {

  IElementType EXPECT_MAYBE_REGEX = new LuxElementType("EXPECT_MAYBE_REGEX");
  IElementType EXPECT_REGEX = new LuxElementType("EXPECT_REGEX");
  IElementType EXPECT_TEMPLATE = new LuxElementType("EXPECT_TEMPLATE");
  IElementType EXPECT_VERBATIM = new LuxElementType("EXPECT_VERBATIM");
  IElementType FLUSH = new LuxElementType("FLUSH");
  IElementType IDENT = new LuxElementType("IDENT");
  IElementType META_CONFIG = new LuxElementType("META_CONFIG");
  IElementType META_DOC = new LuxElementType("META_DOC");
  IElementType META_GLOBAL = new LuxElementType("META_GLOBAL");
  IElementType META_INCLUDE = new LuxElementType("META_INCLUDE");
  IElementType META_INVOKE = new LuxElementType("META_INVOKE");
  IElementType META_LOCAL = new LuxElementType("META_LOCAL");
  IElementType META_LOOP = new LuxElementType("META_LOOP");
  IElementType META_MACRO = new LuxElementType("META_MACRO");
  IElementType META_MY = new LuxElementType("META_MY");
  IElementType META_NEWSHELL = new LuxElementType("META_NEWSHELL");
  IElementType META_PROGRESS = new LuxElementType("META_PROGRESS");
  IElementType META_SHELL = new LuxElementType("META_SHELL");
  IElementType META_SLEEP = new LuxElementType("META_SLEEP");
  IElementType META_TIMEOUT = new LuxElementType("META_TIMEOUT");
  IElementType ML_EXPECT_MAYBE_REGEX = new LuxElementType("ML_EXPECT_MAYBE_REGEX");
  IElementType ML_EXPECT_REGEX = new LuxElementType("ML_EXPECT_REGEX");
  IElementType ML_EXPECT_TEMPLATE = new LuxElementType("ML_EXPECT_TEMPLATE");
  IElementType ML_EXPECT_VERBATIM = new LuxElementType("ML_EXPECT_VERBATIM");
  IElementType ML_SEND = new LuxElementType("ML_SEND");
  IElementType ML_SEND_LN = new LuxElementType("ML_SEND_LN");
  IElementType ML_SET_FAILURE = new LuxElementType("ML_SET_FAILURE");
  IElementType ML_SET_LOOP_BREAK = new LuxElementType("ML_SET_LOOP_BREAK");
  IElementType ML_SET_SUCCESS = new LuxElementType("ML_SET_SUCCESS");
  IElementType SEND = new LuxElementType("SEND");
  IElementType SEND_LN = new LuxElementType("SEND_LN");
  IElementType SET_FAILURE = new LuxElementType("SET_FAILURE");
  IElementType SET_FAILURE_ONLY = new LuxElementType("SET_FAILURE_ONLY");
  IElementType SET_LOOP_BREAK = new LuxElementType("SET_LOOP_BREAK");
  IElementType SET_LOOP_BREAK_ONLY = new LuxElementType("SET_LOOP_BREAK_ONLY");
  IElementType SET_SUCCESS = new LuxElementType("SET_SUCCESS");
  IElementType SET_SUCCESS_ONLY = new LuxElementType("SET_SUCCESS_ONLY");

  IElementType COMMENT = new LuxTokenType("COMMENT");
  IElementType CRLF = new LuxTokenType("<newline>");
  IElementType END_META = new LuxTokenType("END_META");
  IElementType K_CLEANUP = new LuxTokenType("K_CLEANUP");
  IElementType K_CONFIG = new LuxTokenType("K_CONFIG");
  IElementType K_DOC = new LuxTokenType("K_DOC");
  IElementType K_DOC_ONLY = new LuxTokenType("K_DOC_ONLY");
  IElementType K_END_DOC = new LuxTokenType("K_END_DOC");
  IElementType K_END_LOOP = new LuxTokenType("K_END_LOOP");
  IElementType K_END_MACRO = new LuxTokenType("K_END_MACRO");
  IElementType K_EXP_MAYBE_REGEX = new LuxTokenType("K_EXP_MAYBE_REGEX");
  IElementType K_EXP_REGEX = new LuxTokenType("K_EXP_REGEX");
  IElementType K_EXP_TEMPLATE = new LuxTokenType("K_EXP_TEMPLATE");
  IElementType K_EXP_VERBATIM = new LuxTokenType("K_EXP_VERBATIM");
  IElementType K_FLUSH = new LuxTokenType("K_FLUSH");
  IElementType K_GLOBAL = new LuxTokenType("K_GLOBAL");
  IElementType K_INCLUDE = new LuxTokenType("K_INCLUDE");
  IElementType K_INVOKE = new LuxTokenType("K_INVOKE");
  IElementType K_LOCAL = new LuxTokenType("K_LOCAL");
  IElementType K_LOOP = new LuxTokenType("K_LOOP");
  IElementType K_MACRO = new LuxTokenType("K_MACRO");
  IElementType K_ML_EXP_MAYBE_REGEX = new LuxTokenType("K_ML_EXP_MAYBE_REGEX");
  IElementType K_ML_EXP_REGEX = new LuxTokenType("K_ML_EXP_REGEX");
  IElementType K_ML_EXP_TEMPLATE = new LuxTokenType("K_ML_EXP_TEMPLATE");
  IElementType K_ML_EXP_VERBATIM = new LuxTokenType("K_ML_EXP_VERBATIM");
  IElementType K_ML_SEND = new LuxTokenType("K_ML_SEND");
  IElementType K_ML_SEND_LN = new LuxTokenType("K_ML_SEND_LN");
  IElementType K_ML_SET_FAILURE = new LuxTokenType("K_ML_SET_FAILURE");
  IElementType K_ML_SET_LOOP_BREAK = new LuxTokenType("K_ML_SET_LOOP_BREAK");
  IElementType K_ML_SET_SUCCESS = new LuxTokenType("K_ML_SET_SUCCESS");
  IElementType K_MY = new LuxTokenType("K_MY");
  IElementType K_NEWSHELL = new LuxTokenType("K_NEWSHELL");
  IElementType K_NEWSHELL_ONLY = new LuxTokenType("K_NEWSHELL_ONLY");
  IElementType K_PROGRESS = new LuxTokenType("K_PROGRESS");
  IElementType K_SEND = new LuxTokenType("K_SEND");
  IElementType K_SEND_LN = new LuxTokenType("K_SEND_LN");
  IElementType K_SET_FAILURE = new LuxTokenType("K_SET_FAILURE");
  IElementType K_SET_FAILURE_ONLY = new LuxTokenType("K_SET_FAILURE_ONLY");
  IElementType K_SET_LOOP_BREAK = new LuxTokenType("K_SET_LOOP_BREAK");
  IElementType K_SET_LOOP_BREAK_ONLY = new LuxTokenType("K_SET_LOOP_BREAK_ONLY");
  IElementType K_SET_SUCCESS = new LuxTokenType("K_SET_SUCCESS");
  IElementType K_SET_SUCCESS_ONLY = new LuxTokenType("K_SET_SUCCESS_ONLY");
  IElementType K_SHELL = new LuxTokenType("K_SHELL");
  IElementType K_SHELL_ONLY = new LuxTokenType("K_SHELL_ONLY");
  IElementType K_SLEEP = new LuxTokenType("K_SLEEP");
  IElementType K_TIMEOUT = new LuxTokenType("K_TIMEOUT");
  IElementType K_TIMEOUT_ONLY = new LuxTokenType("K_TIMEOUT_ONLY");
  IElementType LINE_CONTINUATION = new LuxTokenType("LINE_CONTINUATION");
  IElementType TEXT = new LuxTokenType("TEXT");
  IElementType T_AT = new LuxTokenType("@");
  IElementType T_BANG = new LuxTokenType("!");
  IElementType T_DOLLAR = new LuxTokenType("T_DOLLAR");
  IElementType T_DOUBLE_QUESTION = new LuxTokenType("??");
  IElementType T_EQUALS = new LuxTokenType("T_EQUALS");
  IElementType T_IDENT = new LuxTokenType("T_IDENT");
  IElementType T_MINUS = new LuxTokenType("-");
  IElementType T_NUMBER = new LuxTokenType("T_NUMBER");
  IElementType T_PASTE_CAPTURE = new LuxTokenType("T_PASTE_CAPTURE");
  IElementType T_PASTE_EXITCODE = new LuxTokenType("T_PASTE_EXITCODE");
  IElementType T_PASTE_VARIABLE = new LuxTokenType("T_PASTE_VARIABLE");
  IElementType T_PLUS = new LuxTokenType("+");
  IElementType T_QUESTION = new LuxTokenType("?");
  IElementType T_QUESTION_PLUS = new LuxTokenType("?+");
  IElementType T_SQR_CLOSE = new LuxTokenType("]");
  IElementType T_SQR_OPEN = new LuxTokenType("[");
  IElementType T_TILDE = new LuxTokenType("~");
  IElementType T_TRIPLE_QUESTION = new LuxTokenType("???");
  IElementType T_TRIPLE_QUOTE = new LuxTokenType("T_TRIPLE_QUOTE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == EXPECT_MAYBE_REGEX) {
        return new LuxExpectMaybeRegexImpl(node);
      }
      else if (type == EXPECT_REGEX) {
        return new LuxExpectRegexImpl(node);
      }
      else if (type == EXPECT_TEMPLATE) {
        return new LuxExpectTemplateImpl(node);
      }
      else if (type == EXPECT_VERBATIM) {
        return new LuxExpectVerbatimImpl(node);
      }
      else if (type == FLUSH) {
        return new LuxFlushImpl(node);
      }
      else if (type == IDENT) {
        return new LuxIdentImpl(node);
      }
      else if (type == META_CONFIG) {
        return new LuxMetaConfigImpl(node);
      }
      else if (type == META_DOC) {
        return new LuxMetaDocImpl(node);
      }
      else if (type == META_GLOBAL) {
        return new LuxMetaGlobalImpl(node);
      }
      else if (type == META_INCLUDE) {
        return new LuxMetaIncludeImpl(node);
      }
      else if (type == META_INVOKE) {
        return new LuxMetaInvokeImpl(node);
      }
      else if (type == META_LOCAL) {
        return new LuxMetaLocalImpl(node);
      }
      else if (type == META_LOOP) {
        return new LuxMetaLoopImpl(node);
      }
      else if (type == META_MACRO) {
        return new LuxMetaMacroImpl(node);
      }
      else if (type == META_MY) {
        return new LuxMetaMyImpl(node);
      }
      else if (type == META_NEWSHELL) {
        return new LuxMetaNewshellImpl(node);
      }
      else if (type == META_PROGRESS) {
        return new LuxMetaProgressImpl(node);
      }
      else if (type == META_SHELL) {
        return new LuxMetaShellImpl(node);
      }
      else if (type == META_SLEEP) {
        return new LuxMetaSleepImpl(node);
      }
      else if (type == META_TIMEOUT) {
        return new LuxMetaTimeoutImpl(node);
      }
      else if (type == ML_EXPECT_MAYBE_REGEX) {
        return new LuxMlExpectMaybeRegexImpl(node);
      }
      else if (type == ML_EXPECT_REGEX) {
        return new LuxMlExpectRegexImpl(node);
      }
      else if (type == ML_EXPECT_TEMPLATE) {
        return new LuxMlExpectTemplateImpl(node);
      }
      else if (type == ML_EXPECT_VERBATIM) {
        return new LuxMlExpectVerbatimImpl(node);
      }
      else if (type == ML_SEND) {
        return new LuxMlSendImpl(node);
      }
      else if (type == ML_SEND_LN) {
        return new LuxMlSendLnImpl(node);
      }
      else if (type == ML_SET_FAILURE) {
        return new LuxMlSetFailureImpl(node);
      }
      else if (type == ML_SET_LOOP_BREAK) {
        return new LuxMlSetLoopBreakImpl(node);
      }
      else if (type == ML_SET_SUCCESS) {
        return new LuxMlSetSuccessImpl(node);
      }
      else if (type == SEND) {
        return new LuxSendImpl(node);
      }
      else if (type == SEND_LN) {
        return new LuxSendLnImpl(node);
      }
      else if (type == SET_FAILURE) {
        return new LuxSetFailureImpl(node);
      }
      else if (type == SET_FAILURE_ONLY) {
        return new LuxSetFailureOnlyImpl(node);
      }
      else if (type == SET_LOOP_BREAK) {
        return new LuxSetLoopBreakImpl(node);
      }
      else if (type == SET_LOOP_BREAK_ONLY) {
        return new LuxSetLoopBreakOnlyImpl(node);
      }
      else if (type == SET_SUCCESS) {
        return new LuxSetSuccessImpl(node);
      }
      else if (type == SET_SUCCESS_ONLY) {
        return new LuxSetSuccessOnlyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
