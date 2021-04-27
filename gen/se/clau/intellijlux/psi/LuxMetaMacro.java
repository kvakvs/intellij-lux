// This is a generated file. Not intended for manual editing.
package se.clau.intellijlux.psi;

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
  List<LuxSend> getSendList();

  @NotNull
  List<LuxSendLn> getSendLnList();

  @NotNull
  List<LuxSetFailure> getSetFailureList();

  @NotNull
  List<LuxSetLoopBreak> getSetLoopBreakList();

  @NotNull
  List<LuxSetSuccess> getSetSuccessList();

}
