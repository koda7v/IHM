package com.iup.tp.twitup.ihm.hometwitt.follow.observers;

import com.iup.tp.twitup.ihm.hometwitt.follow.SwitchFollowButtonModel;

/**
 * Interface observeur du contrôleur du composant switch bouton.
 * 
 * @author yann
 *
 */
public interface ISwitchFollowButtonControllerObserver
{

  /**
   * Notification du changement de l'état d'activation du bouton.
   * 
   * @param model
   *          Modèle du bouton switch ON/OFF.
   */
  void changeActivation(SwitchFollowButtonModel model);

}
