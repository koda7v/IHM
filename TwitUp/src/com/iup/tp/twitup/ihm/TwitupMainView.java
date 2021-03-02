package com.iup.tp.twitup.ihm;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.iup.tp.twitup.configuration.Constant;
import com.iup.tp.twitup.configuration.ConstantLoader;

/**
 * Classe de la vue principale de l'application.
 */
public class TwitupMainView extends JFrame
{

  /**
   * 
   */
  private static final long serialVersionUID = 6552375517600057708L;

  /**
   * Chemin du dossier d'échange.
   */
  protected String directoryPath;

  /**
   * Panneau de contenu principal de la fenêtre.
   */
  protected JPanel contentPane;

  public TwitupMainView()
  {
    this.initGUI();
  }

  protected void initGUI()
  {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    ImageIcon logo = new ImageIcon(getClass().getClassLoader()
        .getResource(ConstantLoader.getInstance().getText(Constant.KEY_IMAGE_APROPOS_LITTLE)));
    this.setIconImage(logo.getImage());
    this.setTitle(ConstantLoader.getInstance().getText(Constant.KEY_APPLICATION_TITLE));
    this.setSize(screenSize.width * 3 / 4, screenSize.height * 3 / 4);

    this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (this.getSize().width / 2),
                     (Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (this.getSize().height / 2));

    this.setJMenuBar(this.createMenuBar());
    contentPane = new JPanel(new GridBagLayout());
    this.setContentPane(contentPane);
    this.chooser();
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }

  protected JMenuBar createMenuBar()
  {
    JMenuBar menu = new JMenuBar();

    JMenu fileMenu = new JMenu(ConstantLoader.getInstance().getText(Constant.KEY_MENU_FILE_TITLE));
    JMenu fileQuestion = new JMenu(ConstantLoader.getInstance().getText(Constant.KEY_MENU_APROPOS_TITLE));

    // Item du menu pour l'ajout de correspondance.
    JMenuItem itemQuitter = new JMenuItem(ConstantLoader.getInstance().getText(Constant.KEY_MENU_ITEM_QUITTER_TITLE));
    itemQuitter.setToolTipText(ConstantLoader.getInstance().getText(Constant.KEY_MENU_ITEM_QUITTER_TOOLTIP));
    ImageIcon logoQuitter = new ImageIcon(
        getClass().getClassLoader().getResource(ConstantLoader.getInstance().getText(Constant.KEY_IMAGE_EXIT)));
    itemQuitter.setIcon(logoQuitter);
    itemQuitter.addActionListener(new ActionListener()
    {

      @Override
      public void actionPerformed(ActionEvent e)
      {

        System.exit(0);

      }
    });

    JMenuItem itemQuestion = new JMenuItem(ConstantLoader.getInstance().getText(Constant.KEY_MENU_ITEM_APROPOS_TITLE));
    ImageIcon logoQuestion = new ImageIcon(getClass().getClassLoader()
        .getResource(ConstantLoader.getInstance().getText(Constant.KEY_IMAGE_APROPOS_LITTLE)));
    itemQuestion.setIcon(logoQuestion);
    itemQuestion.setToolTipText(ConstantLoader.getInstance().getText(Constant.KEY_MENU_ITEM_APROPOS_TOOLTIP));

    JPanel panel = new JPanel();
    panel.setSize(new Dimension(400, 64));
    panel.setLayout(null);

    JLabel label = new JLabel(ConstantLoader.getInstance().getText(Constant.KEY_MENU_ITEM_PANE_MESSAGE1));
    label.setBounds(0, 0, 120, 32);
    label.setHorizontalAlignment(SwingConstants.CENTER);

    JLabel label2 = new JLabel(ConstantLoader.getInstance().getText(Constant.KEY_MENU_ITEM_PANE_MESSAGE2));
    label2.setBounds(0, 0, 200, 64);
    label2.setHorizontalAlignment(SwingConstants.LEFT);

    panel.add(label);
    panel.add(label2);

    itemQuestion.addActionListener(new ActionListener()
    {

      @Override
      public void actionPerformed(ActionEvent e)
      {
        ImageIcon icon = new ImageIcon(getClass().getClassLoader()
            .getResource(ConstantLoader.getInstance().getText(Constant.KEY_IMAGE_APROPOS_BIG)));
        JOptionPane.showMessageDialog(null, panel,
                                      ConstantLoader.getInstance().getText(Constant.KEY_MENU_ITEM_PANE_TITLE),
                                      JOptionPane.INFORMATION_MESSAGE, icon);

      }
    });

    fileMenu.add(itemQuitter);
    fileQuestion.add(itemQuestion);

    menu.add(fileMenu);
    menu.add(fileQuestion);
    return menu;

  }

  public JFileChooser chooser()
  {
    JFileChooser chooser = new JFileChooser();
    chooser.setDialogTitle(ConstantLoader.getInstance().getText(Constant.KEY_FILECHOOSER_TITLE));
    chooser.setAcceptAllFileFilterUsed(true);
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    int returnVal = chooser.showOpenDialog(this);
    if (returnVal == JFileChooser.APPROVE_OPTION)
    {
      this.directoryPath = chooser.getSelectedFile().getPath();
    }

    return chooser;
  }

  public void showView()
  {
    this.setVisible(true);
  }

  /**
   * Supprime l'ancien contenu de la fenêtre et affiche celui envoyé en paramètre.
   */
  public void showPanel(JPanel panel)
  {
    contentPane.removeAll();
    contentPane.add(panel, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH,
        new Insets(0, 0, 0, 0), 0, 0));

    contentPane.repaint();
    contentPane.revalidate();
  }

  /**
   * Actualise le composant.
   */
  public void componentRepaint(JPanel panel)
  {
    this.setJMenuBar(this.createMenuBar());
    this.showPanel(panel);
    this.revalidate();
    this.repaint();
  }

  public String getDirectoryPath()
  {
    return directoryPath;
  }

  public void setDirectoryPath(String directoryPath)
  {
    this.directoryPath = directoryPath;
  }

}
