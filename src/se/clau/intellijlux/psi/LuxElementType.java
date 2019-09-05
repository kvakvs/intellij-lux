package se.clau.intellijlux.psi;

import com.intellij.psi.tree.IElementType;
import se.clau.intellijlux.LuxLanguage;
import org.jetbrains.annotations.*;

public class LuxElementType extends IElementType {
  public LuxElementType(@NotNull @NonNls String debugName) {
    super(debugName, LuxLanguage.INSTANCE);
  }
}