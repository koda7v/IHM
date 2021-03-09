package com.iup.tp.twitup.ihm.hometwitt.follow.observers;

import com.iup.tp.twitup.ihm.hometwitt.follow.SwitchFollowButtonModel;

/**
 * Interface observeur du modèle composant du switch.
 * 
 * @author yann
 *
 */
public interface ISwitchFollowButtonComponentObserver
{

  /**
   * Notification du changement de l'état d'activation du bouton des follow.
   * 
   * @param model
   *          Modèle du bouton switch follow unfollow.
   */
  public void updateSwitchFollowActivation(SwitchFollowButtonModel model);

}
