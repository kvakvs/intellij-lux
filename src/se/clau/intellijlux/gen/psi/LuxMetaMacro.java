// This is a generated file. Not intended for manual editing.
package se.clau.intellijlux.gen.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LuxMetaMacro extends PsiElement {

  @NotNull
  List<LuxExpectMaybeRegex> getExpectMaybeRegexList();

  @NotNull
  List<LuxExpectRegex> getExpectRegexList();

  @NotNull
  List<LuxExpectTemplate> getExpectTemplateList();

  @NotNull
  List<LuxExpectVerbatim> getExpectVerbatimList();

  @NotNull
  List<LuxFlush> getFlushList();

  @NotNull
  LuxIdent getIdent();

  @NotNull
  List<LuxMetaConfig> getMetaConfigList();

  @NotNull
  List<LuxMetaDoc> getMetaDocList();

  @NotNull
  List<LuxMetaGlobal> getMetaGlobalList();

  @NotNull
  List<LuxMetaInclude> getMetaIncludeList();

  @NotNull
  List<LuxMetaInvoke> getMetaInvokeList();

  @NotNull
  List<LuxMetaLocal> getMetaLocalList();

  @NotNull
  List<LuxMetaLoop> getMetaLoopList();

  @NotNull
  List<LuxMetaMy> getMetaMyList();

  @NotNull
  List<LuxMetaNewshell> getMetaNewshellList();

  @NotNull
  List<LuxMetaProgress> getMetaProgressList();

  @NotNull
  List<LuxMetaShell> getMetaShellList();

  @NotNull
  List<LuxMetaSleep> getMetaSleepList();

  @NotNull
  List<LuxMetaTimeout> getMetaTimeoutList();

  @NotNull
  List<LuxMlExpectMaybeRegex> getMlExpectMaybeRegexList();

  @NotNull
  List<LuxMlExpectRegex> getMlExpectRegexList();

  @NotNull
  List<LuxMlExpectTemplate> getMlExpectTemplateList();

  @NotNull
  List<LuxMlExpectVerbatim> getMlExpectVerbatimList();

  @NotNull
  List<LuxMlSend> getMlSendList();

  @NotNull
  List<LuxMlSendLn> getMlSendLnList();

  @NotNull
  List<LuxMlSetFailure> getMlSetFailureList();

  @NotNull
  List<LuxMlSetLoopBreak> getMlSetLoopBreakList();

  @NotNull
  List<LuxMlSetSuccess> getMlSetSuccessList();

  @NotNull
  List<LuxSend> getSendList();

  @NotNull
  List<LuxSendLn> getSendLnList();

  @NotNull
  List<LuxSetFailure> getSetFailureList();

  @NotNull
  List<LuxSetFailureOnly> getSetFailureOnlyList();

  @NotNull
  List<LuxSetLoopBreak> getSetLoopBreakList();

  @NotNull
  List<LuxSetLoopBreakOnly> getSetLoopBreakOnlyList();

  @NotNull
  List<LuxSetSuccess> getSetSuccessList();

  @NotNull
  List<LuxSetSuccessOnly> getSetSuccessOnlyList();

  @NotNull
  PsiElement getEndMeta();

  @NotNull
  PsiElement getKEndMacro();

  @NotNull
  PsiElement getKMacro();

}
