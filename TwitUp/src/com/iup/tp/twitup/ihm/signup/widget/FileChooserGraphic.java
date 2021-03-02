package com.iup.tp.twitup.ihm.signup.widget;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iup.tp.twitup.configuration.ConstantLoader;
import com.iup.tp.twitup.ihm.widget.TwitButton;
import com.iup.tp.twitup.utils.FileUtils;

/**
 * Composant graphique permettant la sélection d'un fichier/répertoire dans l'explorateur de fichiers. Un label affiche
 * le chemin sélectionné.
 * 
 * @author Edispa2020
 *
 */
public class FileChooserGraphic extends JPanel implements IFileChooserModelObserver
{

  private static final long serialVersionUID = -8328101182107218988L;

  /**
   * Clé pour l'action de parcourir l'explorateur de fichiers.
   */
  public static final String KEY_ACTION_BROWSE_LABEL = "KEY_ACTION_BROWSE_LABEL";

  /**
   * Clé du message lorsqu'aucun fichier n'est sélectionné.
   */
  public static final String KEY_BROWSE_NO_SELECTED_FILE_LABEL = "KEY_BROWSE_NO_SELECTED_FILE_LABEL";

  /**
   * Label indiquant le chemin du fichier/répertoire sélectionné. Il indique également si aucun chemin n'a été
   * sélectionné.
   */
  protected JLabel selectedPath;

  /**
   * FileChooser de la librairie Java Swing.
   */
  protected JFileChooser fileChooser;

  /**
   * Contrôleur du composant.
   */
  protected FileChooserController fileChooserController;

  /**
   * Créer un nouveau composant permettant la sélection d'un fichier/répertoire dans l'explorateur de fichiers.
   * 
   * @param fileChooserController
   *          Contrôleur du composant.
   */
  public FileChooserGraphic(JFileChooser fileChooser, FileChooserController fileChooserController)
  {
    this.fileChooser = fileChooser;
    this.fileChooserController = fileChooserController;

    this.initComponent();
    this.updateSelectedFile(null);
  }

  /**
   * Initialise le composant. Créer le bouton affichant le fileChooser et le label affichant le chemin sélectionné.
   */
  protected void initComponent()
  {
    this.setLayout(new GridBagLayout());
    this.setOpaque(false);

    JPanel contentPane = new JPanel(new GridBagLayout());
    contentPane.setOpaque(false);

    TwitButton browseButton = new TwitButton(ConstantLoader.getInstance().getText(KEY_ACTION_BROWSE_LABEL));
    browseButton.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width / 25,
        Toolkit.getDefaultToolkit().getScreenSize().height / 40));
    browseButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        onClick();
      }
    });
    contentPane.add(browseButton, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
        GridBagConstraints.NONE, new Insets(0, 0, 0, 10), 0, 0));

    selectedPath = new JLabel();
    selectedPath.setOpaque(false);
    contentPane.add(selectedPath, new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.WEST,
        GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

    this.add(contentPane, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 0, 0, 0), 0, 0));
  }

  /**
   * Méthode lancée suite au clic du bouton "parcourir". Lance l'explorateur de fichiers Java.
   */
  protected void onClick()
  {
    int response = fileChooser.showOpenDialog(null);

    if (response == JFileChooser.APPROVE_OPTION)
    {
      fileChooserController.click(fileChooser.getSelectedFile());
    }
  }

  @Override
  public void updateSelectedFile(File file)
  {
    if (file == null)
    {
      selectedPath.setText(ConstantLoader.getInstance().getText(KEY_BROWSE_NO_SELECTED_FILE_LABEL));
    }
    else
    {
      selectedPath.setText(FileUtils.getShortPath(file));
    }
  }
}
