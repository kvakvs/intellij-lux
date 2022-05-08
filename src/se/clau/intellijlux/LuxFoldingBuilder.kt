package se.clau.intellijlux

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.psi.PsiElement
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.tree.TokenSet
import se.clau.intellijlux.gen.psi.LuxMetaMacro
import se.clau.intellijlux.gen.psi.LuxTypes
import java.util.ArrayList

class LuxFoldingBuilder : FoldingBuilderEx(), DumbAware {
    override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean): Array<FoldingDescriptor> {
        // Initialize the list of folding regions
        val descriptors: MutableList<FoldingDescriptor> = ArrayList()

        // Get a collection of the literal expressions in the document below root
        val containerNodes = PsiTreeUtil.findChildrenOfAnyType(
            root,
            LuxMetaMacro::class.java,
        )
        for (foldNode in containerNodes) {
            descriptors.add(FoldingDescriptor(foldNode.node, foldNode.textRange, null))
        }

        return descriptors.toTypedArray()
    }

    /**
     * Gets the Simple Language 'value' string corresponding to the 'key'
     *
     * @param node Node corresponding to PsiLiteralExpression containing a string in the format
     * SIMPLE_PREFIX_STR + SIMPLE_SEPARATOR_STR + Key, where Key is
     * defined by the Simple language file.
     */
    override fun getPlaceholderText(node: ASTNode): String {
        val foldStrNodes = node.getChildren(TokenSet.create(LuxTypes.IDENT))
        val foldType = when (node.psi) {
            is LuxMetaMacro -> "macro"
            else -> "..."
        }
        return if (foldStrNodes.isNotEmpty()) {
            foldType + " " + foldStrNodes[0].text
        } else {
            foldType
        }
    }

    override fun isCollapsedByDefault(node: ASTNode): Boolean {
        return true
    }
}