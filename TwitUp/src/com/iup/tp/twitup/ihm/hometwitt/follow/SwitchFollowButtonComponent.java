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
  protected static SwitchFollowButtonController followButtonControler;

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
   * Créer le composant graphique du bouton switch ON/OFF.
   * 
   * @param switchFollowButtonModel
   *          Modèle du bouton.
   * @param dimension
   *          Dimension du bouton.
   */
  public SwitchFollowButtonComponent(SwitchFollowButtonModel switchFollowButtonModel, Dimension dimension)
  {
    initSwitchButtonController();
    this.followButtonModel = switchFollowButtonModel;
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
   *          Information quand le bouton est en mode activé.
   * @param tooltipOFF
   *          Information quand le bouton est en mode désactivé.
   */
  public SwitchFollowButtonComponent(SwitchFollowButtonModel switchFollowButtonModel, Dimension dimension,
                                     String tooltipON, String tooltipOFF)
  {
    this(switchFollowButtonModel, dimension);
    this.followButtonView.setTooltipON(tooltipON);
    this.followButtonView.setTooltipOFF(tooltipOFF);
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
   * Notifie les observeurs qu'il faut changer l'état d'activation du bouton switch.
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

  /**
   * Si le contrôleur du switch bouton est <i>null</i>, instancie le contrôleur.
   */
  protected void initSwitchButtonController()
  {
    if (followButtonControler == null)
    {
      followButtonControler = new SwitchFollowButtonController();
    }
  }

  public SwitchFollowButtonModel getSwitchFollowFButtonModel()
  {
    return followButtonModel;
  }

  public SwitchFollowButtonView getSwitchFollowButtonView()
  {
    return followButtonView;
  }
}
