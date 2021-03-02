package com.iup.tp.twitup.ihm.signup.widget;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 * Permet la sélection de fichiers dans le système à partir du composant Swing JFileChooser.
 * 
 * @author Edispa2020
 *
 */
public class FileChooserComponent implements Serializable, IFileChooserModelObserver
{

  private static final long serialVersionUID = 1479978597552034202L;

  /**
   * Modèle du FileChooser.
   */
  protected FileChooserModel model;

  /**
   * Contrôleur du FileChooser.
   */
  protected FileChooserController controller;

  /**
   * Vue du FileChooser.
   */
  protected FileChooserGraphic view;

  /**
   * FileChooser de la librairie Java Swing.
   */
  protected JFileChooser jFileChooser;

  /**
   * Liste des observeurs du contrôleur.
   */
  protected List<IFileChooserComponentObserver> observers;

  /**
   * Créer le composant FileChooser.
   */
  public FileChooserComponent()
  {
    this.model = new FileChooserModel();
    this.controller = new FileChooserController(model);
    this.jFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    this.view = new FileChooserGraphic(jFileChooser, controller);
    this.observers = new ArrayList<>();

    model.addObserver(view);
    model.addObserver(this);
  }

  /**
   * Ajoute l'observeur en paramètre dans la liste des observeurs.
   * 
   * @param observer
   *          Observeur à ajouter.
   */
  public void addObserver(IFileChooserComponentObserver observer)
  {
    if (observer != null)
    {
      this.observers.add(observer);
    }
  }

  /**
   * Enlève l'observeur en paramètre de la liste des observeurs.
   * 
   * @param observer
   *          Observeur à enlever.
   */
  public void removeObserver(IFileChooserComponentObserver observer)
  {
    if (observer != null)
    {
      this.observers.remove(observer);
    }
  }

  /**
   * Notifie les observeurs du changement de fichier sélectionné.
   * 
   * @param addCorrespondanceModel
   *          Modèle du FileChooser.
   */
  public void notifyFileChanged()
  {
    List<IFileChooserComponentObserver> copyObservers = new ArrayList<>(this.observers);

    for (IFileChooserComponentObserver observer : copyObservers)
    {
      observer.changeFile(this);
    }
  }

  /**
   * Permet d'enlever les observeurs de la liste.
   */
  public void dispose()
  {
    model.removeObserver(view);
    model.removeObserver(this);

  }

  @Override
  public void updateSelectedFile(File file)
  {
    this.notifyFileChanged();
  }

  public FileChooserModel getModel()
  {
    return model;
  }

  public FileChooserController getController()
  {
    return controller;
  }

  public FileChooserGraphic getView()
  {
    return view;
  }
}
