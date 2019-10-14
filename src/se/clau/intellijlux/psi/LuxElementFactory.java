package se.clau.intellijlux.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import se.clau.intellijlux.LuxFile;
import se.clau.intellijlux.LuxFileType;

public class LuxElementFactory {
  public static LuxIdent createProperty(Project project, String name) {
    final LuxFile file = createFile(project, name);
    return (LuxIdent) file.getFirstChild();
  }

  public static LuxFile createFile(Project project, String text) {
    String name = "dummy.lux";
    return (LuxFile) PsiFileFactory.getInstance(project).
            createFileFromText(name, LuxFileType.INSTANCE, text);
  }
}