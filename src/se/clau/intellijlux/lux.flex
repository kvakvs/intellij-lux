package se.clau.intellijlux;

import com.intellij.psi.tree.IElementType;
import se.clau.intellijlux.psi.LuxTypes;
import com.intellij.psi.TokenType;
import com.intellij.lexer.FlexLexer;

%%

%class LuxLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

EndLine         = [\r\n]
BLANK           = [\ \t\f]
COMMENT         = "#"[^\r\n]*
SpecialIdent    = \$ "?"
T_IDENT         = [\w_\$] ([\w\d_\-] *)
T_NUMBER        = [0-9]+

MetaText            = [^\]\$\r\n]*

LinePasteExitcode   = \$\?
LineDollar          = \$\$
LinePasteCapture    = \$[\d+]
LinePasteVar        = \$ {T_IDENT}
LinePasteVarCurly   = \$\{ {T_IDENT} \}
LineText            = [^\r\n\$]*
LineTextNoBackslash = [^\r\n\$\\]*

TripleQuote = "\"\"\""

%state IN_DOC
%state IN_CONFIG
%state IN_CONFIG_VAL
%state IN_NEWSHELL
%state IN_SHELL
%state IN_INCLUDE
%state IN_LOOP
%state IN_MACRO

%state IN_INVOKE

//=== Generic states ===

// consumes one numeric argument
%state WAIT_NUM

// consumes everything until end of the meta, closing ] and CRLF
%state CONSUME_META

// consumes everything until end of the line, to CRLF
%state REMAINING_LINE

// consumes everything until """ including CRLF
%state REMAINING_MULTILINE

%%

<YYINITIAL> {
    {COMMENT}    { return LuxTypes.COMMENT; }

    "!"                { yybegin(REMAINING_LINE); return LuxTypes.K_SEND; }
    {TripleQuote}"!"   { yybegin(REMAINING_MULTILINE); return LuxTypes.K_ML_SEND; }
    "~"                { yybegin(REMAINING_LINE); return LuxTypes.K_SEND_LN; }
    {TripleQuote}"~"   { yybegin(REMAINING_MULTILINE); return LuxTypes.K_ML_SEND_LN; }
    "???"              { yybegin(REMAINING_LINE); return LuxTypes.K_EXP_VERBATIM; }
    {TripleQuote}"???" { yybegin(REMAINING_MULTILINE); return LuxTypes.K_ML_EXP_VERBATIM; }
    "??"               { yybegin(REMAINING_LINE); return LuxTypes.K_EXP_TEMPLATE; }
    {TripleQuote}"??"  { yybegin(REMAINING_MULTILINE); return LuxTypes.K_ML_EXP_TEMPLATE; }
    "?+"               { yybegin(REMAINING_LINE); return LuxTypes.K_EXP_MAYBE_REGEX; }
    {TripleQuote}"?+"  { yybegin(REMAINING_MULTILINE); return LuxTypes.K_ML_EXP_MAYBE_REGEX; }

    "?"{EndLine}          { return LuxTypes.K_FLUSH; }
    "?"                { yybegin(REMAINING_LINE); return LuxTypes.K_EXP_REGEX; }
    {TripleQuote}"?"   { yybegin(REMAINING_MULTILINE); return LuxTypes.K_ML_EXP_REGEX; }

    "+"{EndLine}   { return LuxTypes.K_SET_SUCCESS_ONLY; }
    "+"            { yybegin(REMAINING_LINE); return LuxTypes.K_SET_SUCCESS; }

    "-"{EndLine}   { return LuxTypes.K_SET_FAILURE_ONLY; }
    "-"            { yybegin(REMAINING_LINE); return LuxTypes.K_SET_FAILURE; }

    "@"{EndLine}   { return LuxTypes.K_SET_LOOP_BREAK_ONLY; }
    "@"            { yybegin(REMAINING_LINE); return LuxTypes.K_SET_LOOP_BREAK; }

    "]"                { return LuxTypes.T_SQR_CLOSE; }

    "[cleanup]"        { return LuxTypes.K_CLEANUP; }

    "[endloop]"        { return LuxTypes.K_END_LOOP; }
    "[loop"{BLANK}     { yybegin(IN_LOOP); return LuxTypes.K_LOOP; }

    "[endmacro]"       { return LuxTypes.K_END_MACRO; }
    "[macro"{BLANK}    { yybegin(IN_MACRO); return LuxTypes.K_MACRO; }

    "[invoke"{BLANK}   { yybegin(IN_INVOKE); return LuxTypes.K_INVOKE; }
    "[doc]"            { return LuxTypes.K_DOC_ONLY; }
    "[enddoc]"         { return LuxTypes.K_END_DOC; }
    "[doc"{BLANK}      { yybegin(CONSUME_META); return LuxTypes.K_DOC; }

    "[progress"{BLANK}      { yybegin(CONSUME_META); return LuxTypes.K_PROGRESS; }

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
    "[include"{BLANK}  { yybegin(CONSUME_META); return LuxTypes.K_INCLUDE; }

    {BLANK}+           { return TokenType.WHITE_SPACE; }
    {EndLine}+         { return LuxTypes.CRLF; }
}

<REMAINING_LINE> {
    "\\" {EndLine}      { return LuxTypes.LINE_CONTINUATION; }
    {LineTextNoBackslash} { return LuxTypes.TEXT; }
    {LineDollar}        { return LuxTypes.T_DOLLAR; }
    {LinePasteVar}      { return LuxTypes.T_PASTE_VARIABLE; }
    {LinePasteVarCurly} { return LuxTypes.T_PASTE_VARIABLE; }
    {LinePasteCapture}  { return LuxTypes.T_PASTE_CAPTURE; }
    {LinePasteExitcode} { return LuxTypes.T_PASTE_EXITCODE; }
    {EndLine}           { yybegin(YYINITIAL); return LuxTypes.CRLF; }
    "\\"                { return LuxTypes.TEXT; }
    // <<EOF>>           { return TokenType.BAD_CHARACTER; }
}

<REMAINING_MULTILINE> {
    {TripleQuote}     { yybegin(YYINITIAL); return LuxTypes.END_MULTILINE; }
    {LineText}        { return LuxTypes.TEXT; }
    {LineDollar}      { return LuxTypes.T_DOLLAR; }
    {LinePasteVar}    { return LuxTypes.T_PASTE_VARIABLE; }
    {LinePasteVarCurly} { return LuxTypes.T_PASTE_VARIABLE; }
    {LinePasteCapture}  { return LuxTypes.T_PASTE_CAPTURE; }
    {LinePasteExitcode} { return LuxTypes.T_PASTE_EXITCODE; }
    {EndLine}           { return LuxTypes.CRLF; }
    // <<EOF>>           { return TokenType.BAD_CHARACTER; }
}

<IN_LOOP> {
    {T_IDENT}           { yybegin(CONSUME_META); return LuxTypes.T_IDENT; }
}

<IN_MACRO> {
    {T_IDENT}           { yybegin(CONSUME_META); return LuxTypes.T_IDENT; }
}

<IN_INVOKE> {
    {T_IDENT}           { yybegin(CONSUME_META); return LuxTypes.T_IDENT; }
}

// Scan the rest of the line until ]\n
<CONSUME_META> {
    "]" {EndLine}       { yybegin(YYINITIAL); return LuxTypes.END_META; }
    {MetaText}          { return LuxTypes.TEXT; }
    {LineDollar}        { return LuxTypes.T_DOLLAR; }
    {LinePasteVar}      { return LuxTypes.T_PASTE_VARIABLE; }
    {LinePasteVarCurly} { return LuxTypes.T_PASTE_VARIABLE; }
    {LinePasteCapture}  { return LuxTypes.T_PASTE_CAPTURE; }
    "]"                 { return LuxTypes.TEXT; }
}

<IN_CONFIG> {
    {T_IDENT} { return LuxTypes.T_IDENT; }
    "="       { yybegin(CONSUME_META); return LuxTypes.T_EQUALS; }
}

<IN_NEWSHELL> {
    {T_IDENT} { yybegin(CONSUME_META); return LuxTypes.T_IDENT; }
}

<IN_SHELL> {
    {T_IDENT} { yybegin(CONSUME_META); return LuxTypes.T_IDENT; }
}

<WAIT_NUM> {
    {T_NUMBER}    { yybegin(YYINITIAL); return LuxTypes.T_NUMBER; }
}

[^]     { return TokenType.BAD_CHARACTER; }
