package com.iup.tp.twitup.utils;

import java.io.File;
import java.nio.file.Path;

import com.iup.tp.twitup.configuration.ConstantLoader;

/**
 * Classe utilitaire pour les fichiers.
 * 
 * @author Edispa2020
 *
 */
public class FileUtils
{

  /**
   * Clé utilisée pour récupérer le séparateur de fichier.
   */
  protected static final String KEY_SYNC_FILE_SEPARATOR = "KEY_SYNC_FILE_SEPARATOR";

  /**
   * Clé utilisée pour récupérer le chemin raccourci.
   */
  protected static final String KEY_SHORTEN_PATH = "KEY_SHORTEN_PATH";

  /**
   * Message d'erreur pour la récupération des attributs.
   */
  protected static final String KEY_RECOVERY_ATTRIBUTES_ERROR = "KEY_RECOVERY_ATTRIBUTES_ERROR";

  /**
   * Constructeur privé pour éviter l'instanciatino de la classe.
   */
  private FileUtils()
  {}

  /**
   * Retourne un chemin raccourci du fichier envoyé en paramètre. <br>
   * Le chemin raccourci se compose du répertoire racine, du séparateur <b>"..."</b>, du répertoire parent et du nom du
   * fichier.<br>
   * Si le fichier ne possède pas de dossier parent ou que le fichier est le dossier racine, le chemin normal du fichier
   * est renvoyé. <br>
   * <br>
   * <b>Exemple:</b> <br>
   * <i>C://dossier1/dossier2/dossier3/fichier</i> devient <i>C://.../dossier3/fichier</i>
   * 
   * @param file
   *          Fichier impliqué.
   * @return Chemin du fichier raccourci.
   */
  public static String getShortPath(File file)
  {
    Path path = file.toPath();
    StringBuilder stringBuilder = new StringBuilder();

    if (path.getNameCount() < 3)
    {
      stringBuilder.append(path);
    }
    else
    {
      stringBuilder.append(path.getRoot());
      stringBuilder.append(ConstantLoader.getInstance().getText(KEY_SHORTEN_PATH));
      stringBuilder.append(File.separator);
      stringBuilder.append(path.getParent().getFileName());
      stringBuilder.append(File.separator);
      stringBuilder.append(path.getFileName());
    }

    return stringBuilder.toString();
  }

  /**
   * Retourne un chemin raccourci du syncfolder afficher. <br>
   * Le chemin raccourci se compose du répertoire racine, du séparateur <b>"..."</b>, du répertoire parent et du nom du
   * fichier.<br>
   * Si le fichier ne possède pas de dossier parent ou que le fichier est le dossier racine, le chemin normal du fichier
   * est renvoyé. <br>
   * <br>
   * <b>Exemple:</b> <br>
   * <i>C:/dossier1/dossier2/dossier3/fichier</i> devient <i>C://.../dossier2/dossier3</i>
   * 
   * @param path
   *          Path du syncfolder.
   * @return Chemin du dossier raccourci.
   */
  public static String getShortPath(String path)
  {
    String[] resultat = path.split(ConstantLoader.getInstance().getText(KEY_SYNC_FILE_SEPARATOR));
    StringBuilder stringBuilder = new StringBuilder();
    if (resultat.length > 3)
    {
      stringBuilder.append(resultat[0]);
      stringBuilder.append(ConstantLoader.getInstance().getText(KEY_SYNC_FILE_SEPARATOR));
      stringBuilder.append(ConstantLoader.getInstance().getText(KEY_SHORTEN_PATH));
      stringBuilder.append(ConstantLoader.getInstance().getText(KEY_SYNC_FILE_SEPARATOR));
      for (int i = resultat.length - 2; i < resultat.length; i++)
      {
        stringBuilder.append(resultat[i]);
        stringBuilder.append(ConstantLoader.getInstance().getText(KEY_SYNC_FILE_SEPARATOR));
      }
      stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }
    else
    {
      stringBuilder.append(path);
    }

    return stringBuilder.toString();
  }

  /**
   * Vérifie que le chemin appartient à l'arborescence du chemin parent.
   * 
   * @param parentPath
   * @param path
   * @return
   */
  public static boolean checkPathIntegrity(String parentPath, String path)
  {
    return path.startsWith(parentPath);
  }

}
