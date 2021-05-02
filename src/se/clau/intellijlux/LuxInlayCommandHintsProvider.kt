package se.clau.intellijlux

import com.intellij.codeInsight.hints.*
import com.intellij.codeInsight.hints.presentation.InlayPresentation
import com.intellij.openapi.components.service
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.DumbService
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.refactoring.suggested.endOffset
import com.intellij.refactoring.suggested.startOffset
import se.clau.intellijlux.psi.*
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
        if ((element is LuxSend
              || element is LuxSendLn)
          && settings.showForSend
        ) {
          presentSend(element)
        }
        if ((element is LuxExpectRegex
              || element is LuxExpectMaybeRegex
              || element is LuxExpectTemplate
              || element is LuxExpectVerbatim)
          && settings.showForExpect
        ) {
          presentExpect(element)
        }
        if ((element is LuxSetFailure
              || element is LuxSetSuccess
              || element is LuxSetLoopBreak)
          && settings.showForTriggers
        ) {
          presentTrigger(element)
        }

        return true
      }

      private fun presentSend(element: PsiElement) {
        when (element) {
          is LuxSend -> {
            val presentation = typeHintsFactory.textHint("send:")
            sink.addInlineElement(
              offset = element.startOffset + 1,
              relatesToPrecedingText = false,
              presentation = presentation,
              placeAtTheEndOfLine = false
            )
          }
          is LuxSendLn -> {
            val presentation = typeHintsFactory.textHint("sendln:")
            sink.addInlineElement(
              offset = element.startOffset + 1,
              relatesToPrecedingText = false,
              presentation = presentation,
              placeAtTheEndOfLine = false
            )
          }
        }
      }

      private fun presentExpect(element: PsiElement) {
        when (element) {
          is LuxExpectRegex -> {
            val presentation =
              typeHintsFactory.textHint("regex:")
            sink.addInlineElement(
              offset = element.startOffset + 1,
              relatesToPrecedingText = false,
              presentation = presentation,
              placeAtTheEndOfLine = false
            )
          }
          is LuxExpectMaybeRegex -> {
            val presentation =
              typeHintsFactory.textHint("maybe regex:")
            sink.addInlineElement(
              offset = element.startOffset + 2,
              relatesToPrecedingText = false,
              presentation = presentation,
              placeAtTheEndOfLine = false
            )
          }
          is LuxExpectTemplate -> {
            val presentation =
              typeHintsFactory.textHint("template:")
            sink.addInlineElement(
              offset = element.startOffset + 2,
              relatesToPrecedingText = false,
              presentation = presentation,
              placeAtTheEndOfLine = false
            )
          }
          is LuxExpectVerbatim -> {
            val presentation =
              typeHintsFactory.textHint("verbatim:")
            sink.addInlineElement(
              offset = element.startOffset + 3,
              relatesToPrecedingText = false,
              presentation = presentation,
              placeAtTheEndOfLine = false
            )
          }
        }
      }

      private fun presentTrigger(element: PsiElement) {
        when (element) {
          is LuxSetSuccess -> {
            val presentation =
              typeHintsFactory.textHint("success:")
            sink.addInlineElement(
              offset = element.startOffset + 1,
              relatesToPrecedingText = false,
              presentation = presentation,
              placeAtTheEndOfLine = false
            )
          }
          is LuxSetFailure -> {
            val presentation =
              typeHintsFactory.textHint("failure:")
            sink.addInlineElement(
              offset = element.startOffset + 1,
              relatesToPrecedingText = false,
              presentation = presentation,
              placeAtTheEndOfLine = false
            )
          }
          is LuxSetLoopBreak -> {
            val presentation =
              typeHintsFactory.textHint("loop break:")
            sink.addInlineElement(
              offset = element.startOffset + 1,
              relatesToPrecedingText = false,
              presentation = presentation,
              placeAtTheEndOfLine = false
            )
          }
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
