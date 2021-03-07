package com.iup.tp.twitup.ihm.hometwitt.profile;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iup.tp.twitup.configuration.ConstantLoader;
import com.iup.tp.twitup.datamodel.User;

/**
 * La vue du composant Profile.
 * 
 * @author EPE
 *
 */
public class ProfileView extends JPanel
{

  private static final long serialVersionUID = -955525150669306640L;

  /**
   * Panneau du composant
   */
  protected JPanel contentPane;

  /**
   * Utilisateur connecté.
   */
  protected User user;

  /**
   * Label pour le nom d'utilisateur.
   */
  protected static final String KEY_NAME_LABEL = "KEY_NAME_LABEL";

  /**
   * Label pour le tag de l'utilisateur.
   */
  protected static final String KEY_TAG_LABEL = "KEY_TAG_LABEL";

  /**
   * Couleur de fond bleu
   */
  protected static final String KEY_COLOR_HOME_LEFT = "KEY_COLOR_HOME_LEFT";

  /**
   * Instanciation de la Vue.
   */
  public ProfileView(User user)
  {
    this.user = user;
    this.initContent();
  }

  /**
   * Mise en place de la vue pour le composant Profile.
   */
  protected void initContent()
  {
    this.setLayout(new GridBagLayout());

    this.contentPane = new JPanel(new GridBagLayout());

    // Affichage de l'avatar

    // Affichage du nom
    this.contentPane.add(this.createTagPanel(), new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    // Affichage du tag
    this.contentPane.add(this.createNamePanel(), new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    this.add(this.contentPane, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
  }

  protected JPanel createNamePanel()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_COLOR_HOME_LEFT));

    JLabel label = new JLabel(ConstantLoader.getInstance().getText(KEY_NAME_LABEL));
    label.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));

    JLabel nom = new JLabel(this.user.getName());
    label.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));

    panel.add(label, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH,
        new Insets(20, 20, 0, 30), 0, 0));
    panel.add(nom, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE,
        new Insets(20, 0, 0, 20), 0, 0));

    return panel;
  }

  protected JPanel createTagPanel()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_COLOR_HOME_LEFT));

    JLabel label = new JLabel(ConstantLoader.getInstance().getText(KEY_TAG_LABEL));
    label.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));

    JLabel nom = new JLabel(this.user.getUserTag());
    label.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));

    panel.add(label, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH,
        new Insets(20, 20, 0, 30), 0, 0));
    panel.add(nom, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE,
        new Insets(20, 0, 0, 20), 0, 0));

    return panel;
  }

}
