package com.iup.tp.twitup.ihm.hometwitt.follow;

import java.util.ArrayList;
import java.util.List;

import com.iup.tp.twitup.datamodel.IUserObserver;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.hometwitt.follow.observers.ISwitchFollowButtonControllerObserver;

public class SwitchFollowButtonController implements IUserObserver
{

  /**
   * Liste des observeurs du contrôleur.
   */
  protected List<ISwitchFollowButtonControllerObserver> observers;

  protected SwitchFollowButtonModel switchFollowButtonModel;

  /**
   * Créer un contrôleur pour le bouton switch ON/OFF.
   * 
   * @param switchFollowButtonModel
   */
  public SwitchFollowButtonController(SwitchFollowButtonModel switchFollowButtonModel)
  {
    this.switchFollowButtonModel = switchFollowButtonModel;
    this.observers = new ArrayList<>();
  }

  /**
   * Notifie ses observeurs du clic sur le modèle.
   * 
   * @param model
   *          Modèle concerné par le clic.
   */
  public void actionSwitch(SwitchFollowButtonModel model)
  {
    this.notifyChangeActivation(model);
  }

  /**
   * Ajoute l'observeur en paramètre dans la liste des observeurs.
   * 
   * @param observer
   *          Observeur à ajouter.
   */
  public void addObserver(ISwitchFollowButtonControllerObserver observer)
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
  public void removeObserver(ISwitchFollowButtonControllerObserver observer)
  {
    if (observer != null)
    {
      this.observers.remove(observer);
    }

  }

  /**
   * Notification pour changer l'activation du bouton.
   * 
   * @param model
   *          Modèle du bouton switch ON/OFF.
   */
  public void notifyChangeActivation(SwitchFollowButtonModel model)
  {
    for (ISwitchFollowButtonControllerObserver observer : observers)
    {
      observer.changeActivation(model);
    }
  }

  @Override
  public void changeFollowActivation()
  {
    User user = this.switchFollowButtonModel.getUser();
    User userConnected = this.switchFollowButtonModel.getUserConnected();
    this.switchFollowButtonModel.setActivated(userConnected.isFollowing(user));

  }
}
