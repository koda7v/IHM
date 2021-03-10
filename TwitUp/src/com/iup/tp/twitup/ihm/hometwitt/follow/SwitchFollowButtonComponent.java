package com.iup.tp.twitup.ihm.hometwitt.follow;

import java.awt.Dimension;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.iup.tp.twitup.ihm.hometwitt.follow.observers.ISwitchFollowButtonComponentObserver;
import com.iup.tp.twitup.ihm.hometwitt.follow.observers.ISwitchFollowButtonControllerObserver;

public class SwitchFollowButtonComponent implements Serializable, ISwitchFollowButtonControllerObserver
{
  private static final long serialVersionUID = -1020265596143521303L;

  /**
   * Contrôleur commun des boutons switch follow/unfollow.
   */
  protected SwitchFollowButtonController followButtonControler;

  /**
   * Modèle du composant du bouton follow.
   */
  protected SwitchFollowButtonModel followButtonModel;

  /**
   * Vue du composant bouton follow.
   */
  protected SwitchFollowButtonView followButtonView;

  /**
   * Liste des observeurs du composant.
   */
  protected List<ISwitchFollowButtonComponentObserver> observers;

  /**
   * Créer le composant graphique du bouton switch follow et unfollow.
   * 
   * @param switchFollowButtonModel
   *          Modèle du bouton.
   * @param dimension
   *          Dimension du bouton.
   */
  public SwitchFollowButtonComponent(SwitchFollowButtonModel switchFollowButtonModel, Dimension dimension)
  {
    this.followButtonModel = switchFollowButtonModel;
    this.followButtonControler = new SwitchFollowButtonController(switchFollowButtonModel);
    this.followButtonView = new SwitchFollowButtonView(followButtonControler, switchFollowButtonModel, dimension);
    this.observers = new ArrayList<>();

    switchFollowButtonModel.addObserver(this.followButtonView);
    followButtonControler.addObserver(this);
  }

  /**
   * Créer le composant graphique du bouton switch follow/unfollow avec les tooltips envoyés en paramètre.
   * 
   * @param switchFollowButtonModel
   *          Modèle du bouton.
   * @param dimension
   *          Dimension du bouton.
   * @param tooltipON
   *          Information quand le bouton est en mode follow.
   * @param tooltipOFF
   *          Information quand le bouton est en mode unfollow.
   */
  public SwitchFollowButtonComponent(SwitchFollowButtonModel switchFollowButtonModel, Dimension dimension,
                                     String tooltipON, String tooltipOFF)
  {
//    this(switchFollowButtonModel, dimension);
//    this.followButtonView.setTooltipON(tooltipON);
//    this.followButtonView.setTooltipOFF(tooltipOFF);
  }

  @Override
  public void changeActivation(SwitchFollowButtonModel model)
  {
    if (this.followButtonModel.equals(model))
    {
      this.notifyChangeActivation(model);
    }
  }

  /**
   * Ajoute l'observeur en paramètre dans la liste des observeurs.
   * 
   * @param observer
   *          Observeur à ajouter.
   */
  public void addObserver(ISwitchFollowButtonComponentObserver observer)
  {
    if (observer != null)
    {
      this.observers.add(observer);
    }
  }

  /**
   * Enlève l'observeur en paramètre de la liste des observeurs.
   * 
   * @param observer
   *          Observeur à enlever.
   */
  public void removeObserver(ISwitchFollowButtonComponentObserver observer)
  {
    if (observer != null)
    {
      this.observers.remove(observer);
    }
  }

  /**
   * Notifie les observeurs qu'il faut changer l'état du bouton switch.
   * 
   * @param model
   *          Modèle du switch.
   */
  public void notifyChangeActivation(SwitchFollowButtonModel switchFollowButtonModel)
  {
    List<ISwitchFollowButtonComponentObserver> copyObservers = new ArrayList<>(this.observers);

    for (ISwitchFollowButtonComponentObserver observer : copyObservers)
    {
      observer.updateSwitchFollowActivation(switchFollowButtonModel);
    }
  }

  /**
   * Supprime le composant.
   */
  public void dispose()
  {
    this.followButtonModel.removeObserver(this.followButtonView);
  }

  public SwitchFollowButtonModel getSwitchFollowFButtonModel()
  {
    return followButtonModel;
  }

  public SwitchFollowButtonView getSwitchFollowButtonView()
  {
    return followButtonView;
  }

  public SwitchFollowButtonController getFollowButtonControler()
  {
    return followButtonControler;
  }

  public void setFollowButtonControler(SwitchFollowButtonController followButtonControler)
  {
    this.followButtonControler = followButtonControler;
  }

}
