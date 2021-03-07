package com.iup.tp.twitup.ihm.hometwitt.creationtwitt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.iup.tp.twitup.configuration.ConstantLoader;
import com.iup.tp.twitup.ihm.hometwitt.creationtwitt.observer.ICreationTwittViewObserver;
import com.iup.tp.twitup.ihm.widget.TwitButton;

public class CreationTwittView extends JPanel
{

  /**
   * 
   */
  private static final long serialVersionUID = 340605026157171684L;

  /**
   * Panneau du composant
   */
  protected JPanel contentPane;

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
   * Titre de la création d'un twitt
   */
  protected static final String KEY_CREATE_TWITT_TITLE_LABEL = "KEY_CREATE_TWITT_TITLE_LABEL";

  /**
   * Nom du label du bouton de validation
   */
  protected static final String KEY_VALIDATE_BUTTON_TITLE = "KEY_VALIDATE_BUTTON_TITLE";

  /**
   * Nom du label du bouton d'annulation
   */
  protected static final String KEY_CANCEL_BUTTON_TITLE = "KEY_CANCEL_BUTTON_TITLE";

  protected JPanel contentPanel;

  protected JTextArea areaTwitt;

  protected List<ICreationTwittViewObserver> observers;

  public CreationTwittView()
  {
    this.observers = new ArrayList<>();
    this.initContent();
  }

  /**
   * Agencement des JPanels de la vue
   */
  protected void initContent()
  {
    this.setLayout(new GridBagLayout());

    this.contentPane = new JPanel(new GridBagLayout());
    this.contentPane.setBorder(BorderFactory.createLineBorder(Color.black, 2));

    this.contentPane.add(this.createPanelTitle(), new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 10, 10));

    this.contentPane.add(this.createPanelTwitt(), new GridBagConstraints(0, 1, 1, 2, 0, 0, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    this.contentPane.add(this.createPanelButtons(), new GridBagConstraints(0, 3, 0, 0, 0, 0, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 10, 10));

    this.add(this.contentPane, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
  }

  public void addCreationViewObserver(ICreationTwittViewObserver observer)
  {
    if (observer != null)
    {
      this.observers.add(observer);
    }
  }

  public void removeCreationViewObserver(ICreationTwittViewObserver observer)
  {
    if (observer != null)
    {
      this.observers.remove(observer);
    }
  }

  public void notificationValidate()
  {
    for (ICreationTwittViewObserver currentObserver : observers)
    {
      currentObserver.notificationCreationValidate(this.areaTwitt.getText());
    }
    this.cleanTwitt();
  }

  public void notificatioCancel()
  {
    this.cleanTwitt();
  }

  protected void cleanTwitt()
  {
    this.areaTwitt.selectAll();
    this.areaTwitt.replaceSelection("");
  }

  protected JPanel createPanelTitle()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_COLOR_HOME_LEFT));

    JLabel label = new JLabel(ConstantLoader.getInstance().getText(KEY_CREATE_TWITT_TITLE_LABEL));
    label.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
    panel.add(label, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE,
        new Insets(0, 0, 0, 0), 0, 0));

    return panel;
  }

  protected JPanel createPanelTwitt()
  {
    JPanel panel = new JPanel(new GridBagLayout());

    this.areaTwitt = new JTextArea();
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    this.areaTwitt.setPreferredSize(new Dimension(screensize.width / 3, screensize.height / 10));
    this.areaTwitt.setLineWrap(true);
    panel.add(this.areaTwitt, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 5, 5));
    return panel;
  }

  /**
   * Création du bouton de validation
   * 
   * @return
   */
  protected JPanel createPanelButtons()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_COLOR_HOME_LEFT));

    TwitButton buttonValidate = new TwitButton(ConstantLoader.getInstance().getText(KEY_VALIDATE_BUTTON_TITLE));
    buttonValidate.addActionListener(new ActionListener()
    {

      @Override
      public void actionPerformed(ActionEvent e)
      {
        CreationTwittView.this.notificationValidate();

      }
    });

    TwitButton buttonCancel = new TwitButton(ConstantLoader.getInstance().getText(KEY_CANCEL_BUTTON_TITLE));
    buttonCancel.addActionListener(new ActionListener()
    {

      @Override
      public void actionPerformed(ActionEvent e)
      {
        CreationTwittView.this.notificatioCancel();

      }
    });

    panel.add(buttonValidate, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 10, 10, 10), 0, 0));
    panel.add(buttonCancel, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 10, 10, 10), 0, 0));

    return panel;
  }

}
