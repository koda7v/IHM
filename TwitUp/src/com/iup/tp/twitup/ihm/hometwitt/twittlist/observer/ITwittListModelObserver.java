package com.iup.tp.twitup.ihm.hometwitt.twittlist.observer;

import com.iup.tp.twitup.ihm.hometwitt.creationtwitt.CreationTwittComponent;

public interface ITwittListModelObserver
{

  /**
   * Notifie qu'un composant de de twitt a été ajouté.
   * 
   * @param correspondenceComponent
   *          Nouveau composant d'un twitt.
   */
  public void twittComponentAdded(CreationTwittComponent twittComponent);
}
