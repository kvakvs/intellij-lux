package se.clau.intellijlux;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import se.clau.intellijlux.psi.LuxIdent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LuxUtil {
//  public static List<PsiElement> findProperties(Project project, String key) {
//    List<PsiElement> result = null;
//    Collection<VirtualFile> virtualFiles =
//            FileTypeIndex.getFiles(LuxFileType.INSTANCE,
//                    GlobalSearchScope.allScope(project));
//
//    for (VirtualFile virtualFile : virtualFiles) {
//      LuxFile luxFile = (LuxFile) PsiManager.getInstance(project).findFile(virtualFile);
//      if (luxFile != null) {
//        PsiElement[] properties = PsiTreeUtil.getChildrenOfType(luxFile, PsiElement.class);
//        if (properties != null) {
//          for (PsiElement property : properties) {
//            if (key.equals(property.getKey())) {
//              if (result == null) {
//                result = new ArrayList<PsiElement>();
//              }
//              result.add(property);
//            }
//          }
//        }
//      }
//    }
//    return result != null ? result : Collections.<PsiElement>emptyList();
//  }

  static List<LuxIdent> findIdentifiers(Project project) {
    List<LuxIdent> result = new ArrayList<>();
    Collection<VirtualFile> virtualFiles =
            FileTypeIndex.getFiles(LuxFileType.INSTANCE,
                    GlobalSearchScope.allScope(project));

    for (VirtualFile virtualFile : virtualFiles) {
      LuxFile LuxFile = (LuxFile) PsiManager.getInstance(project).findFile(virtualFile);
      if (LuxFile != null) {
        LuxIdent[] properties = PsiTreeUtil.getChildrenOfType(LuxFile,
                //PsiElement.class
                LuxIdent.class
                );
        if (properties != null) {
          Collections.addAll(result, properties);
        }
      }
    }
    return result;
  }
}