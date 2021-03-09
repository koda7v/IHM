package com.iup.tp.twitup.ihm.hometwitt.follow.observers;

/**
 * Interface observeur du modèle du bouton switch des follow.
 * 
 * @author yann
 *
 */
public interface ISwitchFollowButtonModelObserver
{

  /**
   * Notification du changement de l'état d'activation du switch des follow.
   * 
   * @param state
   *          Nouvel état du switch.
   */
  public void updateFollowActivation(boolean state);
}