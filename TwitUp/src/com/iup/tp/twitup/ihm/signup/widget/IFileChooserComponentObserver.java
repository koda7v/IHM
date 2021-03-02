package com.iup.tp.twitup.ihm.signup.widget;

/**
 * Interface observeur du composant FileChooser.
 * 
 * @author Edispa2020
 *
 */
public interface IFileChooserComponentObserver
{

  /**
   * Notifie que le fichier sélectionné a été modifié.
   * 
   * @param fileChooserComponent
   *          FileChooser ayant changé de fichier.
   */
  public void changeFile(FileChooserComponent fileChooserComponent);
}
