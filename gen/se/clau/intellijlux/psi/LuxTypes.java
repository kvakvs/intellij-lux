// This is a generated file. Not intended for manual editing.
package se.clau.intellijlux.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import se.clau.intellijlux.impl.*;

public interface LuxTypes {

  IElementType COMMAND = new LuxElementType("COMMAND");

  IElementType COMMENT = new LuxTokenType("COMMENT");
  IElementType CRLF = new LuxTokenType("CRLF");
  IElementType EXPECT_MAYBEREGEXP = new LuxTokenType("EXPECT_MAYBEREGEXP");
  IElementType EXPECT_REGEXP = new LuxTokenType("EXPECT_REGEXP");
  IElementType EXPECT_TEMPLATE = new LuxTokenType("EXPECT_TEMPLATE");
  IElementType EXPECT_VERBATIM = new LuxTokenType("EXPECT_VERBATIM");
  IElementType FLUSH = new LuxTokenType("FLUSH");
  IElementType META = new LuxTokenType("META");
  IElementType SEND = new LuxTokenType("SEND");
  IElementType SENDLN = new LuxTokenType("SENDLN");
  IElementType SET_FAILURE = new LuxTokenType("SET_FAILURE");
  IElementType SET_LOOPBREAK = new LuxTokenType("SET_LOOPBREAK");
  IElementType SET_SUCCESS = new LuxTokenType("SET_SUCCESS");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == COMMAND) {
        return new LuxCommandImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
