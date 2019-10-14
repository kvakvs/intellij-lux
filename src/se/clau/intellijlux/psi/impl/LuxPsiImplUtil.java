package se.clau.intellijlux.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import se.clau.intellijlux.psi.LuxIdent;
import se.clau.intellijlux.psi.LuxTypes;

public class LuxPsiImplUtil {

  // ...
//
//  public static PsiElement setName(SimpleProperty element, String newName) {
//    ASTNode keyNode = element.getNode().findChildByType(SimpleTypes.KEY);
//    if (keyNode != null) {
//
//      SimpleProperty property = SimpleElementFactory.createProperty(element.getProject(), newName);
//      ASTNode newKeyNode = property.getFirstChild().getNode();
//      element.getNode().replaceChild(keyNode, newKeyNode);
//    }
//    return element;
//  }
//
  public static PsiElement getNameIdentifier(LuxIdent element) {
    ASTNode keyNode = element.getNode().findChildByType(LuxTypes.IDENT);
    if (keyNode != null) {
      return keyNode.getPsi();
    } else {
      return null;
    }
  }

  // ...
}
