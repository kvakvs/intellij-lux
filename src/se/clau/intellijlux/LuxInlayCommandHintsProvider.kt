package se.clau.intellijlux

import com.intellij.codeInsight.hints.*
import com.intellij.codeInsight.hints.presentation.InlayPresentation
import com.intellij.openapi.components.service
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.DumbService
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.refactoring.suggested.endOffset
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

                return true
            }

            private fun presentSend(element: PsiElement) {
                when (element) {
                    is LuxSend -> {
                        val presentation = typeHintsFactory.textHint("send:")
                        sink.addInlineElement(
                            offset = element.endOffset + 1,
                            relatesToPrecedingText = false,
                            presentation = presentation,
                            placeAtTheEndOfLine = false
                        )
                    }
                    is LuxSendLn -> {
                        val presentation = typeHintsFactory.textHint("send ln:")
                        sink.addInlineElement(
                            offset = element.endOffset + 1,
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
                            typeHintsFactory.textHint("expect regex:")
                        sink.addInlineElement(
                            offset = element.endOffset + 2,
                            relatesToPrecedingText = false,
                            presentation = presentation,
                            placeAtTheEndOfLine = false
                        )
                    }
                    is LuxExpectMaybeRegex -> {
                        val presentation =
                            typeHintsFactory.textHint("expect maybe regex:")
                        sink.addInlineElement(
                            offset = element.endOffset + 2,
                            relatesToPrecedingText = false,
                            presentation = presentation,
                            placeAtTheEndOfLine = false
                        )
                    }
                    is LuxExpectTemplate -> {
                        val presentation =
                            typeHintsFactory.textHint("expect template:")
                        sink.addInlineElement(
                            offset = element.endOffset + 3,
                            relatesToPrecedingText = false,
                            presentation = presentation,
                            placeAtTheEndOfLine = false
                        )
                    }
                    is LuxExpectVerbatim -> {
                        val presentation =
                            typeHintsFactory.textHint("expect verbatim:")
                        sink.addInlineElement(
                            offset = element.endOffset + 3,
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
    )

    companion object {
        private val KEY: SettingsKey<Settings> =
            SettingsKey("lux.command.hints")
    }
}
