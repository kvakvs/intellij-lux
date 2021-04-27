// This is a generated file. Not intended for manual editing.
package se.clau.intellijlux.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static se.clau.intellijlux.psi.LuxTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import se.clau.intellijlux.psi.*;
import se.clau.intellijlux.psi.impl.LuxPsiImplUtil;

public class LuxMetaMacroImpl extends ASTWrapperPsiElement implements LuxMetaMacro {

  public LuxMetaMacroImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LuxVisitor visitor) {
    visitor.visitMetaMacro(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LuxVisitor) accept((LuxVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LuxExpectMaybeRegex> getExpectMaybeRegexList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LuxExpectMaybeRegex.class);
  }

  @Override
  @NotNull
  public List<LuxExpectRegex> getExpectRegexList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LuxExpectRegex.class);
  }

  @Override
  @NotNull
  public List<LuxExpectTemplate> getExpectTemplateList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LuxExpectTemplate.class);
  }

  @Override
  @NotNull
  public List<LuxExpectVerbatim> getExpectVerbatimList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LuxExpectVerbatim.class);
  }

  @Override
  @NotNull
  public List<LuxFlush> getFlushList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LuxFlush.class);
  }

  @Override
  @NotNull
  public LuxIdent getIdent() {
    return findNotNullChildByClass(LuxIdent.class);
  }

  @Override
  @NotNull
  public List<LuxMetaConfig> getMetaConfigList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LuxMetaConfig.class);
  }

  @Override
  @NotNull
  public List<LuxMetaDoc> getMetaDocList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LuxMetaDoc.class);
  }

  @Override
  @NotNull
  public List<LuxMetaGlobal> getMetaGlobalList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LuxMetaGlobal.class);
  }

  @Override
  @NotNull
  public List<LuxMetaInclude> getMetaIncludeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LuxMetaInclude.class);
  }

  @Override
  @NotNull
  public List<LuxMetaInvoke> getMetaInvokeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LuxMetaInvoke.class);
  }

  @Override
  @NotNull
  public List<LuxMetaLocal> getMetaLocalList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LuxMetaLocal.class);
  }

  @Override
  @NotNull
  public List<LuxMetaLoop> getMetaLoopList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LuxMetaLoop.class);
  }

  @Override
  @NotNull
  public List<LuxMetaMy> getMetaMyList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LuxMetaMy.class);
  }

  @Override
  @NotNull
  public List<LuxMetaNewshell> getMetaNewshellList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LuxMetaNewshell.class);
  }

  @Override
  @NotNull
  public List<LuxMetaProgress> getMetaProgressList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LuxMetaProgress.class);
  }

  @Override
  @NotNull
  public List<LuxMetaShell> getMetaShellList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LuxMetaShell.class);
  }

  @Override
  @NotNull
  public List<LuxMetaSleep> getMetaSleepList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LuxMetaSleep.class);
  }

  @Override
  @NotNull
  public List<LuxMetaTimeout> getMetaTimeoutList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LuxMetaTimeout.class);
  }

  @Override
  @NotNull
  public List<LuxSend> getSendList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LuxSend.class);
  }

  @Override
  @NotNull
  public List<LuxSendLn> getSendLnList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LuxSendLn.class);
  }

  @Override
  @NotNull
  public List<LuxSetFailure> getSetFailureList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LuxSetFailure.class);
  }

  @Override
  @NotNull
  public List<LuxSetLoopBreak> getSetLoopBreakList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LuxSetLoopBreak.class);
  }

  @Override
  @NotNull
  public List<LuxSetSuccess> getSetSuccessList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LuxSetSuccess.class);
  }

  @Override
  @NotNull
  public PsiElement getEndMeta() {
    return findNotNullChildByType(END_META);
  }

  @Override
  @NotNull
  public PsiElement getKEndMacro() {
    return findNotNullChildByType(K_END_MACRO);
  }

  @Override
  @NotNull
  public PsiElement getKMacro() {
    return findNotNullChildByType(K_MACRO);
  }

}
