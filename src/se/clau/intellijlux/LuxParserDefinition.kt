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
import se.clau.intellijlux.gen.parser.LuxParser
import se.clau.intellijlux.gen.psi.LuxTypes

class LuxParserDefinition : ParserDefinition {
  override fun createLexer(project: Project): Lexer = LuxLexerAdapter()
  override fun getWhitespaceTokens(): TokenSet = TokenSet.create(TokenType.WHITE_SPACE)
  override fun getCommentTokens(): TokenSet = TokenSet.create(LuxTypes.COMMENT)
  override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY
  override fun createParser(project: Project): PsiParser = LuxParser()

  companion object {
    val FILE = IFileElementType(LuxLanguage)
  }

  override fun getFileNodeType(): IFileElementType = FILE

  override fun createFile(viewProvider: FileViewProvider): PsiFile = LuxFile(viewProvider)
  override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): SpaceRequirements =
    SpaceRequirements.MAY

  override fun createElement(node: ASTNode): PsiElement = LuxTypes.Factory.createElement(node)
}
