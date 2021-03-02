package com.iup.tp.twitup.ihm.signup.widget;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Modèle du FileChooser, contient le chemin sélectionné par l'utilisateur.
 * 
 * @author Edispa2020
 *
 */
public class FileChooserModel implements Serializable
{

  private static final long serialVersionUID = 720040293968780533L;

  /**
   * Fichier sélectionné.
   */
  protected File file;

  /**
   * Liste des observeurs du modèle.
   */
  protected List<IFileChooserModelObserver> observers;

  /**
   * Créer un modèle de FileChooser.
   */
  public FileChooserModel()
  {
    this.observers = new ArrayList<>();
  }

  /**
   * Ajoute l'observeur en paramètre dans la liste des observeurs.
   * 
   * @param observer
   *          Observeur à ajouter.
   */
  public void addObserver(IFileChooserModelObserver observer)
  {
    if (observer != null)
    {
      this.observers.add(observer);
    }
  }

  /**
   * Retire l'observeur en paramètre de la liste des observeurs.
   * 
   * @param observer
   *          Observeur à enlever.
   */
  public void removeObserver(IFileChooserModelObserver observer)
  {
    if (observer != null)
    {
      this.observers.remove(observer);
    }
  }

  /**
   * Notifie les observeurs du changement de fichier actuel.
   * 
   */
  public void notifyObservers()
  {
    List<IFileChooserModelObserver> copyObservers = new ArrayList<>(this.observers);

    for (IFileChooserModelObserver observer : copyObservers)
    {
      observer.updateSelectedFile(file);
    }
  }

  public File getFile()
  {
    return file;
  }

  public void setFile(File file)
  {
    this.file = file;
    this.notifyObservers();
  }
}
