package se.clau.intellijlux

import com.intellij.codeInsight.hints.*
import com.intellij.openapi.components.service
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.DumbService
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.refactoring.suggested.startOffset
import se.clau.intellijlux.gen.psi.*
import javax.swing.JComponent
import javax.swing.JPanel

@Suppress("UnstableApiUsage")
class LuxInlayCommandHintsProvider :
  InlayHintsProvider<LuxInlayCommandHintsProvider.Settings> {
  override val key: SettingsKey<Settings> get() = KEY
  override val name: String get() = "Command hints"

  override val previewText: String
    get() = """
            !send this text
            ~send with new line
            ?expect a regex
            ?+expect maybe a regex
            ??expect a template
            ???expect a verbatim text
            -set failure
            -
            +set success
            +
            @loop break
            @
            """.trimIndent()

  override fun createConfigurable(settings: Settings): ImmediateConfigurable =
    object : ImmediateConfigurable {

      override val cases: List<ImmediateConfigurable.Case>
        get() = listOf(
          ImmediateConfigurable.Case(
            "Show for send commands",
            "send",
            settings::showForSend
          ),
          ImmediateConfigurable.Case(
            "Show for expect (receive) commands",
            "expect",
            settings::showForExpect
          ),
          ImmediateConfigurable.Case(
            "Show for triggers (success, failure, loop control)",
            "triggers",
            settings::showForTriggers
          ),
        )

      override fun createComponent(listener: ChangeListener): JComponent =
        JPanel()
    }

  override fun createSettings(): Settings = Settings()

  override fun getCollectorFor(
    file: PsiFile,
    editor: Editor,
    settings: Settings,
    sink: InlayHintsSink
  ): InlayHintsCollector =
    object : FactoryInlayHintsCollector(editor) {
      val typeHintsFactory = LuxTypeHintsPresentationFactory(factory)

      override fun collect(
        element: PsiElement,
        editor: Editor,
        sink: InlayHintsSink
      ): Boolean {
        if (file.project.service<DumbService>().isDumb) return true
        if ((element is LuxSend || element is LuxMlSend
              || element is LuxSendLn || element is LuxMlSendLn)
          && settings.showForSend
        ) {
          presentSend(element)
        }
        if ((element is LuxExpectRegex || element is LuxMlExpectRegex
              || element is LuxExpectMaybeRegex || element is LuxMlExpectMaybeRegex
              || element is LuxExpectTemplate || element is LuxMlExpectTemplate
              || element is LuxExpectVerbatim || element is LuxMlExpectVerbatim)
          && settings.showForExpect
        ) {
          presentExpect(element)
        }
        if ((element is LuxSetFailure || element is LuxMlSetFailure || element is LuxSetFailureOnly
              || element is LuxSetSuccess || element is LuxMlSetSuccess || element is LuxSetSuccessOnly
              || element is LuxSetLoopBreak || element is LuxMlSetLoopBreak || element is LuxSetLoopBreakOnly)
          && settings.showForTriggers
        ) {
          presentTrigger(element)
        }

        return true
      }

      private fun tHint(element: PsiElement, startOffset: Int, t: String) {
        val presentation = typeHintsFactory.textHint(t)
        sink.addInlineElement(
          offset = element.startOffset + startOffset,
          relatesToPrecedingText = false,
          presentation = presentation,
          placeAtTheEndOfLine = false
        )
      }

      private fun presentSend(element: PsiElement) {
        when (element) {
          is LuxSend -> tHint(element, 1, "send:")
          is LuxMlSend -> tHint(element, 1 + 3, "send:")
          is LuxSendLn -> tHint(element, 1, "sendln:")
          is LuxMlSendLn -> tHint(element, 1 + 3, "sendln:")
        }
      }

      private fun presentExpect(element: PsiElement) {
        when (element) {
          is LuxExpectRegex -> tHint(element, 1, "regex:")
          is LuxMlExpectRegex -> tHint(element, 1 + 3, "regex:")

          is LuxExpectMaybeRegex -> tHint(element, 2, "maybe regex:")
          is LuxMlExpectMaybeRegex -> tHint(element, 2 + 3, "maybe regex:")

          is LuxExpectTemplate -> tHint(element, 2, "template:")
          is LuxMlExpectTemplate -> tHint(element, 2 + 3, "template:")

          is LuxExpectVerbatim -> tHint(element, 3, "verbatim:")
          is LuxMlExpectVerbatim -> tHint(element, 3 + 3, "verbatim:")
        }
      }

      private fun presentTrigger(element: PsiElement) {
        when (element) {
          is LuxSetSuccess, is LuxSetSuccessOnly -> tHint(element, 1, "success:")
          is LuxMlSetSuccess -> tHint(element, 1 + 3, "success:")

          is LuxSetFailure, is LuxSetFailureOnly -> tHint(element, 1, "failure:")
          is LuxMlSetFailure -> tHint(element, 1 + 3, "failure:")

          is LuxSetLoopBreak, is LuxSetLoopBreakOnly -> tHint(element, 1, "loop break:")
          is LuxMlSetLoopBreak -> tHint(element, 1 + 3, "loop break:")
        }
      }
    }

  data class Settings(
    var showForSend: Boolean = true,
    var showForExpect: Boolean = true,
    var showForTriggers: Boolean = true,
  )

  companion object {
    private val KEY: SettingsKey<Settings> =
      SettingsKey("lux.command.hints")
  }
}
