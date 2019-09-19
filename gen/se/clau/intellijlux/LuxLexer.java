/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package se.clau.intellijlux;

import com.intellij.psi.tree.IElementType;
import se.clau.intellijlux.psi.LuxTypes;
import com.intellij.psi.TokenType;
import com.intellij.lexer.FlexLexer;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>lux.flex</tt>
 */
class LuxLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int IN_DOC = 2;
  public static final int IN_CONFIG = 4;
  public static final int IN_CONFIG_VAL = 6;
  public static final int IN_NEWSHELL = 8;
  public static final int IN_SHELL = 10;
  public static final int IN_INCLUDE = 12;
  public static final int IN_LOOP = 14;
  public static final int IN_MACRO = 16;
  public static final int IN_INVOKE = 18;
  public static final int WAIT_NUM = 20;
  public static final int CONSUME_META = 22;
  public static final int REMAINING_LINE = 24;
  public static final int REMAINING_MULTILINE = 26;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  1,  1,  3,  3,  3,  3,  1,  1,  3,  3, 
     3,  3,  3,  3,  4,  4,  5,  5,  6,  6,  7, 7
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [11, 6, 4]
   * Total runtime size is 15232 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[(ZZ_CMAP_Z[ch>>10]<<6)|((ch>>4)&0x3f)]<<4)|(ch&0xf)];
  }

  /* The ZZ_CMAP_Z table has 1088 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\6\15\1\16\23\15"+
    "\1\17\1\15\1\20\1\21\12\15\1\22\10\12\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1"+
    "\32\1\33\1\34\1\35\1\36\2\12\1\15\1\37\3\12\1\40\10\12\1\41\1\42\5\15\1\43"+
    "\1\44\11\12\1\45\2\12\1\46\4\12\1\47\1\50\1\51\1\12\1\52\1\12\1\53\1\54\1"+
    "\55\3\12\51\15\1\56\3\15\1\57\1\60\4\15\1\61\12\12\1\62\u02c1\12\1\63\277"+
    "\12");

  /* The ZZ_CMAP_Y table has 3328 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\2\1\1\10\1\11\1\12\1\13\1\12\1\13\34\12\1"+
    "\14\1\15\1\16\1\1\7\12\1\17\1\20\1\12\1\21\4\12\1\22\10\12\1\21\12\12\1\23"+
    "\1\12\1\24\1\23\1\12\1\25\1\23\1\12\1\26\1\27\1\12\1\30\1\31\1\1\1\30\4\12"+
    "\1\32\6\12\1\33\1\34\1\35\1\1\3\12\1\36\6\12\1\15\3\12\1\37\2\12\1\40\1\1"+
    "\1\12\1\41\4\1\1\12\1\42\1\1\1\43\1\21\7\12\1\44\1\23\1\33\1\45\1\34\1\46"+
    "\1\47\1\50\1\44\1\15\1\51\1\45\1\34\1\52\1\53\1\54\1\55\1\56\1\57\1\21\1\34"+
    "\1\60\1\61\1\62\1\44\1\63\1\64\1\45\1\34\1\60\1\65\1\66\1\44\1\67\1\70\1\71"+
    "\1\72\1\32\1\73\1\74\1\55\1\1\1\75\1\76\1\34\1\77\1\100\1\101\1\44\1\1\1\75"+
    "\1\76\1\34\1\102\1\100\1\103\1\44\1\104\1\105\1\76\1\12\1\36\1\106\1\107\1"+
    "\44\1\110\1\111\1\112\1\12\1\113\1\114\1\115\1\55\1\116\1\23\2\12\1\30\1\117"+
    "\1\120\2\1\1\121\1\122\1\123\1\124\1\125\1\126\2\1\1\62\1\127\1\120\1\130"+
    "\1\131\1\12\1\132\1\23\1\133\1\131\1\12\1\132\1\134\3\1\4\12\1\120\4\12\1"+
    "\40\2\12\1\135\2\12\1\136\24\12\1\137\1\140\2\12\1\137\2\12\1\141\1\142\1"+
    "\13\3\12\1\142\3\12\1\36\2\1\1\12\1\1\5\12\1\143\1\23\45\12\1\35\1\12\1\23"+
    "\1\30\4\12\1\144\1\145\1\146\1\147\1\12\1\147\1\12\1\150\1\146\1\151\5\12"+
    "\1\152\1\120\1\1\1\153\1\120\5\12\1\25\2\12\1\30\4\12\1\56\1\12\1\117\2\41"+
    "\1\55\1\12\1\40\1\147\2\12\1\41\1\12\2\120\2\1\1\12\1\41\3\12\1\117\1\12\1"+
    "\35\2\120\1\154\1\117\4\1\4\12\1\41\1\120\1\155\1\150\7\12\1\150\3\12\1\25"+
    "\1\77\2\12\1\40\1\145\4\1\1\156\1\12\1\157\17\12\1\160\21\12\1\143\2\12\1"+
    "\143\1\161\1\12\1\40\3\12\1\162\1\163\1\164\1\132\1\163\3\1\1\165\1\62\1\166"+
    "\1\1\1\167\1\1\1\132\3\1\2\12\1\62\1\170\1\171\1\172\1\126\1\173\1\1\2\12"+
    "\1\145\62\1\1\55\2\12\1\120\161\1\2\12\1\117\2\12\1\117\10\12\1\174\1\150"+
    "\2\12\1\135\3\12\1\175\1\165\1\12\1\176\4\177\2\12\2\1\1\165\35\1\1\200\1"+
    "\1\1\23\1\201\1\23\4\12\1\202\1\23\4\12\1\136\1\203\1\12\1\40\1\23\4\12\1"+
    "\117\1\1\1\12\1\30\3\1\1\12\40\1\133\12\1\56\4\1\135\12\1\56\2\1\10\12\1\132"+
    "\4\1\2\12\1\40\20\12\1\132\1\12\1\41\1\1\3\12\1\204\7\12\1\15\1\1\1\205\1"+
    "\206\5\12\1\207\1\12\1\117\1\25\3\1\1\205\2\12\1\25\1\1\3\12\1\150\4\12\1"+
    "\56\1\120\1\12\1\210\2\12\1\40\2\12\1\150\1\12\1\132\4\12\1\211\1\120\1\12"+
    "\1\117\3\12\1\176\1\40\1\120\1\12\1\112\4\12\1\31\1\153\1\12\1\212\1\213\1"+
    "\214\1\177\2\12\1\136\1\56\7\12\1\215\1\120\72\12\1\150\1\12\1\216\2\12\1"+
    "\41\20\1\26\12\1\40\6\12\1\120\2\1\1\176\1\217\1\34\1\220\1\221\6\12\1\15"+
    "\1\1\1\222\25\12\1\40\1\1\4\12\1\206\2\12\1\25\2\1\1\41\1\12\1\1\1\12\1\223"+
    "\1\224\2\1\1\133\7\12\1\132\1\1\1\120\1\23\1\225\1\23\1\30\1\55\4\12\1\117"+
    "\1\226\1\227\2\1\1\230\1\12\1\13\1\231\2\40\2\1\7\12\1\30\4\1\3\12\1\147\7"+
    "\1\1\232\10\1\1\12\1\132\3\12\2\62\1\1\2\12\1\1\1\12\1\30\2\12\1\30\1\12\1"+
    "\40\2\12\1\233\1\234\2\1\11\12\1\40\1\120\2\12\1\233\1\12\1\41\2\12\1\25\3"+
    "\12\1\150\11\1\23\12\1\176\1\12\1\56\1\25\11\1\1\235\2\12\1\236\1\12\1\56"+
    "\1\12\1\176\1\12\1\117\4\1\1\12\1\237\1\12\1\56\1\12\1\120\4\1\3\12\1\240"+
    "\4\1\1\241\1\242\1\12\1\243\2\1\1\12\1\132\1\12\1\132\2\1\1\131\1\12\1\176"+
    "\1\1\3\12\1\56\1\12\1\56\1\12\1\31\1\12\1\15\6\1\4\12\1\145\3\1\3\12\1\31"+
    "\3\12\1\31\60\1\4\12\1\176\1\1\1\55\1\165\3\12\1\30\1\1\1\12\1\145\1\120\3"+
    "\12\1\133\1\1\2\12\1\244\4\12\1\245\1\246\2\1\1\12\1\21\1\12\1\247\4\1\1\250"+
    "\1\26\1\145\3\12\1\30\1\120\1\33\1\45\1\34\1\60\1\65\1\251\1\252\1\147\10"+
    "\1\4\12\1\30\1\120\2\1\4\12\1\253\1\120\12\1\3\12\1\254\1\62\1\255\2\1\4\12"+
    "\1\256\1\120\2\1\3\12\1\25\1\120\3\1\1\12\1\77\1\41\1\120\26\1\4\12\1\120"+
    "\1\165\34\1\3\12\1\145\20\1\1\34\2\12\1\13\1\62\1\120\1\1\1\206\1\12\1\206"+
    "\1\131\1\176\64\1\71\12\1\120\6\1\6\12\1\117\1\1\14\12\1\150\53\1\2\12\1\117"+
    "\75\1\44\12\1\176\33\1\43\12\1\145\1\12\1\117\1\120\6\1\1\12\1\40\1\147\3"+
    "\12\1\176\1\150\1\120\1\222\1\257\1\12\67\1\4\12\1\147\2\12\1\117\1\165\1"+
    "\12\4\1\1\62\1\1\76\12\1\132\1\1\57\12\1\31\20\1\1\15\77\1\6\12\1\30\1\132"+
    "\1\145\1\260\114\1\1\261\1\262\1\263\1\1\1\264\11\1\1\265\33\1\5\12\1\133"+
    "\3\12\1\146\1\266\1\267\1\270\3\12\1\271\1\272\1\12\1\273\1\274\1\76\24\12"+
    "\1\254\1\12\1\76\1\136\1\12\1\136\1\12\1\133\1\12\1\133\1\117\1\12\1\117\1"+
    "\12\1\34\1\12\1\34\1\12\1\275\3\12\40\1\3\12\1\216\2\12\1\132\1\276\1\166"+
    "\1\155\1\23\25\1\1\13\1\207\1\277\75\1\14\12\1\147\1\176\2\1\4\12\1\30\1\120"+
    "\112\1\1\270\1\12\1\300\1\301\1\302\1\303\1\304\1\305\1\306\1\41\1\307\1\41"+
    "\47\1\1\12\1\120\1\12\1\120\1\12\1\120\47\1\55\12\1\176\2\1\103\12\1\147\15"+
    "\12\1\40\150\12\1\15\25\1\41\12\1\40\56\1\17\12\41\1");

  /* The ZZ_CMAP_A table has 3200 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\2\1\1\1\0\1\2\1\1\22\0\1\2\1\16\1\15\1\3\1\4\6\0\1\11\1\0\1\5\2\0"+
    "\12\7\3\0\1\51\1\0\1\20\1\21\32\6\1\22\1\14\1\10\1\0\1\6\1\0\1\26\1\44\1\23"+
    "\1\32\1\25\1\43\1\41\1\47\1\36\1\6\1\40\1\24\1\34\1\27\1\33\1\31\1\6\1\35"+
    "\1\42\1\50\1\30\1\37\1\46\1\6\1\45\1\6\1\12\1\0\1\13\1\17\13\0\1\6\12\0\1"+
    "\6\4\0\1\6\5\0\27\6\1\0\12\6\4\0\14\6\16\0\5\6\7\0\1\6\1\0\1\6\1\0\5\6\1\0"+
    "\2\6\2\0\4\6\1\0\1\6\6\0\1\6\1\0\3\6\1\0\1\6\1\0\4\6\1\0\23\6\1\0\11\6\1\0"+
    "\26\6\2\0\1\6\6\0\10\6\10\0\16\6\1\0\1\6\1\0\2\6\1\0\2\6\1\0\1\6\10\0\13\6"+
    "\5\0\3\6\15\0\12\6\4\0\6\6\1\0\10\6\2\0\12\6\1\0\23\6\2\0\14\6\2\0\11\6\4"+
    "\0\1\6\5\0\16\6\2\0\14\6\4\0\5\6\1\0\10\6\6\0\20\6\2\0\13\6\2\0\16\6\1\0\1"+
    "\6\3\0\4\6\2\0\11\6\2\0\2\6\2\0\4\6\10\0\1\6\4\0\2\6\1\0\1\6\1\0\3\6\1\0\6"+
    "\6\4\0\2\6\1\0\2\6\1\0\2\6\1\0\2\6\2\0\1\6\1\0\5\6\4\0\2\6\2\0\3\6\3\0\1\6"+
    "\7\0\4\6\1\0\1\6\7\0\20\6\13\0\3\6\1\0\11\6\1\0\2\6\1\0\2\6\1\0\5\6\2\0\12"+
    "\6\1\0\3\6\1\0\3\6\2\0\1\6\30\0\1\6\7\0\3\6\1\0\10\6\2\0\6\6\2\0\2\6\2\0\3"+
    "\6\10\0\2\6\4\0\2\6\1\0\1\6\1\0\1\6\20\0\2\6\1\0\6\6\3\0\3\6\1\0\4\6\3\0\2"+
    "\6\1\0\1\6\1\0\2\6\3\0\2\6\3\0\3\6\3\0\5\6\3\0\3\6\1\0\4\6\2\0\1\6\6\0\1\6"+
    "\10\0\4\6\1\0\10\6\1\0\3\6\1\0\30\6\3\0\10\6\1\0\3\6\1\0\4\6\7\0\2\6\1\0\3"+
    "\6\5\0\4\6\1\0\5\6\2\0\4\6\5\0\2\6\7\0\1\6\2\0\2\6\16\0\3\6\1\0\10\6\1\0\7"+
    "\6\1\0\3\6\1\0\5\6\5\0\4\6\7\0\1\6\12\0\6\6\2\0\2\6\1\0\22\6\3\0\10\6\1\0"+
    "\11\6\1\0\1\6\2\0\7\6\3\0\1\6\4\0\6\6\1\0\1\6\1\0\10\6\2\0\2\6\14\0\17\6\1"+
    "\0\12\6\7\0\2\6\1\0\1\6\2\0\2\6\1\0\1\6\2\0\1\6\6\0\4\6\1\0\7\6\1\0\3\6\1"+
    "\0\1\6\1\0\1\6\2\0\2\6\1\0\15\6\1\0\3\6\2\0\5\6\1\0\1\6\1\0\6\6\2\0\12\6\2"+
    "\0\4\6\10\0\2\6\13\0\1\6\1\0\1\6\1\0\1\6\4\0\12\6\1\0\24\6\3\0\5\6\1\0\12"+
    "\6\6\0\1\6\11\0\6\6\1\0\1\6\5\0\1\6\2\0\13\6\1\0\15\6\1\0\4\6\2\0\7\6\1\0"+
    "\1\6\1\0\4\6\2\0\1\6\1\0\4\6\2\0\7\6\1\0\1\6\1\0\4\6\2\0\16\6\2\0\6\6\2\0"+
    "\13\6\3\0\13\6\7\0\15\6\1\0\7\6\13\0\4\6\14\0\1\6\1\0\2\6\14\0\4\6\3\0\1\6"+
    "\4\0\2\6\15\0\3\6\11\0\1\6\23\0\10\6\1\0\23\6\1\0\2\6\6\0\6\6\5\0\15\6\1\0"+
    "\1\6\1\0\1\6\1\0\1\6\1\0\6\6\1\0\7\6\1\0\1\6\3\0\3\6\1\0\7\6\3\0\4\6\2\0\6"+
    "\6\23\0\1\6\4\0\1\6\14\0\1\6\15\0\1\6\2\0\1\6\4\0\1\6\2\0\12\6\1\0\1\6\3\0"+
    "\5\6\6\0\1\6\1\0\1\6\1\0\1\6\1\0\4\6\1\0\1\6\5\0\5\6\4\0\1\6\1\0\5\6\6\0\15"+
    "\6\7\0\10\6\11\0\7\6\1\0\7\6\6\0\3\6\11\0\5\6\2\0\5\6\3\0\7\6\2\0\2\6\2\0"+
    "\3\6\5\0\16\6\1\0\12\6\1\0\1\6\7\0\11\6\2\0\27\6\2\0\15\6\3\0\1\6\1\0\1\6"+
    "\2\0\1\6\16\0\1\6\2\0\5\6\12\0\6\6\2\0\6\6\2\0\6\6\11\0\13\6\1\0\2\6\2\0\7"+
    "\6\4\0\5\6\3\0\5\6\5\0\12\6\1\0\5\6\1\0\1\6\1\0\2\6\1\0\2\6\1\0\12\6\3\0\15"+
    "\6\3\0\2\6\30\0\16\6\4\0\1\6\2\0\6\6\2\0\6\6\2\0\6\6\2\0\3\6\3\0\14\6\1\0"+
    "\16\6\1\0\2\6\1\0\1\6\15\0\1\6\2\0\4\6\4\0\10\6\1\0\5\6\12\0\6\6\2\0\1\6\1"+
    "\0\14\6\1\0\2\6\3\0\1\6\2\0\4\6\1\0\2\6\12\0\10\6\6\0\6\6\1\0\2\6\5\0\10\6"+
    "\1\0\3\6\1\0\13\6\4\0\3\6\4\0\5\6\2\0\1\6\11\0\5\6\5\0\3\6\3\0\13\6\1\0\1"+
    "\6\3\0\10\6\6\0\1\6\1\0\7\6\1\0\1\6\1\0\4\6\1\0\2\6\6\0\1\6\5\0\7\6\2\0\7"+
    "\6\3\0\6\6\1\0\1\6\10\0\6\6\2\0\10\6\10\0\6\6\2\0\1\6\3\0\1\6\13\0\10\6\5"+
    "\0\15\6\3\0\2\6\6\0\5\6\3\0\6\6\10\0\10\6\2\0\7\6\16\0\4\6\4\0\3\6\15\0\1"+
    "\6\2\0\2\6\2\0\4\6\1\0\14\6\1\0\1\6\1\0\7\6\1\0\21\6\1\0\4\6\2\0\10\6\1\0"+
    "\7\6\1\0\14\6\1\0\4\6\1\0\5\6\1\0\1\6\3\0\11\6\1\0\10\6\2\0\2\6\5\0\1\6\12"+
    "\0\2\6\1\0\2\6\1\0\5\6\6\0\2\6\1\0\1\6\2\0\1\6\1\0\12\6\1\0\4\6\1\0\1\6\1"+
    "\0\1\6\6\0\1\6\4\0\1\6\1\0\1\6\1\0\1\6\1\0\3\6\1\0\2\6\1\0\1\6\2\0\1\6\1\0"+
    "\1\6\1\0\1\6\1\0\1\6\1\0\1\6\1\0\2\6\1\0\1\6\2\0\4\6\1\0\7\6\1\0\4\6\1\0\4"+
    "\6\1\0\1\6\1\0\12\6\1\0\5\6\1\0\3\6\1\0\5\6\1\0\5\6");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\5\0\3\1\1\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\2\1\11\1\12\1\13\1\14\1\2\1\15"+
    "\1\16\1\17\1\20\1\1\1\2\2\1\1\21\2\1"+
    "\1\3\1\1\1\22\1\23\1\0\1\24\1\25\1\26"+
    "\1\27\13\0\1\30\1\31\1\32\1\0\1\33\1\34"+
    "\1\1\1\0\1\35\17\0\1\36\1\37\1\40\1\41"+
    "\11\0\1\42\6\0\1\31\1\43\1\44\11\0\1\45"+
    "\1\46\7\0\1\47\3\0\1\50\16\0\1\51\5\0"+
    "\1\52\3\0\1\53\1\54\1\55\2\0\1\56\1\0"+
    "\1\57\4\0\1\60\1\61\1\0\1\62\1\63\3\0"+
    "\1\64\1\65\1\66\1\67\1\70\1\71\1\72";

  private static int [] zzUnpackAction() {
    int [] result = new int[173];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\52\0\124\0\176\0\250\0\322\0\374\0\u0126"+
    "\0\u0150\0\u017a\0\u01a4\0\u01ce\0\u01f8\0\u0150\0\u0222\0\u024c"+
    "\0\u0150\0\u0150\0\u0276\0\u02a0\0\u02ca\0\u02f4\0\u0150\0\u031e"+
    "\0\u0348\0\u0372\0\u039c\0\u03c6\0\u03f0\0\u0150\0\u041a\0\u0444"+
    "\0\u0150\0\u046e\0\u0150\0\u0150\0\u0498\0\u0150\0\u0150\0\u04c2"+
    "\0\u0150\0\u04ec\0\u0516\0\u0540\0\u056a\0\u0594\0\u05be\0\u05e8"+
    "\0\u0612\0\u063c\0\u0666\0\u0690\0\u06ba\0\u06ba\0\u0150\0\u06e4"+
    "\0\u0150\0\u0150\0\u070e\0\u0738\0\u0150\0\u0762\0\u078c\0\u07b6"+
    "\0\u07e0\0\u080a\0\u0834\0\u085e\0\u0888\0\u08b2\0\u08dc\0\u0906"+
    "\0\u0930\0\u095a\0\u0984\0\u09ae\0\u0444\0\u0150\0\u0150\0\u09d8"+
    "\0\u0a02\0\u0a2c\0\u0a56\0\u0a80\0\u0aaa\0\u0ad4\0\u0afe\0\u0b28"+
    "\0\u0b52\0\u0150\0\u0b7c\0\u0ba6\0\u0bd0\0\u0bfa\0\u0c24\0\u0c4e"+
    "\0\u0150\0\u0150\0\u0c78\0\u0ca2\0\u0ccc\0\u0cf6\0\u0d20\0\u0d4a"+
    "\0\u0d74\0\u0d9e\0\u0dc8\0\u0df2\0\u0150\0\u0150\0\u0e1c\0\u0e46"+
    "\0\u0e70\0\u0e9a\0\u0ec4\0\u0eee\0\u0f18\0\u0150\0\u0f42\0\u0f6c"+
    "\0\u0f96\0\u0150\0\u0fc0\0\u0fea\0\u1014\0\u103e\0\u1068\0\u1092"+
    "\0\u10bc\0\u10e6\0\u1110\0\u113a\0\u1164\0\u118e\0\u11b8\0\u11e2"+
    "\0\u0150\0\u120c\0\u1236\0\u1260\0\u128a\0\u12b4\0\u0150\0\u12de"+
    "\0\u1308\0\u1332\0\u0150\0\u0150\0\u0150\0\u135c\0\u1386\0\u0150"+
    "\0\u13b0\0\u0150\0\u13da\0\u1404\0\u142e\0\u1458\0\u0150\0\u0150"+
    "\0\u1482\0\u0150\0\u0150\0\u14ac\0\u14d6\0\u1500\0\u0150\0\u0150"+
    "\0\u0150\0\u0150\0\u0150\0\u0150\0\u0150";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[173];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\11\1\12\1\13\1\14\1\11\1\15\2\11\1\16"+
    "\1\17\3\11\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\105\11\1\26\1\11\2\26\13\11\26\26\1\27\4\11"+
    "\1\30\1\11\2\30\13\11\26\30\10\11\1\31\42\11"+
    "\1\32\1\11\2\32\1\33\3\32\1\34\41\32\1\35"+
    "\1\36\2\35\1\33\7\35\1\37\35\35\1\40\1\41"+
    "\2\40\1\33\10\40\1\42\34\40\53\0\1\12\52\0"+
    "\1\13\47\0\1\14\1\0\50\14\1\0\1\43\51\0"+
    "\1\44\65\0\1\45\35\0\1\46\7\0\1\47\6\0"+
    "\1\50\32\0\1\51\73\0\1\52\1\53\1\54\1\0"+
    "\1\55\1\0\1\56\1\57\1\0\1\60\1\0\1\61"+
    "\2\0\1\62\1\63\5\0\1\64\6\0\3\26\13\0"+
    "\26\26\6\0\3\30\13\0\26\30\10\0\1\31\42\0"+
    "\1\32\1\0\2\32\1\0\3\32\1\0\41\32\4\0"+
    "\1\65\1\0\2\66\1\0\1\67\1\70\10\0\26\66"+
    "\2\0\1\71\50\0\1\35\1\0\2\35\1\0\7\35"+
    "\1\0\35\35\1\0\1\72\50\0\1\40\1\0\2\40"+
    "\1\0\46\40\1\0\2\40\1\0\10\40\1\73\34\40"+
    "\15\0\1\74\54\0\1\75\55\0\1\76\6\0\1\77"+
    "\51\0\1\100\45\0\1\101\47\0\1\102\61\0\1\103"+
    "\47\0\1\104\44\0\1\105\16\0\1\106\33\0\1\107"+
    "\46\0\1\110\51\0\1\111\22\0\1\112\40\0\1\113"+
    "\20\0\3\66\13\0\26\66\5\0\1\114\1\0\2\114"+
    "\13\0\26\114\1\0\1\40\1\0\2\40\1\0\10\40"+
    "\1\115\34\40\16\0\1\116\1\117\1\120\56\0\1\121"+
    "\53\0\1\122\45\0\1\123\7\0\1\124\50\0\1\125"+
    "\65\0\1\126\36\0\1\127\41\0\1\130\51\0\1\131"+
    "\30\0\1\132\72\0\1\133\13\0\1\134\45\0\1\135"+
    "\43\0\1\136\51\0\1\137\60\0\1\140\22\0\3\114"+
    "\3\0\1\141\7\0\26\114\12\0\1\142\6\0\1\143"+
    "\57\0\1\144\66\0\1\145\34\0\1\146\54\0\1\147"+
    "\44\0\1\150\5\0\1\151\1\0\1\152\57\0\1\153"+
    "\50\0\1\154\12\0\1\155\5\0\1\156\76\0\1\157"+
    "\40\0\1\160\60\0\1\161\62\0\1\162\32\0\1\163"+
    "\50\0\1\164\52\0\1\165\44\0\1\166\60\0\1\167"+
    "\60\0\1\170\37\0\1\171\27\0\1\172\102\0\1\173"+
    "\51\0\1\174\44\0\1\175\72\0\1\176\37\0\1\177"+
    "\47\0\1\200\46\0\1\201\61\0\1\202\37\0\1\203"+
    "\54\0\1\204\44\0\1\205\60\0\1\206\46\0\1\207"+
    "\62\0\1\210\12\0\1\211\102\0\1\212\41\0\1\213"+
    "\51\0\1\214\53\0\1\215\51\0\1\216\26\0\1\217"+
    "\101\0\1\220\44\0\1\221\50\0\1\222\27\0\1\223"+
    "\51\0\1\224\5\0\1\225\71\0\1\226\52\0\1\227"+
    "\22\0\1\230\100\0\1\231\30\0\1\232\76\0\1\233"+
    "\40\0\1\234\67\0\1\235\34\0\1\236\26\0\1\237"+
    "\51\0\1\240\117\0\1\241\11\0\1\242\51\0\1\243"+
    "\74\0\1\244\42\0\1\245\67\0\1\246\11\0\1\247"+
    "\51\0\1\250\5\0\1\251\51\0\1\252\43\0\1\253"+
    "\5\0\1\254\43\0\1\255\47\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[5418];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\5\0\3\1\1\11\4\1\1\11\2\1\2\11\4\1"+
    "\1\11\6\1\1\11\2\1\1\11\1\1\2\11\1\0"+
    "\2\11\1\1\1\11\13\0\2\1\1\11\1\0\2\11"+
    "\1\1\1\0\1\11\17\0\1\1\2\11\1\1\11\0"+
    "\1\11\6\0\2\11\1\1\11\0\2\11\7\0\1\11"+
    "\3\0\1\11\16\0\1\11\5\0\1\11\3\0\3\11"+
    "\2\0\1\11\1\0\1\11\4\0\2\11\1\0\2\11"+
    "\3\0\7\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[173];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  LuxLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        zzDoEOF();
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return LuxTypes.TEXT;
            } 
            // fall through
          case 59: break;
          case 2: 
            { return TokenType.BAD_CHARACTER;
            } 
            // fall through
          case 60: break;
          case 3: 
            { return LuxTypes.CRLF;
            } 
            // fall through
          case 61: break;
          case 4: 
            { return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 62: break;
          case 5: 
            { return LuxTypes.COMMENT;
            } 
            // fall through
          case 63: break;
          case 6: 
            { yybegin(REMAINING_LINE); return LuxTypes.K_SET_FAILURE;
            } 
            // fall through
          case 64: break;
          case 7: 
            { return LuxTypes.T_SQR_CLOSE;
            } 
            // fall through
          case 65: break;
          case 8: 
            { yybegin(REMAINING_LINE); return LuxTypes.K_SET_SUCCESS;
            } 
            // fall through
          case 66: break;
          case 9: 
            { yybegin(REMAINING_LINE); return LuxTypes.K_SEND;
            } 
            // fall through
          case 67: break;
          case 10: 
            { yybegin(REMAINING_LINE); return LuxTypes.K_SEND_LN;
            } 
            // fall through
          case 68: break;
          case 11: 
            { yybegin(REMAINING_LINE); return LuxTypes.K_EXP_REGEX;
            } 
            // fall through
          case 69: break;
          case 12: 
            { yybegin(REMAINING_LINE); return LuxTypes.K_SET_LOOP_BREAK;
            } 
            // fall through
          case 70: break;
          case 13: 
            { return LuxTypes.T_IDENT;
            } 
            // fall through
          case 71: break;
          case 14: 
            { yybegin(CONSUME_META); return LuxTypes.T_EQUALS;
            } 
            // fall through
          case 72: break;
          case 15: 
            { yybegin(CONSUME_META); return LuxTypes.T_IDENT;
            } 
            // fall through
          case 73: break;
          case 16: 
            { yybegin(YYINITIAL); return LuxTypes.T_NUMBER;
            } 
            // fall through
          case 74: break;
          case 17: 
            { yybegin(YYINITIAL); return LuxTypes.CRLF;
            } 
            // fall through
          case 75: break;
          case 18: 
            { return LuxTypes.K_SET_FAILURE_ONLY;
            } 
            // fall through
          case 76: break;
          case 19: 
            { return LuxTypes.K_SET_SUCCESS_ONLY;
            } 
            // fall through
          case 77: break;
          case 20: 
            { return LuxTypes.K_FLUSH;
            } 
            // fall through
          case 78: break;
          case 21: 
            { yybegin(REMAINING_LINE); return LuxTypes.K_EXP_MAYBE_REGEX;
            } 
            // fall through
          case 79: break;
          case 22: 
            { yybegin(REMAINING_LINE); return LuxTypes.K_EXP_TEMPLATE;
            } 
            // fall through
          case 80: break;
          case 23: 
            { return LuxTypes.K_SET_LOOP_BREAK_ONLY;
            } 
            // fall through
          case 81: break;
          case 24: 
            { return LuxTypes.T_DOLLAR;
            } 
            // fall through
          case 82: break;
          case 25: 
            { return LuxTypes.T_PASTE_VARIABLE;
            } 
            // fall through
          case 83: break;
          case 26: 
            { return LuxTypes.T_PASTE_CAPTURE;
            } 
            // fall through
          case 84: break;
          case 27: 
            { yybegin(YYINITIAL); return LuxTypes.END_META;
            } 
            // fall through
          case 85: break;
          case 28: 
            { return LuxTypes.LINE_CONTINUATION;
            } 
            // fall through
          case 86: break;
          case 29: 
            { yybegin(REMAINING_LINE); return LuxTypes.K_EXP_VERBATIM;
            } 
            // fall through
          case 87: break;
          case 30: 
            { yybegin(YYINITIAL); return LuxTypes.END_MULTILINE;
            } 
            // fall through
          case 88: break;
          case 31: 
            { yybegin(REMAINING_MULTILINE); return LuxTypes.K_ML_SEND;
            } 
            // fall through
          case 89: break;
          case 32: 
            { yybegin(REMAINING_MULTILINE); return LuxTypes.K_ML_SEND_LN;
            } 
            // fall through
          case 90: break;
          case 33: 
            { yybegin(REMAINING_MULTILINE); return LuxTypes.K_ML_EXP_REGEX;
            } 
            // fall through
          case 91: break;
          case 34: 
            { yybegin(IN_CONFIG); return LuxTypes.K_MY;
            } 
            // fall through
          case 92: break;
          case 35: 
            { yybegin(REMAINING_MULTILINE); return LuxTypes.K_ML_EXP_MAYBE_REGEX;
            } 
            // fall through
          case 93: break;
          case 36: 
            { yybegin(REMAINING_MULTILINE); return LuxTypes.K_ML_EXP_TEMPLATE;
            } 
            // fall through
          case 94: break;
          case 37: 
            { yybegin(CONSUME_META); return LuxTypes.K_DOC;
            } 
            // fall through
          case 95: break;
          case 38: 
            { return LuxTypes.K_DOC_ONLY;
            } 
            // fall through
          case 96: break;
          case 39: 
            { yybegin(REMAINING_MULTILINE); return LuxTypes.K_ML_EXP_VERBATIM;
            } 
            // fall through
          case 97: break;
          case 40: 
            { yybegin(IN_LOOP); return LuxTypes.K_LOOP;
            } 
            // fall through
          case 98: break;
          case 41: 
            { yybegin(IN_CONFIG); return LuxTypes.K_LOCAL;
            } 
            // fall through
          case 99: break;
          case 42: 
            { yybegin(IN_MACRO); return LuxTypes.K_MACRO;
            } 
            // fall through
          case 100: break;
          case 43: 
            { yybegin(WAIT_NUM); return LuxTypes.K_SLEEP;
            } 
            // fall through
          case 101: break;
          case 44: 
            { yybegin(IN_SHELL); return LuxTypes.K_SHELL;
            } 
            // fall through
          case 102: break;
          case 45: 
            { return LuxTypes.K_SHELL_ONLY;
            } 
            // fall through
          case 103: break;
          case 46: 
            { yybegin(IN_CONFIG); return LuxTypes.K_CONFIG;
            } 
            // fall through
          case 104: break;
          case 47: 
            { return LuxTypes.K_END_DOC;
            } 
            // fall through
          case 105: break;
          case 48: 
            { yybegin(IN_INVOKE); return LuxTypes.K_INVOKE;
            } 
            // fall through
          case 106: break;
          case 49: 
            { yybegin(IN_CONFIG); return LuxTypes.K_GLOBAL;
            } 
            // fall through
          case 107: break;
          case 50: 
            { return LuxTypes.K_CLEANUP;
            } 
            // fall through
          case 108: break;
          case 51: 
            { return LuxTypes.K_END_LOOP;
            } 
            // fall through
          case 109: break;
          case 52: 
            { yybegin(CONSUME_META); return LuxTypes.K_INCLUDE;
            } 
            // fall through
          case 110: break;
          case 53: 
            { yybegin(WAIT_NUM); return LuxTypes.K_TIMEOUT;
            } 
            // fall through
          case 111: break;
          case 54: 
            { return LuxTypes.K_TIMEOUT_ONLY;
            } 
            // fall through
          case 112: break;
          case 55: 
            { return LuxTypes.K_END_MACRO;
            } 
            // fall through
          case 113: break;
          case 56: 
            { yybegin(IN_NEWSHELL); return LuxTypes.K_NEWSHELL;
            } 
            // fall through
          case 114: break;
          case 57: 
            { return LuxTypes.K_NEWSHELL_ONLY;
            } 
            // fall through
          case 115: break;
          case 58: 
            { yybegin(CONSUME_META); return LuxTypes.K_PROGRESS;
            } 
            // fall through
          case 116: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
