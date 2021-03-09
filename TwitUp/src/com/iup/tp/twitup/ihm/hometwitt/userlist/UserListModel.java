package com.iup.tp.twitup.ihm.hometwitt.userlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.hometwitt.profile.ProfileComponent;

public class UserListModel
{

  /**
   * Map des composants de users avec leurs users associées.
   */
  protected Map<User, ProfileComponent> userComponentMap;

  protected Set<User> users;

  protected IDatabase base;

  /**
   * Liste des observeurs du modèle.
   */
  // protected List<IUserListModelObserver> observers;

  public UserListModel(IDatabase base)
  {
    this.base = base;
    this.users = base.getUsers();
    this.initMap();

    // this.observers = new ArrayList<IUserListModelObserver>();
  }

  protected void initMap()
  {
    this.userComponentMap = new HashMap<>();
    for (User currentUser : this.users)
    {
      ProfileComponent userComponent = new ProfileComponent(currentUser);
      this.userComponentMap.put(currentUser, userComponent);
    }

  }

  public IDatabase getBase()
  {
    return base;
  }

  public void setBase(IDatabase base)
  {
    this.base = base;
  }

  /**
   * Ajoute un observeurà la liste des observeurs.
   * 
   * @param observer
   *          Observeur à ajouter.
   */
//  public void addObserver(IUserListModelObserver observer)
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
//  public void removeObserver(IUserListModelObserver observer)
//  {
//    if (observer != null)
//    {
//      this.observers.remove(observer);
//    }
//  }

  /**
   * Notifie les observeurs qu'un composant de twitt a été ajouté.
   * 
   * @param twittComponent
   *          Composant de twitt ajouté.
   */
//  public void notifyTwittComponentAdded(TwittComponent twittComponent)
//  {
//    List<ITwittListModelObserver> copyObservers = new ArrayList<>(this.observers);
//
//    for (ITwittListModelObserver observer : copyObservers)
//    {
//      observer.twittComponentAdded(twittComponent);
//    }
//  }

  /**
   * Ajoute un twitt et son composant associé.
   * 
   * @param twit
   *          Twit à ajouter.
   * @param twittComponent
   *          Composant associé au twitt.
   */
//  protected void addTwittComponent(Twit twit, TwittComponent twittComponent)
//  {
//    twittComponentMap.put(twit, twittComponent);
//    this.notifyTwittComponentAdded(twittComponent);
//  }

  public Set<User> getUsers()
  {
    return users;
  }

  public void setUsers(Set<User> users)
  {
    this.users = users;
  }

  /**
   * Retourne la liste des composants de tweets contenus dans la map.
   * 
   * @return Liste des composants de tweets.
   */
  public List<ProfileComponent> getUserListComponent()
  {
    return new ArrayList<>(userComponentMap.values());
  }
}
