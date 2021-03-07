package com.iup.tp.twitup.ihm.hometwitt.bottomprofile;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JPanel;

import com.iup.tp.twitup.configuration.ConstantLoader;
import com.iup.tp.twitup.ihm.ImagePanel;

/**
 * VUe du composant sous le composant du profile.
 * 
 * @author EPE
 *
 */
public class BottomProfileView extends JPanel
{

  /**
   * 
   */
  private static final long serialVersionUID = -2689935204364641307L;

  /**
   * Panneau du composant
   */
  protected JPanel contentPane;

  protected static final String KEY_IMAGE_HOME = "KEY_IMAGE_HOME";

  protected static final String KEY_BACKGROUND_BUTTON_HOME_COLOR = "KEY_BACKGROUND_BUTTON_HOME_COLOR";

  /**
   * Instanciation de la Vue.
   */
  public BottomProfileView()
  {
    this.initContent();
  }

  /**
   * Mise en place de la vue pour le composant sous le Profile.
   */
  protected void initContent()
  {
    this.setLayout(new GridBagLayout());

    this.contentPane = new JPanel(new GridBagLayout());
    this.contentPane.setBackground(ConstantLoader.getInstance().getColor(KEY_BACKGROUND_BUTTON_HOME_COLOR));

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JPanel homeImage = new ImagePanel(ConstantLoader.getInstance().getImage(KEY_IMAGE_HOME),
        new Dimension(screenSize.width / 3, screenSize.height / 3));

    this.contentPane.add(homeImage, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
        GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    this.add(this.contentPane, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
  }

}
