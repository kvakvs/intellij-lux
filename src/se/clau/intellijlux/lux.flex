package se.clau.intellijlux;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import se.clau.intellijlux.psi.LuxTokenType;import se.clau.intellijlux.psi.LuxTypes;
import com.intellij.psi.TokenType;

%%

%class LuxLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF            = [\r\n]
BLANK           = [\ \t\f]
COMMENT         = "#"[^\r\n]*
NOT_CLOSING_SQR = ([^\]\r\n] | {BLANK}) +
T_WORD          = [\w]+
T_NUMBER        = [0-9]+

//SEND="!"[^\r\n]+
//SENDLN="~"[^\r\n]+
//EXPECT_VERBATIM="???"[^\r\n]+
//EXPECT_TEMPLATE="??"[^\r\n]+
//EXPECT_MAYBEREGEXP="?+"[^\r\n]+
//EXPECT_REGEXP="?"[^+][^\r\n]+
//FLUSH="?"[\r\n]
//SET_FAILURE="-"[^\r\n]*
//SET_SUCCESS="+"[^\r\n]*
//SET_LOOPBREAK="@"[^\r\n]*

%state IN_DOC
%state IN_CONFIG
%state IN_CONFIG_VAL
%state IN_NEWSHELL
%state IN_SHELL
%state IN_TIMEOUT

%%

<YYINITIAL> {COMMENT}          { return LuxTypes.COMMENT; }
<YYINITIAL> "!"                { return LuxTypes.T_BANG; }
<YYINITIAL> "~"                { return LuxTypes.T_TILDE; }
<YYINITIAL> "???"              { return LuxTypes.T_TRIPLE_QUESTION; }
<YYINITIAL> "??"               { return LuxTypes.T_DOUBLE_QUESTION; }
<YYINITIAL> "?+"               { return LuxTypes.T_QUESTION_PLUS; }
<YYINITIAL> "?"                { return LuxTypes.T_QUESTION; }
<YYINITIAL> "-"                { return LuxTypes.T_MINUS; }
<YYINITIAL> "+"                { return LuxTypes.T_PLUS; }
<YYINITIAL> "@"                { return LuxTypes.T_AT; }

<YYINITIAL> "]"                { return LuxTypes.T_SQR_CLOSE; }

<YYINITIAL> "[doc]"            { return LuxTypes.K_DOC_ONLY; }
<YYINITIAL> "[doc"{BLANK}      { yybegin(IN_DOC); return LuxTypes.K_DOC; }
<IN_DOC> {NOT_CLOSING_SQR}     { yybegin(YYINITIAL); return LuxTypes.T_META_CONTENTS; }

<YYINITIAL> "[config"{BLANK}   { yybegin(IN_CONFIG); return LuxTypes.K_CONFIG; }
<IN_CONFIG> {T_WORD}           { return LuxTypes.T_WORD; }
<IN_CONFIG> "="                { yybegin(IN_CONFIG_VAL); return LuxTypes.T_EQUALS; }
<IN_CONFIG_VAL> {NOT_CLOSING_SQR} { yybegin(YYINITIAL); return LuxTypes.T_META_CONTENTS; }

<YYINITIAL> "[newshell]"       { return LuxTypes.K_NEWSHELL_ONLY; }
<YYINITIAL> "[newshell"{BLANK} { yybegin(IN_NEWSHELL); return LuxTypes.K_NEWSHELL; }
<IN_NEWSHELL> {NOT_CLOSING_SQR} { yybegin(YYINITIAL); return LuxTypes.T_META_CONTENTS; }

<YYINITIAL> "[shell]"          { return LuxTypes.K_SHELL_ONLY; }
<YYINITIAL> "[shell"{BLANK}    { yybegin(IN_SHELL); return LuxTypes.K_SHELL; }
<IN_SHELL> {NOT_CLOSING_SQR}   { yybegin(YYINITIAL); return LuxTypes.T_META_CONTENTS; }

<YYINITIAL> "[timeout]"        { return LuxTypes.K_TIMEOUT_ONLY; }
<YYINITIAL> "[timeout"{BLANK}  { yybegin(IN_TIMEOUT); return LuxTypes.K_TIMEOUT; }
<IN_TIMEOUT> {T_NUMBER}        { yybegin(YYINITIAL); return LuxTypes.T_NUMBER; }

<YYINITIAL> {BLANK}+           { return TokenType.WHITE_SPACE; }
<YYINITIAL> {CRLF}+            { return LuxTypes.CRLF; }
[^]                            { return TokenType.BAD_CHARACTER; }
