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

CRLF            = [\r\n]
BLANK           = [\ \t\f]
COMMENT         = "#"[^\r\n]*
T_META_CONTENTS = ~"]" {CRLF}
T_WORD          = [\w_][\w\d_]*
T_NUMBER        = [0-9]+
T_LINE_CONTENTS = [^\r\n]+ {CRLF}
T_QQQ           = "\"\"\""
T_MULTILINE_CONTENTS = ~{T_QQQ} {CRLF}

%state IN_DOC
%state IN_CONFIG
%state IN_CONFIG_VAL
%state IN_NEWSHELL
%state IN_SHELL
%state IN_INCLUDE
%state IN_LOOP
%state IN_MACRO

%state IN_INVOKE
%state IN_INVOKE_ARGS

//=== Generic states ===
// consumes one numeric argument
%state WAIT_NUM
// consumes everything until end of the meta, closing ] and CRLF
%state REMAINING_META
// consumes everything until end of the line, to CRLF
%state REMAINING_LINE
// consumes everything until """ including CRLF
%state REMAINING_MULTILINE

%%

<YYINITIAL> {COMMENT}          { return LuxTypes.COMMENT; }

<YYINITIAL> "!"                { yybegin(REMAINING_LINE); return LuxTypes.K_SEND; }
<YYINITIAL> {T_QQQ}"!"         { yybegin(REMAINING_MULTILINE); return LuxTypes.K_ML_SEND; }
<YYINITIAL> "~"                { yybegin(REMAINING_LINE); return LuxTypes.K_SEND_LN; }
<YYINITIAL> {T_QQQ}"~"         { yybegin(REMAINING_MULTILINE); return LuxTypes.K_ML_SEND_LN; }
<YYINITIAL> "???"              { yybegin(REMAINING_LINE); return LuxTypes.K_EXP_VERBATIM; }
<YYINITIAL> {T_QQQ}"???"       { yybegin(REMAINING_MULTILINE); return LuxTypes.K_ML_EXP_VERBATIM; }
<YYINITIAL> "??"               { yybegin(REMAINING_LINE); return LuxTypes.K_EXP_TEMPLATE; }
<YYINITIAL> {T_QQQ}"??"        { yybegin(REMAINING_MULTILINE); return LuxTypes.K_ML_EXP_TEMPLATE; }
<YYINITIAL> "?+"               { yybegin(REMAINING_LINE); return LuxTypes.K_EXP_MAYBE_REGEX; }
<YYINITIAL> {T_QQQ}"?+"        { yybegin(REMAINING_MULTILINE); return LuxTypes.K_ML_EXP_MAYBE_REGEX; }

<YYINITIAL> "?"{CRLF}          { return LuxTypes.K_FLUSH; }
<YYINITIAL> "?"                { yybegin(REMAINING_LINE); return LuxTypes.K_EXP_REGEX; }
<YYINITIAL> {T_QQQ}"?"         { yybegin(REMAINING_MULTILINE); return LuxTypes.K_ML_EXP_REGEX; }

<YYINITIAL> "+"{CRLF}          { return LuxTypes.K_SET_SUCCESS_ONLY; }
<YYINITIAL> "+"                { yybegin(REMAINING_LINE); return LuxTypes.K_SET_SUCCESS; }

<YYINITIAL> "-"{CRLF}          { return LuxTypes.K_SET_FAILURE_ONLY; }
<YYINITIAL> "-"                { yybegin(REMAINING_LINE); return LuxTypes.K_SET_FAILURE; }

<YYINITIAL> "@"{CRLF}          { return LuxTypes.K_SET_LOOP_BREAK_ONLY; }
<YYINITIAL> "@"                { yybegin(REMAINING_LINE); return LuxTypes.K_SET_LOOP_BREAK; }

<REMAINING_LINE> {T_LINE_CONTENTS} { yybegin(YYINITIAL); return LuxTypes.T_LINE_CONTENTS; }
<REMAINING_MULTILINE> {T_MULTILINE_CONTENTS} { yybegin(YYINITIAL); return LuxTypes.T_MULTILINE_CONTENTS; }

<YYINITIAL> "]"                { return LuxTypes.T_SQR_CLOSE; }

<YYINITIAL> "[cleanup]"{CRLF}  { return LuxTypes.K_CLEANUP; }

<YYINITIAL> "[endloop]"{CRLF}  { return LuxTypes.K_END_LOOP; }
<YYINITIAL> "[loop"{BLANK}     { yybegin(IN_LOOP); return LuxTypes.K_LOOP; }
<IN_LOOP> {T_META_CONTENTS}    { yybegin(YYINITIAL); return LuxTypes.T_META_CONTENTS; }

<YYINITIAL> "[endmacro]"{CRLF} { return LuxTypes.K_END_MACRO; }
<YYINITIAL> "[macro"{BLANK}    { yybegin(IN_MACRO); return LuxTypes.K_MACRO; }
<IN_MACRO> {T_META_CONTENTS}   { yybegin(YYINITIAL); return LuxTypes.T_META_CONTENTS; }

<YYINITIAL> "[invoke"{BLANK}   { yybegin(IN_INVOKE); return LuxTypes.K_INVOKE; }
<IN_INVOKE> {T_WORD}           { yybegin(IN_INVOKE_ARGS); return LuxTypes.T_WORD; }
<IN_INVOKE_ARGS> {T_META_CONTENTS}  { yybegin(YYINITIAL); return LuxTypes.T_META_CONTENTS; }

<YYINITIAL> "[doc]"{CRLF}      { return LuxTypes.K_DOC_ONLY; }
<YYINITIAL> "[enddoc]"{CRLF}   { return LuxTypes.K_END_DOC; }
<YYINITIAL> "[doc"{BLANK}      { yybegin(REMAINING_META); return LuxTypes.K_DOC; }
<REMAINING_META> {T_META_CONTENTS} { yybegin(YYINITIAL); return LuxTypes.T_META_CONTENTS; }

<YYINITIAL> "[config"{BLANK}   { yybegin(IN_CONFIG); return LuxTypes.K_CONFIG; }
<YYINITIAL> "[local"{BLANK}    { yybegin(IN_CONFIG); return LuxTypes.K_LOCAL; }
<YYINITIAL> "[global"{BLANK}   { yybegin(IN_CONFIG); return LuxTypes.K_GLOBAL; }
<YYINITIAL> "[my"{BLANK}       { yybegin(IN_CONFIG); return LuxTypes.K_MY; }
<IN_CONFIG> {T_WORD}           { return LuxTypes.T_WORD; }
<IN_CONFIG> "="                { yybegin(IN_CONFIG_VAL); return LuxTypes.T_EQUALS; }
<IN_CONFIG_VAL> {T_META_CONTENTS} { yybegin(YYINITIAL); return LuxTypes.T_META_CONTENTS; }

<YYINITIAL> "[newshell]"{CRLF} { return LuxTypes.K_NEWSHELL_ONLY; }
<YYINITIAL> "[newshell"{BLANK} { yybegin(IN_NEWSHELL); return LuxTypes.K_NEWSHELL; }
<IN_NEWSHELL> {T_META_CONTENTS} { yybegin(YYINITIAL); return LuxTypes.T_META_CONTENTS; }

<YYINITIAL> "[shell]"{CRLF}    { return LuxTypes.K_SHELL_ONLY; }
<YYINITIAL> "[shell"{BLANK}    { yybegin(IN_SHELL); return LuxTypes.K_SHELL; }
<IN_SHELL> {T_META_CONTENTS}   { yybegin(YYINITIAL); return LuxTypes.T_META_CONTENTS; }

<YYINITIAL> "[timeout]"{CRLF}  { return LuxTypes.K_TIMEOUT_ONLY; }
<YYINITIAL> "[timeout"{BLANK}  { yybegin(WAIT_NUM); return LuxTypes.K_TIMEOUT; }
<YYINITIAL> "[sleep"{BLANK}    { yybegin(WAIT_NUM); return LuxTypes.K_SLEEP; }
<WAIT_NUM> {T_NUMBER}    { yybegin(YYINITIAL); return LuxTypes.T_NUMBER; }

<YYINITIAL> "[include"{BLANK}  { yybegin(IN_INCLUDE); return LuxTypes.K_INCLUDE; }
<IN_INCLUDE> {T_META_CONTENTS} { yybegin(YYINITIAL); return LuxTypes.T_META_CONTENTS; }

<YYINITIAL> {BLANK}+           { return TokenType.WHITE_SPACE; }
<YYINITIAL> {CRLF}+            { return LuxTypes.CRLF; }
[^]                            { return TokenType.BAD_CHARACTER; }
