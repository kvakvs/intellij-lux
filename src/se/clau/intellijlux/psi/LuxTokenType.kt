package se.clau.intellijlux.psi;

import com.intellij.psi.tree.IElementType;
import se.clau.intellijlux.LuxLanguage;
import org.jetbrains.annotations.*;

public class LuxTokenType extends IElementType {
  public LuxTokenType(@NotNull @NonNls String debugName) {
    super(debugName, LuxLanguage.INSTANCE);
  }

  @Override
  public String toString() {
    return "LuxTokenType." + super.toString();
  }
}