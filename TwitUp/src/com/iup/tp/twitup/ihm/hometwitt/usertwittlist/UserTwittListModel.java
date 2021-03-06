package com.iup.tp.twitup.ihm.hometwitt.usertwittlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.hometwitt.twitt.TwittComponent;

public class UserTwittListModel
{

  /**
   * Map des composants de tweets avec leurs tweets associées.
   */
  protected Map<Twit, TwittComponent> twittComponentMap;

  protected IDatabase base;

  protected User user;

  /**
   * Liste des observeurs du modèle.
   */
//  protected List<ITwittListModelObserver> observers;

  public UserTwittListModel(IDatabase base, User user)
  {
    this.user = user;
    this.base = base;
    this.twittComponentMap = new HashMap<>();
    this.initMap(user);

//    this.observers = new ArrayList<ITwittListModelObserver>();
  }

  protected void initMap(User user)
  {

    for (Twit currentTwitt : base.getUserTwits(user))
    {
      TwittComponent twittComponent = new TwittComponent(currentTwitt);
      this.twittComponentMap.put(currentTwitt, twittComponent);
    }

  }

//  /**
//   * Ajoute un observeurà la liste des observeurs.
//   * 
//   * @param observer
//   *          Observeur à ajouter.
//   */
//  public void addObserver(ITwittListModelObserver observer)
//  {
//    if (observer != null)
//    {
//      this.observers.add(observer);
//    }
//  }
//
//  /**
//   * Retire un observeur de la liste des observeurs.
//   * 
//   * @param observer
//   *          Observeur à retirer.
//   */
//  public void removeObserver(ITwittListModelObserver observer)
//  {
//    if (observer != null)
//    {
//      this.observers.remove(observer);
//    }
//  }
//
//  /**
//   * Notifie les observeurs qu'un composant de twitt a été ajouté.
//   * 
//   * @param twittComponent
//   *          Composant de twitt ajouté.
//   */
//  public void notifyTwittComponentAdded(TwittComponent twittComponent)
//  {
//    List<ITwittListModelObserver> copyObservers = new ArrayList<>(this.observers);
//
//    for (ITwittListModelObserver observer : copyObservers)
//    {
//      observer.twittComponentAdded(twittComponent);
//    }
//  }
//
//  /**
//   * Ajoute un twitt et son composant associé.
//   * 
//   * @param twit
//   *          Twit à ajouter.
//   * @param twittComponent
//   *          Composant associé au twitt.
//   */
//  protected void addTwittComponent(Twit twit, TwittComponent twittComponent)
//  {
//    twittComponentMap.put(twit, twittComponent);
//    this.notifyTwittComponentAdded(twittComponent);
//  }

  /**
   * Retourne la liste des composants de twitt contenus dans la map.
   * 
   * @return Liste des composants de twitt.
   */
  public List<TwittComponent> getTwittComponentList()
  {
    return new ArrayList<>(twittComponentMap.values());
  }
}
