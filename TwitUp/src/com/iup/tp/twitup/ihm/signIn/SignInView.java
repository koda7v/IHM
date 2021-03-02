package com.iup.tp.twitup.ihm.signIn;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.iup.tp.twitup.configuration.ConstantLoader;
import com.iup.tp.twitup.ihm.widget.TwitButton;

public class SignInView extends JPanel
{

  /**
   * 
   */
  private static final long serialVersionUID = -7215419364069368598L;

  /**
   * Panneau du composant
   */
  protected JPanel contentPane;

  /**
   * Champs à renseigner pour le pseudo
   */
  protected JTextField textFieldPseudo;

  /**
   * Champs à renseigner pour le mot de passe
   */
  protected JTextField textFieldMDP;

  /**
   * Label du pseudo
   */
  protected JLabel labelPseudo;

  /**
   * Label du mot de passe
   */
  protected JLabel labelPassword;

  /**
   * Titre de la page
   */
  protected JLabel titleLabel;

  /**
   * Couleur de fond bleu
   */
  protected static final String KEY_COLOR_HOME_LEFT = "KEY_COLOR_HOME_LEFT";

  /**
   * Couleur de fond blanche
   */
  protected static final String KEY_COLOR_HOME_RIGHT = "KEY_COLOR_HOME_RIGHT";

  /**
   * Nom de l'intérieur du boutton Valider
   */
  protected static final String KEY_VALIDATE_BUTTON_TITLE = "KEY_VALIDATE_BUTTON_TITLE";

  /**
   * Nom de l'intérieur du bouton Annuler
   */
  protected static final String KEY_CANCEL_BUTTON_TITLE = "KEY_CANCEL_BUTTON_TITLE";

  /**
   * Label du pseudo
   */
  protected static final String KEY_TAG_BUTTON_TITLE = "KEY_TAG_BUTTON_TITLE";

  /**
   * Label du mot de passe
   */
  protected static final String KEY_PASSWORD_BUTTON_TITLE = "KEY_PASSWORD_BUTTON_TITLE";

  /**
   * Titre de la page
   */
  protected static final String KEY_SIGNIN_BUTTON_TITLE = "KEY_SIGNIN_BUTTON_TITLE";

  public SignInView()
  {
    this.initComponent();
  }

  /**
   * Agencement des JPanels de la vue
   */
  protected void initComponent()
  {
    this.setLayout(new GridBagLayout());

    this.contentPane = new JPanel(new GridBagLayout());
    this.setBackground(ConstantLoader.getInstance().getColor(KEY_COLOR_HOME_LEFT));

    contentPane.add(title(), new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    contentPane.add(createPanelFormSignIn(), new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    contentPane.add(createButtons(), new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 100));

    this.add(contentPane);

    this.revalidate();
    this.repaint();
  }

  /**
   * Création du formulaire de connexion
   * 
   * @return
   */
  protected JPanel createPanelFormSignIn()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_COLOR_HOME_RIGHT));

    labelPseudo = new JLabel(ConstantLoader.getInstance().getText(KEY_TAG_BUTTON_TITLE));
    labelPseudo.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));

    textFieldPseudo = new JTextField(25);

    labelPassword = new JLabel(ConstantLoader.getInstance().getText(KEY_PASSWORD_BUTTON_TITLE));
    labelPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));

    textFieldMDP = new JTextField(25);

    panel.add(labelPseudo, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(20, 20, 0, 30), 0, 0));
    panel.add(textFieldPseudo, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(20, 0, 0, 20), 0, 0));
    panel.add(labelPassword, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(20, 20, 0, 30), 0, 0));
    panel.add(textFieldMDP, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(20, 0, 0, 20), 0, 0));

    return panel;
  }

  /**
   * Création du bouton de validation
   * 
   * @return
   */
  protected JPanel createButtons()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_COLOR_HOME_RIGHT));

    TwitButton buttonValidate = new TwitButton(ConstantLoader.getInstance().getText(KEY_VALIDATE_BUTTON_TITLE));
    TwitButton buttonCancel = new TwitButton(ConstantLoader.getInstance().getText(KEY_CANCEL_BUTTON_TITLE));

    panel.add(buttonValidate, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 10, 40, 10), 0, 0));
    panel.add(buttonCancel, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 10, 40, 10), 0, 0));

    return panel;
  }

  protected JPanel title()
  {

    JPanel panel = new JPanel(new GridBagLayout());

    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_COLOR_HOME_RIGHT));
    titleLabel = new JLabel(ConstantLoader.getInstance().getText(KEY_SIGNIN_BUTTON_TITLE));
    titleLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));

    panel.add(titleLabel, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 0, 50, 0), 0, 0));

    return panel;
  }

}
