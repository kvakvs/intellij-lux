package se.clau.intellijlux;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.*;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.indexing.FileBasedIndex;
import se.clau.intellijlux.psi.*;

import java.util.*;

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

  public static List<PsiElement> findProperties(Project project) {
    List<PsiElement> result = new ArrayList<PsiElement>();
    Collection<VirtualFile> virtualFiles =
            FileTypeIndex.getFiles(LuxFileType.INSTANCE,
                    GlobalSearchScope.allScope(project));

    for (VirtualFile virtualFile : virtualFiles) {
      LuxFile LuxFile = (LuxFile) PsiManager.getInstance(project).findFile(virtualFile);
      if (LuxFile != null) {
        PsiElement[] properties = PsiTreeUtil.getChildrenOfType(LuxFile, PsiElement.class);
        if (properties != null) {
          Collections.addAll(result, properties);
        }
      }
    }
    return result;
  }
}