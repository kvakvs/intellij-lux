package se.clau.intellijlux.gen.lexer;

import com.intellij.psi.tree.IElementType;
import se.clau.intellijlux.gen.psi.LuxTypes;
import com.intellij.psi.TokenType;
import com.intellij.lexer.FlexLexer;

%%

%class _LuxLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}
%public

NewLine         = [\r\n]
Whitespace      = [\s\t\f]
SpecialIdent    = \$ "?"
T_IDENT         = [\w_\$] ([\w\d_\-] *)
T_NUMBER        = [0-9]+

MetaText            = [^\]\$\r\n]+

LinePasteExitcode   = \$\?
LineDollar          = \$\$
LinePasteCapture    = \$[\d+]
LinePasteVar        = \$ {T_IDENT}
LinePasteVarCurly   = \$\{ {T_IDENT} \}
LineText                = [^\r\n\$]+
LineTextNoBackslash     = [^\r\n\$\\]+

TripleQuote             = "\"\"\""
AnyWhitespace           = {Whitespace} *
AnyWhitespaceTripleQ    = {AnyWhitespace} {TripleQuote}
LineTextUntilTripleQ    = {LineText} {TripleQuote}

T_ENDDOC = "[enddoc]"
T_DOC_TEXT = [^$\[] +

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

// marks insides of a string """ and lasts until """ including CRLF
%state IN_TRIPLE_QUOTE
%state IN_DOC

%%

<YYINITIAL> {
    {Whitespace}     { return TokenType.WHITE_SPACE; }
    "#" .*           { return LuxTypes.COMMENT; }

    "!"                 { yybegin(REMAINING_LINE); return LuxTypes.K_SEND; }
    {TripleQuote}"!"    { yybegin(IN_TRIPLE_QUOTE); return LuxTypes.K_ML_SEND; }
    "~"                 { yybegin(REMAINING_LINE); return LuxTypes.K_SEND_LN; }
    {TripleQuote}"~"    { yybegin(IN_TRIPLE_QUOTE); return LuxTypes.K_ML_SEND_LN; }
    "???"               { yybegin(REMAINING_LINE); return LuxTypes.K_EXP_VERBATIM; }
    {TripleQuote}"???"  { yybegin(IN_TRIPLE_QUOTE); return LuxTypes.K_ML_EXP_VERBATIM; }
    "??"                { yybegin(REMAINING_LINE); return LuxTypes.K_EXP_TEMPLATE; }
    {TripleQuote}"??"   { yybegin(IN_TRIPLE_QUOTE); return LuxTypes.K_ML_EXP_TEMPLATE; }
    "?+"                { yybegin(REMAINING_LINE); return LuxTypes.K_EXP_MAYBE_REGEX; }
    {TripleQuote}"?+"   { yybegin(IN_TRIPLE_QUOTE); return LuxTypes.K_ML_EXP_MAYBE_REGEX; }

    "?"{NewLine}        { return LuxTypes.K_FLUSH; }
    "?"                 { yybegin(REMAINING_LINE); return LuxTypes.K_EXP_REGEX; }
    {TripleQuote}"?"    { yybegin(IN_TRIPLE_QUOTE); return LuxTypes.K_ML_EXP_REGEX; }

    "+"{NewLine}        { return LuxTypes.K_SET_SUCCESS_ONLY; }
    "+"                 { yybegin(REMAINING_LINE); return LuxTypes.K_SET_SUCCESS; }

    "-"{NewLine}        { return LuxTypes.K_SET_FAILURE_ONLY; }
    "-"                 { yybegin(REMAINING_LINE); return LuxTypes.K_SET_FAILURE; }

    // Longest to shortest
    {TripleQuote}"@"    { yybegin(IN_TRIPLE_QUOTE); return LuxTypes.K_ML_SET_LOOP_BREAK; }
    "@"{NewLine}        { return LuxTypes.K_SET_LOOP_BREAK_ONLY; }
    "@"                 { yybegin(REMAINING_LINE); return LuxTypes.K_SET_LOOP_BREAK; }

    "]"                { return LuxTypes.T_SQR_CLOSE; }

    "[cleanup]"        { return LuxTypes.K_CLEANUP; }

    "[endloop]"        { return LuxTypes.K_END_LOOP; }
    "[loop"{Whitespace}     { yybegin(IN_LOOP); return LuxTypes.K_LOOP; }

    "[endmacro]"       { return LuxTypes.K_END_MACRO; }
    "[macro"{Whitespace}    { yybegin(IN_MACRO); return LuxTypes.K_MACRO; }

    "[invoke"{Whitespace}   { yybegin(IN_INVOKE); return LuxTypes.K_INVOKE; }
    "[doc]"            { yybegin(IN_DOC); return LuxTypes.K_DOC_ONLY; }
    "[doc"{Whitespace}      { yybegin(CONSUME_META); return LuxTypes.K_DOC; }

    "[progress"{Whitespace} { yybegin(CONSUME_META); return LuxTypes.K_PROGRESS; }

    "[config"{Whitespace}   { yybegin(IN_CONFIG); return LuxTypes.K_CONFIG; }
    "[local"{Whitespace}    { yybegin(IN_CONFIG); return LuxTypes.K_LOCAL; }
    "[global"{Whitespace}   { yybegin(IN_CONFIG); return LuxTypes.K_GLOBAL; }
    "[my"{Whitespace}       { yybegin(IN_CONFIG); return LuxTypes.K_MY; }

    "[newshell]"       { return LuxTypes.K_NEWSHELL_ONLY; }
    "[newshell"{Whitespace} { yybegin(IN_NEWSHELL); return LuxTypes.K_NEWSHELL; }
    "[shell]"          { return LuxTypes.K_SHELL_ONLY; }
    "[shell"{Whitespace}    { yybegin(IN_SHELL); return LuxTypes.K_SHELL; }
    "[timeout]"        { return LuxTypes.K_TIMEOUT_ONLY; }
    "[timeout"{Whitespace}  { yybegin(WAIT_NUM); return LuxTypes.K_TIMEOUT; }
    "[sleep"{Whitespace}    { yybegin(WAIT_NUM); return LuxTypes.K_SLEEP; }
    "[include"{Whitespace}  { yybegin(CONSUME_META); return LuxTypes.K_INCLUDE; }
}

<REMAINING_LINE> {
    {NewLine}             { yybegin(YYINITIAL); }
    "\\" {NewLine}        { return LuxTypes.LINE_CONTINUATION; }
    {Whitespace}          { return LuxTypes.TEXT; }
    {LineTextNoBackslash} { return LuxTypes.TEXT; }
    {LineDollar}          { return LuxTypes.T_DOLLAR; }
    {LinePasteVar}        { return LuxTypes.T_PASTE_VARIABLE; }
    {LinePasteVarCurly}   { return LuxTypes.T_PASTE_VARIABLE; }
    {LinePasteCapture}    { return LuxTypes.T_PASTE_CAPTURE; }
    {LinePasteExitcode}   { return LuxTypes.T_PASTE_EXITCODE; }
    "\\"                  { return LuxTypes.TEXT; }
    "$"                   { return LuxTypes.TEXT; }
    // <<EOF>>           { return TokenType.BAD_CHARACTER; }
}

<IN_TRIPLE_QUOTE> {
    {AnyWhitespaceTripleQ}  { yybegin(YYINITIAL); return LuxTypes.T_TRIPLE_QUOTE; }
    {LineTextUntilTripleQ}  { yybegin(YYINITIAL); return LuxTypes.TEXT; }
    {LineText}              { return LuxTypes.TEXT; }
    {LineDollar}            { return LuxTypes.T_DOLLAR; }
    {LinePasteVar}          { return LuxTypes.T_PASTE_VARIABLE; }
    {LinePasteVarCurly}     { return LuxTypes.T_PASTE_VARIABLE; }
    {LinePasteCapture}      { return LuxTypes.T_PASTE_CAPTURE; }
    {LinePasteExitcode}     { return LuxTypes.T_PASTE_EXITCODE; }
    "$"                   { return LuxTypes.TEXT; }
    {NewLine}               { return LuxTypes.CRLF; }
    // <<EOF>>           { return TokenType.BAD_CHARACTER; }
}

<IN_DOC> {
    {T_ENDDOC}         { yybegin(YYINITIAL); return LuxTypes.K_END_DOC; }
    {T_DOC_TEXT}       { return LuxTypes.TEXT; }
    "["                { return LuxTypes.TEXT; }
//    {LineText}         { return LuxTypes.TEXT; }
//    {NewLine}          { return LuxTypes.CRLF; }
//    {AnyWhitespace}    { return LuxTypes.TEXT; }
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
    "]" {NewLine}       { yybegin(YYINITIAL); return LuxTypes.END_META; }
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
