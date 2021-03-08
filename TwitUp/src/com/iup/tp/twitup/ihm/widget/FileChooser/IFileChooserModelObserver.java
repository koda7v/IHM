package com.iup.tp.twitup.ihm.widget.FileChooser;

/**
 * Interface observeur du modèle de FileChooser.
 * 
 * @author Edispa2020
 *
 */
public interface IFileChooserModelObserver
{

  /**
   * Notification du changement de fichier sélectionné.
   * 
   * @param file
   *          Fichier modifié.
   */
  public void updateSelectedFile(String file);
}
