package com.iup.tp.twitup.ihm.widget;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import com.iup.tp.twitup.configuration.ConstantLoader;

public class TwitButton extends JButton
{
  private static final long serialVersionUID = -7170404660947454990L;
  /**
   * Arrière-plan du bouton.
   */
  protected static final String KEY_BACKGROUND_BUTTON_COLOR = "KEY_BACKGROUND_BUTTON_COLOR";

  /**
   * Arrière-plan du bouton sur un survole de la souris.
   */
  protected static final String KEY_BACKGROUND_BUTTON_COLOR_HOVER = "KEY_BACKGROUND_BUTTON_COLOR_HOVER";

  protected static final String KEY_COLOR_HOME_RIGHT = "KEY_COLOR_HOME_RIGHT";

  /**
   * Constructeur.
   * 
   * @param title
   *          Titre du bouton.
   */
  public TwitButton(String title)
  {
    this.initComponent(title);
  }

  /**
   * Initialisation des composants.
   * 
   * @param title
   *          Titre du bouton.
   */
  protected void initComponent(String title)
  {
    this.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width / 10,
        Toolkit.getDefaultToolkit().getScreenSize().height / 20));
    this.setMinimumSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width / 10,
        Toolkit.getDefaultToolkit().getScreenSize().height / 20));
    this.setText(title);
    this.setContentAreaFilled(false);
    this.setBackground(ConstantLoader.getInstance().getColor(KEY_BACKGROUND_BUTTON_COLOR));
    this.setOpaque(true);
    this.addMouseListener(new MouseAdapter()
    {
      @Override
      public void mouseEntered(MouseEvent e)
      {
        backgroundHover();
      }

      @Override
      public void mouseExited(MouseEvent e)
      {
        backgroundNoHover();
      }
    });
    this.setBorder(new LineBorder(Color.black));

  }

  /**
   * Changement de l'arrière-plan pour un survole de la souris.
   */
  protected void backgroundHover()
  {
    this.setBackground(ConstantLoader.getInstance().getColor(KEY_BACKGROUND_BUTTON_COLOR_HOVER));
  }

  /**
   * Changement de l'arrière-plan.
   */
  protected void backgroundNoHover()
  {
    this.setBackground(ConstantLoader.getInstance().getColor(KEY_BACKGROUND_BUTTON_COLOR));
  }
}
