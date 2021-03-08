package com.iup.tp.twitup.ihm.widget.FileChooser;

import javax.swing.JFileChooser;

public class FileChooserComponent
{

  protected FileChooserController fileChooserController;

  protected FileChooserModel fileChooserModel;

  protected FileChooserView fileChooserView;

  /**
   * FileChooser de la librairie Java Swing.
   */
  protected JFileChooser jFileChooser;

  public FileChooserComponent()
  {
    this.jFileChooser = new JFileChooser();
    this.fileChooserModel = new FileChooserModel();
    this.fileChooserController = new FileChooserController(fileChooserModel);
    this.fileChooserView = new FileChooserView(jFileChooser, fileChooserController);

    this.fileChooserModel.addObserver(this.fileChooserView);

  }

  public void addObserverModel(IFileChooserModelObserver observer)
  {
    this.fileChooserModel.addObserver(observer);
  }

  public void removeObserverModel(IFileChooserModelObserver observer)
  {
    this.fileChooserModel.removeObserver(observer);
  }

  public FileChooserView getFileChooserView()
  {
    return fileChooserView;
  }

}
