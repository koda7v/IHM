package com.iup.tp.twitup.ihm.hometwitt.twittlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.ihm.hometwitt.twitt.TwittComponent;
import com.iup.tp.twitup.ihm.hometwitt.twittlist.observer.ITwittListModelObserver;

public class TwittModelList
{

  /**
   * Map des composants de tweets avec leurs tweets associées.
   */
  protected Map<Twit, TwittComponent> twittComponentMap;

  /**
   * Liste des observeurs du modèle.
   */
  protected List<ITwittListModelObserver> observers;

  public TwittModelList()
  {
    this.twittComponentMap = new HashMap<>();

    this.observers = new ArrayList<ITwittListModelObserver>();
  }

  /**
   * Ajoute un observeurà la liste des observeurs.
   * 
   * @param observer
   *          Observeur à ajouter.
   */
  public void addObserver(ITwittListModelObserver observer)
  {
    if (observer != null)
    {
      this.observers.add(observer);
    }
  }

  /**
   * Retire un observeur de la liste des observeurs.
   * 
   * @param observer
   *          Observeur à retirer.
   */
  public void removeObserver(ITwittListModelObserver observer)
  {
    if (observer != null)
    {
      this.observers.remove(observer);
    }
  }

  /**
   * Notifie les observeurs qu'un composant de twitt a été ajouté.
   * 
   * @param twittComponent
   *          Composant de twitt ajouté.
   */
  public void notifyTwittComponentAdded(TwittComponent twittComponent)
  {
    List<ITwittListModelObserver> copyObservers = new ArrayList<>(this.observers);

    for (ITwittListModelObserver observer : copyObservers)
    {
      observer.twittComponentAdded(twittComponent);
    }
  }

  /**
   * Ajoute un twitt et son composant associé.
   * 
   * @param twit
   *          Twit à ajouter.
   * @param twittComponent
   *          Composant associé au twitt.
   */
  protected void addTwittComponent(Twit twit, TwittComponent twittComponent)
  {
    twittComponentMap.put(twit, twittComponent);
    this.notifyTwittComponentAdded(twittComponent);
  }

  /**
   * Retourne la liste des composants de tweets contenus dans la map.
   * 
   * @return Liste des composants de tweets.
   */
  public List<TwittComponent> getTwittComponentList()
  {
    return new ArrayList<>(twittComponentMap.values());
  }
}
