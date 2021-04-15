package se.clau.intellijlux;

import com.intellij.lang.*;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.tree.*;
import se.clau.intellijlux.parser.LuxParser;
import se.clau.intellijlux.psi.*;
import org.jetbrains.annotations.NotNull;

public class LuxParserDefinition implements ParserDefinition {
  public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
  public static final TokenSet COMMENTS = TokenSet.create(LuxTypes.COMMENT);

  public static final IFileElementType FILE = new IFileElementType(LuxLanguage.INSTANCE);

  @NotNull
  @Override
  public Lexer createLexer(Project project) {
    return new LuxLexerAdapter();
  }

  @NotNull
  public TokenSet getWhitespaceTokens() {
    return WHITE_SPACES;
  }

  @NotNull
  public TokenSet getCommentTokens() {
    return COMMENTS;
  }

  @NotNull
  public TokenSet getStringLiteralElements() {
    return TokenSet.EMPTY;
  }

  @NotNull
  public PsiParser createParser(final Project project) {
    return new LuxParser();
  }

  @Override
  public IFileElementType getFileNodeType() {
    return FILE;
  }

  public PsiFile createFile(FileViewProvider viewProvider) {
    return new LuxFile(viewProvider);
  }

  public SpaceRequirements spaceExistenceTypeBetweenTokens(ASTNode left, ASTNode right) {
    return SpaceRequirements.MAY;
  }

  @NotNull
  public PsiElement createElement(ASTNode node) {
    return LuxTypes.Factory.createElement(node);
  }
}