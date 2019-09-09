package se.clau.intellijlux;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.*;
import org.jetbrains.annotations.*;

import javax.swing.*;
import java.util.Map;

public class LuxColorSettingsPage implements ColorSettingsPage {
  private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
          new AttributesDescriptor("Comment",
                  LuxSyntaxHighlighter.COMMENT),
          new AttributesDescriptor("Line Content",
                  LuxSyntaxHighlighter.LINE_CONTENT),
          new AttributesDescriptor("Bad Character",
                  LuxSyntaxHighlighter.BAD_CHARACTER),
          new AttributesDescriptor("Keyword",
                  LuxSyntaxHighlighter.KEYWORD),
          new AttributesDescriptor("Meta",
                  LuxSyntaxHighlighter.META),
          new AttributesDescriptor("Identifier",
                  LuxSyntaxHighlighter.IDENT),
  };

  @Nullable
  @Override
  public Icon getIcon() {
    return LuxIcons.FILE;
  }

  @NotNull
  @Override
  public SyntaxHighlighter getHighlighter() {
    return new LuxSyntaxHighlighter();
  }

  @NotNull
  @Override
  public String getDemoText() {
    return ")bad character\n" +
            "[doc Test of macros and variable scope]\n" +
            "[global fail_pattern=[Ee][Rr][Rr][Oo][Rr]]\n" +
            "[global eprompt=\\d+>\\s]\n" +
            "# Setup a shell dedicated for calculations\n" +
            "[shell calc]\n" +
            "    # Setup a (local) failure pattern\n" +
            "    -$fail_pattern|SH-PROMPT:\n" +
            "    !erl\n" +
            "    \"\"\"?\n" +
            "    Eshell.*\n" +
            "    $eprompt\n" +
            "    \"\"\"\n" +
            "[macro calc expr]\n" +
            "    [my myshell=$LUX_SHELLNAME]\n" +
            "    [shell calc]\n" +
            "        !\n" +
            "        !$expr." +
            "    [shell $myshell]\n" +
            "    [progress $expr=$result]\n" +
            "[endmacro]";
  }

  @Nullable
  @Override
  public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
    return null;
  }

  @NotNull
  @Override
  public AttributesDescriptor[] getAttributeDescriptors() {
    return DESCRIPTORS;
  }

  @NotNull
  @Override
  public ColorDescriptor[] getColorDescriptors() {
    return ColorDescriptor.EMPTY_ARRAY;
  }

  @NotNull
  @Override
  public String getDisplayName() {
    return "Lucid Expect (Lux)";
  }
}