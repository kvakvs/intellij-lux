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
T_META_CONTENTS = ~("]" {CRLF})
T_IDENT          = [\w_\$][\w\d_\-]*
T_NUMBER        = [0-9]+
T_LINE_CONTENTS = [^\r\n]* {CRLF}
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

<YYINITIAL> {
    {COMMENT}    { return LuxTypes.COMMENT; }
    "!"          { yybegin(REMAINING_LINE); return LuxTypes.K_SEND; }
    {T_QQQ}"!"   { yybegin(REMAINING_MULTILINE); return LuxTypes.K_ML_SEND; }
    "~"          { yybegin(REMAINING_LINE); return LuxTypes.K_SEND_LN; }
    {T_QQQ}"~"   { yybegin(REMAINING_MULTILINE); return LuxTypes.K_ML_SEND_LN; }
    "???"        { yybegin(REMAINING_LINE); return LuxTypes.K_EXP_VERBATIM; }
    {T_QQQ}"???" { yybegin(REMAINING_MULTILINE); return LuxTypes.K_ML_EXP_VERBATIM; }
    "??"         { yybegin(REMAINING_LINE); return LuxTypes.K_EXP_TEMPLATE; }
    {T_QQQ}"??"  { yybegin(REMAINING_MULTILINE); return LuxTypes.K_ML_EXP_TEMPLATE; }
    "?+"         { yybegin(REMAINING_LINE); return LuxTypes.K_EXP_MAYBE_REGEX; }
    {T_QQQ}"?+"  { yybegin(REMAINING_MULTILINE); return LuxTypes.K_ML_EXP_MAYBE_REGEX; }

    "?"{CRLF}    { return LuxTypes.K_FLUSH; }
    "?"          { yybegin(REMAINING_LINE); return LuxTypes.K_EXP_REGEX; }
    {T_QQQ}"?"   { yybegin(REMAINING_MULTILINE); return LuxTypes.K_ML_EXP_REGEX; }

    "+"{CRLF}    { return LuxTypes.K_SET_SUCCESS_ONLY; }
    "+"          { yybegin(REMAINING_LINE); return LuxTypes.K_SET_SUCCESS; }

    "-"{CRLF}    { return LuxTypes.K_SET_FAILURE_ONLY; }
    "-"          { yybegin(REMAINING_LINE); return LuxTypes.K_SET_FAILURE; }

    "@"{CRLF}    { return LuxTypes.K_SET_LOOP_BREAK_ONLY; }
    "@"          { yybegin(REMAINING_LINE); return LuxTypes.K_SET_LOOP_BREAK; }

    "]"                { return LuxTypes.T_SQR_CLOSE; }

    "[cleanup]"        { return LuxTypes.K_CLEANUP; }

    "[endloop]"        { return LuxTypes.K_END_LOOP; }
    "[loop"{BLANK}     { yybegin(IN_LOOP); return LuxTypes.K_LOOP; }

    "[endmacro]"       { return LuxTypes.K_END_MACRO; }
    "[macro"{BLANK}    { yybegin(IN_MACRO); return LuxTypes.K_MACRO; }

    "[invoke"{BLANK}   { yybegin(IN_INVOKE); return LuxTypes.K_INVOKE; }
    "[doc]"            { return LuxTypes.K_DOC_ONLY; }
    "[enddoc]"         { return LuxTypes.K_END_DOC; }
    "[doc"{BLANK}      { yybegin(REMAINING_META); return LuxTypes.K_DOC; }

    "[progress"{BLANK}      { yybegin(REMAINING_META); return LuxTypes.K_PROGRESS; }

    "[config"{BLANK}   { yybegin(IN_CONFIG); return LuxTypes.K_CONFIG; }
    "[local"{BLANK}    { yybegin(IN_CONFIG); return LuxTypes.K_LOCAL; }
    "[global"{BLANK}   { yybegin(IN_CONFIG); return LuxTypes.K_GLOBAL; }
    "[my"{BLANK}       { yybegin(IN_CONFIG); return LuxTypes.K_MY; }

    "[newshell]"       { return LuxTypes.K_NEWSHELL_ONLY; }
    "[newshell"{BLANK} { yybegin(IN_NEWSHELL); return LuxTypes.K_NEWSHELL; }
    "[shell]"          { return LuxTypes.K_SHELL_ONLY; }
    "[shell"{BLANK}    { yybegin(IN_SHELL); return LuxTypes.K_SHELL; }
    "[timeout]"        { return LuxTypes.K_TIMEOUT_ONLY; }
    "[timeout"{BLANK}  { yybegin(WAIT_NUM); return LuxTypes.K_TIMEOUT; }
    "[sleep"{BLANK}    { yybegin(WAIT_NUM); return LuxTypes.K_SLEEP; }
    "[include"{BLANK}  { yybegin(IN_INCLUDE); return LuxTypes.K_INCLUDE; }

    {BLANK}+           { return TokenType.WHITE_SPACE; }
    {CRLF}+            { return LuxTypes.CRLF; }
}

<REMAINING_LINE> {
    {T_LINE_CONTENTS} { yybegin(YYINITIAL); return LuxTypes.T_LINE_CONTENTS; }
    // <<EOF>>           { return TokenType.BAD_CHARACTER; }
}

<REMAINING_MULTILINE> {
    {T_MULTILINE_CONTENTS} { yybegin(YYINITIAL); return LuxTypes.T_MULTILINE_CONTENTS; }
    // <<EOF>>           { return TokenType.BAD_CHARACTER; }
}

<IN_LOOP> {
    {T_META_CONTENTS}    { yybegin(YYINITIAL); return LuxTypes.T_META_CONTENTS; }
//    <<EOF>>           { return TokenType.BAD_CHARACTER; }
}

<IN_MACRO> {
    {T_META_CONTENTS}   { yybegin(YYINITIAL); return LuxTypes.T_META_CONTENTS; }
//    <<EOF>>           { return TokenType.BAD_CHARACTER; }
}

<IN_INVOKE> {T_IDENT}           { yybegin(IN_INVOKE_ARGS); return LuxTypes.T_IDENT; }

<IN_INVOKE_ARGS> {
    {T_META_CONTENTS}  { yybegin(YYINITIAL); return LuxTypes.T_META_CONTENTS; }
//    <<EOF>>           { return TokenType.BAD_CHARACTER; }
}

// Scan the rest of the line until ]\n
<REMAINING_META> {
    {T_META_CONTENTS} { yybegin(YYINITIAL); return LuxTypes.T_META_CONTENTS; }
//    <<EOF>>           { return TokenType.BAD_CHARACTER; }
}

<IN_CONFIG> {
    {T_IDENT} { return LuxTypes.T_IDENT; }
    "="       { yybegin(IN_CONFIG_VAL); return LuxTypes.T_EQUALS; }
}

// Scan the remaining value after ident= <...> until ]\n
<IN_CONFIG_VAL> {
    {T_META_CONTENTS} { yybegin(YYINITIAL); return LuxTypes.T_META_CONTENTS; }
//    <<EOF>> { return TokenType.BAD_CHARACTER; }
}

<IN_NEWSHELL> {T_META_CONTENTS} { yybegin(YYINITIAL); return LuxTypes.T_META_CONTENTS; }

<IN_SHELL> {T_META_CONTENTS}   { yybegin(YYINITIAL); return LuxTypes.T_META_CONTENTS; }

<WAIT_NUM> {T_NUMBER}    { yybegin(YYINITIAL); return LuxTypes.T_NUMBER; }

<IN_INCLUDE> {T_META_CONTENTS} { yybegin(YYINITIAL); return LuxTypes.T_META_CONTENTS; }

[^]                            { return TokenType.BAD_CHARACTER; }
