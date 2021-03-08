package com.iup.tp.twitup.ihm.hometwitt.vortex;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JPanel;

import com.iup.tp.twitup.configuration.ConstantLoader;
import com.iup.tp.twitup.ihm.ImagePanel;

public class VortexView extends JPanel
{

  /**
   * 
   */
  private static final long serialVersionUID = -3387142279141787718L;

  protected static final String KEY_IMAGE_VORTEX = "KEY_IMAGE_VORTEX";

  protected static final String KEY_IMAGE_PACMAN = "KEY_IMAGE_PACMAN";

  protected static final String KEY_BACKGROUND_BUTTON_HOME_COLOR = "KEY_BACKGROUND_BUTTON_HOME_COLOR";

  /**
   * Panneau du composant
   */
  protected JPanel contentPane;

  /**
   * Instanciation de la Vue.
   */
  public VortexView()
  {
    this.initContent();
  }

  /**
   * Mise en place de la vue pour le composant Vortex.
   */
  protected void initContent()
  {
    this.setLayout(new GridBagLayout());

    this.contentPane = new JPanel(new GridBagLayout());
    this.contentPane.setBackground(ConstantLoader.getInstance().getColor(KEY_BACKGROUND_BUTTON_HOME_COLOR));

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JPanel homePacman = new ImagePanel(ConstantLoader.getInstance().getImage(KEY_IMAGE_PACMAN),
        new Dimension(screenSize.width / 8, screenSize.height / 8));
    homePacman.setMinimumSize(new Dimension(screenSize.width / 8, screenSize.height / 8));

    this.contentPane.add(homePacman, new GridBagConstraints(0, 0, 1, 1, 0, 1, GridBagConstraints.CENTER,
        GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    this.add(this.contentPane, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
  }

}
