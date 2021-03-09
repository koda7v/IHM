package com.iup.tp.twitup.ihm.hometwitt.follow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.iup.tp.twitup.ihm.hometwitt.follow.observers.ISwitchFollowButtonModelObserver;

public class SwitchFollowButtonModel implements Serializable
{

  private static final long serialVersionUID = -5461867595964869525L;

  /**
   * Etat d'Activation du switch.
   */
  protected boolean activated;

  /**
   * Liste des observeurs du modèle du bouton switch.
   */
  protected List<ISwitchFollowButtonModelObserver> observers;

  /**
   * Créer un modèle pour le bouton switch ON/OFF.
   * 
   * @param activated
   *          État d'activation du switch.
   */
  public SwitchFollowButtonModel(boolean activated)
  {
    this.activated = activated;
    this.observers = new ArrayList<>();
  }

  /**
   * Ajoute l'observeur en paramètre dans la liste des observeurs.
   * 
   * @param observer
   *          Observeur à ajouter.
   */
  public void addObserver(ISwitchFollowButtonModelObserver observer)
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
  public void removeObserver(ISwitchFollowButtonModelObserver observer)
  {
    if (observer != null)
    {
      this.observers.remove(observer);
    }

  }

  /**
   * Notifie les observeurs du changement de l'état d'activation du switch.
   * 
   * @param model
   *          Modèle du switch.
   */
  public void notifyActivationChanged(boolean activated)
  {
    List<ISwitchFollowButtonModelObserver> copyObservers = new ArrayList<>(this.observers);

    for (ISwitchFollowButtonModelObserver observer : copyObservers)
    {
      observer.updateFollowActivation(activated);
    }
  }

  /**
   * Retourne l'état actuel d'activation du bouton.
   * 
   * @return <b>True</b> si le bouton est en état actif, <b>False</b> sinon.
   */
  public boolean isActivated()
  {
    return activated;
  }

  /**
   * Met à jour l'attributs <b>isActivated</b> et norifie les oberservers.
   * 
   * @param activated
   *          Nouvel état d'activation.
   */
  public void setActivated(boolean activated)
  {
    this.activated = activated;
    this.notifyActivationChanged(activated);
  }
}
