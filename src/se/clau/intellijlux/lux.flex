package se.clau.intellijlux;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import se.clau.intellijlux.psi.LuxTypes;
import com.intellij.psi.TokenType;

%%

%class LuxLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF=\R
WHITE_SPACE=[\ \n\t\f]
FIRST_VALUE_CHARACTER=[^ \n\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER=[^\n\f\\] | "\\"{CRLF} | "\\".
END_OF_LINE_COMMENT="#"[^\r\n]*
// SEPARATOR=[:=]
// KEY_CHARACTER=[^:=\ \n\t\f\\] | "\\ "

SEND="!"[^\r\n]+
SENDLN="~"[^\r\n]+
EXPECT_VERBATIM="???"[^\r\n]+
EXPECT_TEMPLATE="??"[^\r\n]+
EXPECT_MAYBEREGEXP="?+"[^\r\n]+
EXPECT_REGEXP="?"[^\r\n]+
FLUSH="?"[\r\n]
SET_FAILURE="-"[^\r\n]*
SET_SUCCESS="-"[^\r\n]*
SET_LOOPBREAK="@"[^\r\n]*
META="["[\w]+.*"]"[\r\n]

//%state IN_META

%%

<YYINITIAL> {END_OF_LINE_COMMENT}  { yybegin(YYINITIAL); return LuxTypes.COMMENT; }
<YYINITIAL> {SEND}                 { yybegin(YYINITIAL); return LuxTypes.SEND; }
<YYINITIAL> {SENDLN}               { yybegin(YYINITIAL); return LuxTypes.SENDLN; }
<YYINITIAL> {EXPECT_VERBATIM}      { yybegin(YYINITIAL); return LuxTypes.EXPECT_VERBATIM; }
<YYINITIAL> {EXPECT_TEMPLATE}      { yybegin(YYINITIAL); return LuxTypes.EXPECT_TEMPLATE; }
<YYINITIAL> {EXPECT_REGEXP}        { yybegin(YYINITIAL); return LuxTypes.EXPECT_REGEXP; }
<YYINITIAL> {EXPECT_MAYBEREGEXP}   { yybegin(YYINITIAL); return LuxTypes.EXPECT_MAYBEREGEXP; }
<YYINITIAL> {FLUSH}                { yybegin(YYINITIAL); return LuxTypes.FLUSH; }
<YYINITIAL> {SET_FAILURE}          { yybegin(YYINITIAL); return LuxTypes.SET_FAILURE; }
<YYINITIAL> {SET_SUCCESS}          { yybegin(YYINITIAL); return LuxTypes.SET_SUCCESS; }
<YYINITIAL> {SET_LOOPBREAK}        { yybegin(YYINITIAL); return LuxTypes.SET_LOOPBREAK; }

// <YYINITIAL> {KEY_CHARACTER}+    { yybegin(YYINITIAL); return LuxTypes.KEY; }
// <YYINITIAL> {SEPARATOR}         { yybegin(WAITING_VALUE); return LuxTypes.SEPARATOR; }

//<IN_META> {CRLF}({CRLF}|{WHITE_SPACE})+               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
//<IN_META> {WHITE_SPACE}+                              { yybegin(IN_META); return TokenType.WHITE_SPACE; }
// <IN_META> {FIRST_VALUE_CHARACTER}{VALUE_CHARACTER}*   { yybegin(YYINITIAL); return LuxTypes.VALUE; }

({CRLF}|{WHITE_SPACE})+            { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
[^]                                { return TokenType.BAD_CHARACTER; }
