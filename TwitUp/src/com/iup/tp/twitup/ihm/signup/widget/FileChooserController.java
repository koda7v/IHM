package com.iup.tp.twitup.ihm.signup.widget;

import java.io.File;
import java.io.Serializable;

/**
 * Contrôleur du composant graphique FileChooser.
 * 
 * @author Edispa2020
 *
 */
public class FileChooserController implements Serializable
{

  private static final long serialVersionUID = 7537969254168978367L;

  /**
   * Modèle du FileChooser.
   */
  protected FileChooserModel model;

  /**
   * Créer un nouveau contrôleur du composant graphique FileChooser.
   * 
   * @param model
   *          Modèle du FileChooser.
   */
  public FileChooserController(FileChooserModel model)
  {
    this.model = model;
  }

  /**
   * Clic sur le bouton parcourir du FileChooser.
   */
  public void click(File file)
  {
    model.setFile(file);
  }
}
