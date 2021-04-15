package se.clau.intellijlux

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon

class LuxColorSettingsPage : ColorSettingsPage {
    override fun getIcon(): Icon? {
        return LuxIcons.FILE
    }

    override fun getHighlighter(): SyntaxHighlighter {
        return LuxSyntaxHighlighter()
    }

    override fun getDemoText(): String {
        return ")bad character\n" +
                "[doc Test of macros and variable scope]\n" +
                "[global fail_pattern=[Ee][Rr][Rr][Oo][Rr]]\n" +
                "[global eprompt=\\d+>\\s]\n" +
                "# Setup a shell dedicated for calculations\n" +
                "[shell calc]\n" +
                "    # Setup a (local) failure pattern\n" +
                "    -\$fail_pattern|SH-PROMPT:\n" +
                "    !erl\n" +
                "    \"\"\"?\n" +
                "    Eshell.*\n" +
                "    \$eprompt\n" +
                "    \"\"\"\n" +
                "[macro calc expr]\n" +
                "    [my myshell=\$LUX_SHELLNAME]\n" +
                "    [shell calc]\n" +
                "        !\n" +
                "        !\$expr.    [shell \$myshell]\n" +
                "    [progress \$expr=\$result]\n" +
                "[endmacro]"
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey>? {
        return null
    }

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return DESCRIPTORS
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> {
        return ColorDescriptor.EMPTY_ARRAY
    }

    override fun getDisplayName(): String {
        return "Lucid Expect (Lux)"
    }

    companion object {
        private val DESCRIPTORS = arrayOf(
                AttributesDescriptor("Comment",
                        LuxSyntaxHighlighter.COMMENT),
                AttributesDescriptor("Line content",
                        LuxSyntaxHighlighter.LINE_CONTENT),
                AttributesDescriptor("Bad character",
                        LuxSyntaxHighlighter.BAD_CHARACTER),
                AttributesDescriptor("Keyword",
                        LuxSyntaxHighlighter.KEYWORD),
                AttributesDescriptor("Meta",
                        LuxSyntaxHighlighter.META),
                AttributesDescriptor("Identifier",
                        LuxSyntaxHighlighter.IDENT))
    }
}