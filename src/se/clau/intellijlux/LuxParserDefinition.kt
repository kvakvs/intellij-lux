package se.clau.intellijlux

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.ParserDefinition.SpaceRequirements
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import se.clau.intellijlux.parser.LuxParser
import se.clau.intellijlux.psi.LuxTypes

class LuxParserDefinition : ParserDefinition {
  override fun createLexer(project: Project): Lexer = LuxLexerAdapter()

  override fun getWhitespaceTokens(): TokenSet = WHITE_SPACES

  override fun getCommentTokens(): TokenSet = COMMENTS

  override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY

  override fun createParser(project: Project): PsiParser = LuxParser()

  override fun getFileNodeType(): IFileElementType = FILE

  override fun createFile(viewProvider: FileViewProvider): PsiFile {
    return LuxFile(viewProvider)
  }

  override fun spaceExistenceTypeBetweenTokens(
    left: ASTNode,
    right: ASTNode
  ): SpaceRequirements {
    return SpaceRequirements.MAY
  }

  override fun createElement(node: ASTNode): PsiElement {
    return LuxTypes.Factory.createElement(node)
  }

  companion object {
    val WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE)
    val COMMENTS = TokenSet.create(LuxTypes.COMMENT)
    val FILE = IFileElementType(LuxLanguage)
  }
}