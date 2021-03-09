package com.iup.tp.twitup.ihm.hometwitt.follow;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import com.iup.tp.twitup.configuration.ConstantLoader;
import com.iup.tp.twitup.ihm.ImagePanel;
import com.iup.tp.twitup.ihm.hometwitt.follow.observers.ISwitchFollowButtonModelObserver;

public class SwitchFollowButtonView extends JPanel implements ISwitchFollowButtonModelObserver
{

  private static final long serialVersionUID = 8139667325876800153L;

  /**
   * Clé pour l'icône switch ON.
   */
  protected static final String KEY_WIDGET_FOLLOW_IMAGE = "KEY_WIDGET_FOLLOW_IMAGE";

  /**
   * Clé pour l'icône switch OFF.
   */
  protected static final String KEY_WIDGET_UNFOLLOW_IMAGE = "KEY_WIDGET_UNFOLLOW_IMAGE";

  /**
   * Clé pour le tooltip ON par défaut.
   */
  protected static final String KEY_WIDGET_SWITCH_FOLLOW_TOOLTIP = "KEY_WIDGET_SWITCH_FOLLOW_TOOLTIP";

  /**
   * Clé pour le tooltip OFF par défaut.
   */
  protected static final String KEY_WIDGET_SWITCH_UNFOLLOW_TOOLTIP = "KEY_WIDGET_SWITCH_UNFOLLOW_TOOLTIP";

  /**
   * Image affichée par le composant.
   */
  protected Image switchButtonImage;

  /**
   * Tooltip affiché par le composant lorsqu'il est en position ON.
   */
  protected String tooltipON;

  /**
   * Tooltip affiché par le composant lorsqu'il est en position OFF.
   */
  protected String tooltipOFF;

  /**
   * Modèle du switch.
   */
  protected SwitchFollowButtonModel followSwitchButtonModel;

  /**
   * Contrôleur du switch.
   */
  protected SwitchFollowButtonController followSwitchButtonController;

  /**
   * Dimension du switch.
   */
  protected Dimension dimension;

  /**
   * Créer un composant graphique pour le bouton switch follow.
   * 
   * @param controller
   *          Contrôleur du switch.
   * @param model
   *          Modèle du switch.
   * @param dimension
   *          Dimension du switch graphique.
   */
  public SwitchFollowButtonView(SwitchFollowButtonController followSwitchButtonController,
                                SwitchFollowButtonModel followSwitchButtonModel, Dimension dimension)
  {
    // this.tooltipON = ConstantLoader.getInstance().getText(KEY_WIDGET_SWITCH_FOLLOW_TOOLTIP);
    // this.tooltipOFF = ConstantLoader.getInstance().getText(KEY_WIDGET_SWITCH_UNFOLLOW_TOOLTIP);
    this.followSwitchButtonController = followSwitchButtonController;
    this.followSwitchButtonModel = followSwitchButtonModel;
    this.dimension = dimension;
    this.initComponent();
    this.updateFollowActivation(followSwitchButtonModel.isActivated());
  }

  @Override
  public void updateFollowActivation(boolean state)
  {
    // String tooltip = "";

    if (state)
    {
      switchButtonImage = ConstantLoader.getInstance().getImage(KEY_WIDGET_FOLLOW_IMAGE);
      System.out.println("abonné");
      // tooltip = tooltipON;
    }
    else
    {
      switchButtonImage = ConstantLoader.getInstance().getImage(KEY_WIDGET_UNFOLLOW_IMAGE);
      System.out.println("désabonné");
      // tooltip = tooltipOFF;
    }

    this.updateDisplay(switchButtonImage);
    // this.setToolTipText(tooltip);
  }

  /**
   * Met en place l'information lors que le bouton est en mode activé.
   * 
   * @param tooltipON
   */
//  public void setTooltipON(String tooltipON)
//  {
//    this.tooltipON = tooltipON;
//    this.updateFollowActivation(followSwitchButtonModel.isActivated());
//  }
//
//  /**
//   * Met en place l'information lorsque le bouton est en mode désactivé.
//   * 
//   * @param tooltipOFF
//   */
//  public void setTooltipOFF(String tooltipOFF)
//  {
//    this.tooltipOFF = tooltipOFF;
//    this.updateFollowActivation(followSwitchButtonModel.isActivated());
//  }

  /**
   * Initialisation du composant.
   */
  protected void initComponent()
  {
    this.setLayout(new GridBagLayout());
    this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    this.setOpaque(false);

    this.addMouseListener(new MouseAdapter()
    {
      @Override
      public void mousePressed(MouseEvent arg0)
      {
        actionSwitch();
      }
    });
  }

  /**
   * Permet la modification de l'image du switch.
   * 
   * @param switchImage
   *          Image avec laquelle on va modifier le switch.
   */
  protected void updateDisplay(Image switchImage)
  {
    this.removeAll();

    JPanel imagePane = new ImagePanel(switchImage, this.dimension);
    this.add(imagePane, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE,
        new Insets(0, 0, 0, 0), 0, 0));

    this.revalidate();
    this.repaint();
  }

  /**
   * Action effectuée suite au clic sur la vue, averti le contrôleur du clic.
   */
  protected void actionSwitch()
  {
    followSwitchButtonController.actionSwitch(followSwitchButtonModel);
  }

}
