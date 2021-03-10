package com.iup.tp.twitup.ihm.hometwitt.twittlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.ihm.hometwitt.twitt.TwittComponent;
import com.iup.tp.twitup.ihm.hometwitt.twittlist.observer.ITwittListModelObserver;
import com.iup.tp.twitup.utils.TwittComponentComparator;

public class TwittListModel
{

  /**
   * Map des composants de tweets avec leurs tweets associées.
   */
  protected Map<Twit, TwittComponent> twittComponentMap;

  protected Set<Twit> twitts;

  protected IDatabase base;

  /**
   * Liste des observeurs du modèle.
   */
  protected List<ITwittListModelObserver> observers;

  public TwittListModel(IDatabase base)
  {
    this.base = base;
    this.twitts = base.getTwits();
    this.initMap();

    this.observers = new ArrayList<ITwittListModelObserver>();
  }

  protected void initMap()
  {
    this.twittComponentMap = new HashMap<>();
    for (Twit currentTwitt : this.twitts)
    {
      TwittComponent twittComponent = new TwittComponent(currentTwitt);
      this.twittComponentMap.put(currentTwitt, twittComponent);
    }

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
   * Retourne la liste des composants de twitt contenus dans la map.
   * 
   * @return Liste des composants de twitt.
   */
  public List<TwittComponent> getTwittComponentList()
  {
    List<TwittComponent> correspondenceComponentList = new ArrayList<>(twittComponentMap.values());
    Collections.sort(correspondenceComponentList, new TwittComponentComparator());
    return correspondenceComponentList;
  }

  public IDatabase getBase()
  {
    return base;
  }

  public void setBase(IDatabase base)
  {
    this.base = base;
  }

  public Set<Twit> getTwitts()
  {
    return twitts;
  }

  public void setTwitts(Set<Twit> twitts)
  {
    this.twitts = twitts;
    this.initMap();
    for (ITwittListModelObserver currentObserver : this.observers)
    {
      currentObserver.twittSearch(this);
    }
  }

}
