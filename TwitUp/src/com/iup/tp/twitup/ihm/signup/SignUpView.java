package com.iup.tp.twitup.ihm.signup;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.iup.tp.twitup.configuration.ConstantLoader;
import com.iup.tp.twitup.ihm.signup.observer.ISignUpViewObserver;
import com.iup.tp.twitup.ihm.widget.TwitButton;

public class SignUpView extends JPanel
{

  /**
   * 
   */
  private static final long serialVersionUID = -7596176480159761223L;

  protected static final String KEY_COLOR_HOME_LEFT = "KEY_COLOR_HOME_LEFT";

  protected static final String KEY_SIGNUP_NOM_LABEL = "KEY_SIGNUP_NOM_LABEL";

  protected static final String KEY_SIGNUP_TAG_LABEL = "KEY_SIGNUP_TAG_LABEL";

  protected static final String KEY_SIGNUP_UTILISATEUR_LABEL = "KEY_SIGNUP_UTILISATEUR_LABEL";

  protected static final String KEY_SIGNUP_MDP_LABEL = "KEY_SIGNUP_MDP_LABEL";

  protected static final String KEY_SIGNUP_TITLE_LABEL = "KEY_SIGNUP_TITLE_LABEL";

  protected static final String KEY_FORM_BACKGROUND_COLOR = "KEY_FORM_BACKGROUND_COLOR";

  protected static final String KEY_VALIDATE_BUTTON_TITLE = "KEY_VALIDATE_BUTTON_TITLE";

  protected static final String KEY_CANCEL_BUTTON_TITLE = "KEY_CANCEL_BUTTON_TITLE";

  protected static final String KEY_SIGNUP_AVATAR_LABEL = "KEY_SIGNUP_AVATAR_LABEL";

  protected JPanel contentPane;

  // Nom
  protected JLabel labelNom;

  protected JTextField textNom;

  // Tag
  protected JLabel labelTag;

  protected JTextField textTag;

  // Compte utilisateur
  protected JLabel labelCompteUtilisateur;

  protected JTextField textCompteUtilisateur;

  // Mdp
  protected JLabel labelMotDePasse;

  protected JTextField textMotDePasse;

//  // Avatar
//  protected JLabel labelAvatar;

  protected List<ISignUpViewObserver> observers;

  public SignUpView()
  {
    this.initContent();
    this.observers = new ArrayList<>();
  }

  public void initContent()
  {
    this.setLayout(new GridBagLayout());
    this.setBackground(ConstantLoader.getInstance().getColor(KEY_COLOR_HOME_LEFT));

    this.contentPane = new JPanel(new GridBagLayout());
    this.contentPane.setBackground(ConstantLoader.getInstance().getColor(KEY_COLOR_HOME_LEFT));

    this.contentPane.add(this.createPanelTitle(), new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 20, 20));
    this.contentPane.add(this.createFormPanel(), new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    this.contentPane.add(this.createButtons(), new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 100));

    this.add(this.contentPane);

  }

  public void addSignUpViewObserver(ISignUpViewObserver observer)
  {
    if (observer != null)
    {
      this.observers.add(observer);
    }
  }

  public void removeSignUpViewObserver(ISignUpViewObserver observer)
  {
    if (observer != null)
    {
      this.observers.remove(observer);
    }
  }

  public void notifyDoCancel()
  {
    for (ISignUpViewObserver currentObserver : observers)
    {
      currentObserver.notifyCancelButton();
    }
  }

  public void notifyDoValidate()
  {
    for (ISignUpViewObserver currentObserver : observers)
    {
      currentObserver.notifyValidateButton(this.textNom.getText(), this.textTag.getText(),
                                           this.textCompteUtilisateur.getText(), this.textMotDePasse.getText());
    }
  }

  protected JPanel createPanelTitle()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_FORM_BACKGROUND_COLOR));

    JLabel label = new JLabel(ConstantLoader.getInstance().getText(KEY_SIGNUP_TITLE_LABEL));
    label.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
    panel.add(label, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE,
        new Insets(0, 0, 0, 0), 0, 0));

    return panel;
  }

  protected JPanel createFormPanel()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_FORM_BACKGROUND_COLOR));

    panel.add(this.createPanelNom(), new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 10, 0), 0, 0));
    panel.add(this.createPanelTag(), new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 10, 0), 0, 0));
    panel.add(this.createPanelCompteUtilisateur(), new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 10, 0), 0, 0));
    panel.add(this.createPanelMotDePasse(), new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 10, 0), 0, 0));

    return panel;
  }

  protected JPanel createPanelNom()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_FORM_BACKGROUND_COLOR));

    this.labelNom = new JLabel(ConstantLoader.getInstance().getText(KEY_SIGNUP_NOM_LABEL));
    this.labelNom.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
    this.textNom = new JTextField();
    this.textNom.setPreferredSize(new Dimension(200, 24));

    panel.add(this.labelNom, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH,
        new Insets(20, 20, 0, 30), 0, 0));
    panel.add(this.textNom, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE,
        new Insets(20, 0, 0, 20), 0, 0));

    return panel;
  }

  protected JPanel createPanelTag()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_FORM_BACKGROUND_COLOR));

    this.labelTag = new JLabel(ConstantLoader.getInstance().getText(KEY_SIGNUP_TAG_LABEL));
    this.labelTag.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
    this.textTag = new JTextField();
    this.textTag.setPreferredSize(new Dimension(200, 24));

    panel.add(this.labelTag, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH,
        new Insets(20, 20, 0, 30), 0, 0));
    panel.add(this.textTag, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE,
        new Insets(20, 0, 0, 20), 0, 0));

    return panel;
  }

  protected JPanel createPanelCompteUtilisateur()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_FORM_BACKGROUND_COLOR));

    this.labelCompteUtilisateur = new JLabel(ConstantLoader.getInstance().getText(KEY_SIGNUP_UTILISATEUR_LABEL));
    this.labelCompteUtilisateur.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
    this.textCompteUtilisateur = new JTextField();
    this.textCompteUtilisateur.setPreferredSize(new Dimension(200, 24));

    panel.add(this.labelCompteUtilisateur, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.WEST,
        GridBagConstraints.BOTH, new Insets(20, 20, 0, 30), 0, 0));
    panel.add(this.textCompteUtilisateur, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.EAST,
        GridBagConstraints.NONE, new Insets(20, 0, 0, 20), 0, 0));

    return panel;
  }

  protected JPanel createPanelMotDePasse()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_FORM_BACKGROUND_COLOR));

    this.labelMotDePasse = new JLabel(ConstantLoader.getInstance().getText(KEY_SIGNUP_MDP_LABEL));
    this.labelMotDePasse.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
    this.textMotDePasse = new JTextField();
    this.textMotDePasse.setPreferredSize(new Dimension(200, 24));

    panel.add(this.labelMotDePasse, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.WEST,
        GridBagConstraints.BOTH, new Insets(20, 20, 0, 30), 0, 0));
    panel.add(this.textMotDePasse, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.EAST,
        GridBagConstraints.NONE, new Insets(20, 0, 0, 20), 0, 0));

    return panel;
  }

//  protected JPanel createPanelAvatar()
//  {
//    JPanel panel = new JPanel(new GridBagLayout());
//    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_FORM_BACKGROUND_COLOR));
//
//    this.labelAvatar = new JLabel(ConstantLoader.getInstance().getText(KEY_SIGNUP_AVATAR_LABEL));
//    this.labelAvatar.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
//    panel.add(this.labelAvatar, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.WEST,
//        GridBagConstraints.BOTH, new Insets(20, 20, 0, 30), 0, 0));
//    panel.add(avatarCombobox, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE,
//        new Insets(20, 0, 0, 20), 0, 0));
//
//    return panel;
//  }

//  /**
//   * Initialise les FileChooser.
//   */
//  protected void initFileChoosers()
//  {
//    this.localFileChooser = new FileChooserComponent();
//    this.localFileChooser.addObserver(this.addCorrespondenceFileChooserManager);
//
//    this.addCorrespondenceFileChooserManager.initManager(this.localFileChooser, this.distantFileChooser);
//  }

  /**
   * Création du bouton de validation
   * 
   * @return
   */
  protected JPanel createButtons()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_FORM_BACKGROUND_COLOR));

    TwitButton buttonValidate = new TwitButton(ConstantLoader.getInstance().getText(KEY_VALIDATE_BUTTON_TITLE));
    buttonValidate.addActionListener(new ActionListener()
    {

      @Override
      public void actionPerformed(ActionEvent e)
      {
        SignUpView.this.notifyDoValidate();

      }
    });

    TwitButton buttonCancel = new TwitButton(ConstantLoader.getInstance().getText(KEY_CANCEL_BUTTON_TITLE));
    buttonCancel.addActionListener(new ActionListener()
    {

      @Override
      public void actionPerformed(ActionEvent e)
      {
        SignUpView.this.notifyDoCancel();

      }
    });

    panel.add(buttonValidate, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 10, 40, 10), 0, 0));
    panel.add(buttonCancel, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 10, 40, 10), 0, 0));

    return panel;
  }

  /**
   * Affiche un popup d'avertissement indiquant un problème lors de la tentative d'ajout d'un utilisateur.
   * 
   * @param title
   *          Titre du message d'avertissement.
   * @param description
   *          Description de l'avertissement.
   */
  public void showWarningMessage(String title, String description)
  {
    JOptionPane.showMessageDialog(null, description, title, JOptionPane.WARNING_MESSAGE);
  }

}
