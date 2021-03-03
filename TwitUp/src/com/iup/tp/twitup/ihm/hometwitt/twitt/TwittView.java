package com.iup.tp.twitup.ihm.hometwitt.twitt;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.iup.tp.twitup.configuration.ConstantLoader;
import com.iup.tp.twitup.datamodel.Twit;

public class TwittView extends JPanel
{

  /**
   * 
   */
  private static final long serialVersionUID = -4271383624255516534L;

  /**
   * Panneau principal de la vue.
   */
  protected JPanel contentPane;

  /**
   * Texte d'un twitt
   */
  private JTextArea textLabel;

  /**
   * Couleur de fond bleu
   */
  protected static final String KEY_COLOR_HOME_LEFT = "KEY_COLOR_HOME_LEFT";

  /**
   * Couleur de fond blanche
   */
  protected static final String KEY_COLOR_HOME_RIGHT = "KEY_COLOR_HOME_RIGHT";

  /**
   * Model d'un twitt
   */
  protected Twit model;

  /**
   * Nom du user
   */
  protected JLabel nameLabel;

  /**
   * Date du twitt
   */
  private JLabel dateLabel;

  /**
   * Pseudo du user
   */
  private JLabel pseudoLabel;

  public TwittView(Twit model)
  {
    this.model = model;
  }

  /**
   * Initialise le composant graphique, création du JScrollPane contenant la liste des twitts.
   * 
   * @param dimension
   *          Dimension du composant.
   */
  protected void initContent()
  {
    this.setLayout(new GridBagLayout());
    this.setBackground(ConstantLoader.getInstance().getColor(KEY_COLOR_HOME_LEFT));

    this.contentPane = new JPanel(new GridBagLayout());
    this.setBackground(ConstantLoader.getInstance().getColor(KEY_COLOR_HOME_LEFT));

    contentPane.add(text(), new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 0, 0, 0), 20, 20));

    this.add(contentPane);
  }

  /**
   * Récupération du texte
   * 
   * @return
   */
  protected JPanel twittText()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_COLOR_HOME_LEFT));

    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    this.textLabel.setPreferredSize(new Dimension(screensize.width / 5, screensize.height / 10));

    panel.add(userName(), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 0, 50, 0), 0, 0));
    panel.add(text(), new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 0, 50, 0), 0, 0));
    panel.add(dateTwitt(), new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 0, 50, 0), 0, 0));

    return panel;
  }

  /**
   * Récupération du texte
   * 
   * @return
   */
  protected JPanel text()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_COLOR_HOME_RIGHT));

    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    this.textLabel = new JTextArea(ConstantLoader.getInstance().getText(model.getText()));
    this.textLabel.setPreferredSize(new Dimension(screensize.width / 5, screensize.height / 10));
    this.textLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));

    panel.add(textLabel, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 0, 50, 0), 0, 0));

    return panel;
  }

  /**
   * Récupération du nom du user
   * 
   * @return
   */
  protected JPanel userName()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_COLOR_HOME_RIGHT));

    this.nameLabel = new JLabel(ConstantLoader.getInstance().getText(model.getTwiter().getName()));
    this.nameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
    this.pseudoLabel = new JLabel(ConstantLoader.getInstance().getText(model.getTwiter().getUserTag()));
    this.pseudoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));

    panel.add(textLabel, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 0, 50, 0), 0, 0));
    panel.add(pseudoLabel, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 0, 50, 0), 0, 0));

    return panel;
  }

  /**
   * Récupération de la date du twitt
   * 
   * @return
   */
  protected JPanel dateTwitt()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_COLOR_HOME_RIGHT));

    DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
    Date date = new Date(model.getEmissionDate() * 1000);

    this.dateLabel = new JLabel(ConstantLoader.getInstance().getText(shortDateFormat.format(date)));
    this.dateLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));

    panel.add(dateLabel, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 0, 50, 0), 0, 0));

    return panel;
  }

}
