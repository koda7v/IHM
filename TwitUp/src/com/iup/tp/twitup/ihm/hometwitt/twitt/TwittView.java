package com.iup.tp.twitup.ihm.hometwitt.twitt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
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

  /**
   * Model d'un twitt
   */
  protected Twit model;

  /**
   * Couleur de fond bleu
   */
  protected static final String KEY_COLOR_HOME_LEFT = "KEY_COLOR_HOME_LEFT";

  /**
   * Couleur de fond blanche
   */
  protected static final String KEY_COLOR_HOME_RIGHT = "KEY_COLOR_HOME_RIGHT";

  public TwittView(Twit model)
  {
    this.model = model;
    this.initContent();
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
//    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();

    this.contentPane = new JPanel(new GridBagLayout());
    this.contentPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
//    this.contentPane.setPreferredSize(new Dimension(screensize.width / 5, screensize.height / 10));

    contentPane.add(userName(), new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    contentPane.add(twittText(), new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    contentPane.add(dateTwitt(), new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    this.add(contentPane, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 0, 0, 0), 0, 0));
  }

  /**
   * Récupération du texte
   * 
   * @return
   */
  protected JPanel twittText()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_COLOR_HOME_RIGHT));
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    this.textLabel = new JTextArea(model.getText());
    this.textLabel.setPreferredSize(new Dimension(screensize.width / 3, screensize.height / 15));
    this.textLabel.setMinimumSize(new Dimension(screensize.width / 3, screensize.height / 15));
    this.textLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
    this.textLabel.setEditable(false);
    this.textLabel.setLineWrap(true);
//    this.textLabel.setBorder(BorderFactory.createLineBorder(Color.yellow));

    panel.add(textLabel, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 0, 0, 0), 0, 0));

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

    this.nameLabel = new JLabel(model.getTwiter().getName());
    this.nameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
    this.pseudoLabel = new JLabel(model.getTwiter().getUserTag());
    this.pseudoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));

    panel.add(nameLabel, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH,
        new Insets(0, 0, 0, 0), 0, 0));
    panel.add(pseudoLabel, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH,
        new Insets(0, 0, 0, 0), 0, 0));

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
    Date date = new Date(model.getEmissionDate());

    this.dateLabel = new JLabel(shortDateFormat.format(date));
    this.dateLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));

    panel.add(dateLabel, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 0, 0, 0), 0, 0));

    return panel;
  }

}
