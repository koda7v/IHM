package com.iup.tp.twitup.ihm.hometwitt.twittlist.observer;

import com.iup.tp.twitup.ihm.hometwitt.twitt.TwittComponent;
import com.iup.tp.twitup.ihm.hometwitt.twittlist.TwittListModel;

public interface ITwittListModelObserver
{

  /**
   * Notifie qu'un composant de de twitt a été ajouté.
   * 
   * @param correspondenceComponent
   *          Nouveau composant d'un twitt.
   */
  public void twittComponentAdded(TwittComponent twittComponent);

  public void twittSearch(TwittListModel twittListModel);
}
