// This is a generated file. Not intended for manual editing.
package se.clau.intellijlux.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import se.clau.intellijlux.impl.*;

public interface LuxTypes {

  IElementType META_CONFIG = new LuxElementType("META_CONFIG");
  IElementType META_DOC = new LuxElementType("META_DOC");
  IElementType META_NEWSHELL = new LuxElementType("META_NEWSHELL");
  IElementType META_SHELL = new LuxElementType("META_SHELL");
  IElementType META_TIMEOUT = new LuxElementType("META_TIMEOUT");

  IElementType COMMENT = new LuxTokenType("COMMENT");
  IElementType CRLF = new LuxTokenType("CRLF");
  IElementType K_CONFIG = new LuxTokenType("K_CONFIG");
  IElementType K_DOC = new LuxTokenType("K_DOC");
  IElementType K_DOC_ONLY = new LuxTokenType("K_DOC_ONLY");
  IElementType K_NEWSHELL = new LuxTokenType("K_NEWSHELL");
  IElementType K_NEWSHELL_ONLY = new LuxTokenType("K_NEWSHELL_ONLY");
  IElementType K_SHELL = new LuxTokenType("K_SHELL");
  IElementType K_SHELL_ONLY = new LuxTokenType("K_SHELL_ONLY");
  IElementType K_TIMEOUT = new LuxTokenType("K_TIMEOUT");
  IElementType K_TIMEOUT_ONLY = new LuxTokenType("K_TIMEOUT_ONLY");
  IElementType T_AT = new LuxTokenType("@");
  IElementType T_BANG = new LuxTokenType("!");
  IElementType T_DOUBLE_QUESTION = new LuxTokenType("??");
  IElementType T_EQUALS = new LuxTokenType("T_EQUALS");
  IElementType T_META_CONTENTS = new LuxTokenType("T_META_CONTENTS");
  IElementType T_MINUS = new LuxTokenType("-");
  IElementType T_NUMBER = new LuxTokenType("T_NUMBER");
  IElementType T_PLUS = new LuxTokenType("+");
  IElementType T_QUESTION = new LuxTokenType("?");
  IElementType T_QUESTION_PLUS = new LuxTokenType("?+");
  IElementType T_SQR_CLOSE = new LuxTokenType("]");
  IElementType T_SQR_OPEN = new LuxTokenType("[");
  IElementType T_TILDE = new LuxTokenType("~");
  IElementType T_TRIPLE_QUESTION = new LuxTokenType("???");
  IElementType T_WORD = new LuxTokenType("T_WORD");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == META_CONFIG) {
        return new LuxMetaConfigImpl(node);
      }
      else if (type == META_DOC) {
        return new LuxMetaDocImpl(node);
      }
      else if (type == META_NEWSHELL) {
        return new LuxMetaNewshellImpl(node);
      }
      else if (type == META_SHELL) {
        return new LuxMetaShellImpl(node);
      }
      else if (type == META_TIMEOUT) {
        return new LuxMetaTimeoutImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
