package com.iup.tp.twitup.ihm.hometwitt.userlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.iup.tp.twitup.core.EntityManager;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.hometwitt.profilefollow.ProfileFollowComponent;

public class UserListModel
{

  /**
   * Map des composants de users avec leurs users associées.
   */
  protected Map<User, ProfileFollowComponent> userComponentMap;

  protected Set<User> users;

  protected IDatabase base;

  protected User userConnected;

  protected EntityManager manager;

  public UserListModel(IDatabase base, User userConnected, EntityManager manager)
  {
    this.base = base;
    this.manager = manager;
    this.users = base.getUsers();
    this.userConnected = userConnected;
    this.initMap();

  }

  protected void initMap()
  {
    this.userComponentMap = new HashMap<>();
    for (User currentUser : this.users)
    {
      if (!currentUser.getUserTag().equals(userConnected.getUserTag()))
      {
        ProfileFollowComponent userComponent = new ProfileFollowComponent(currentUser, userConnected, this.manager);
        this.userComponentMap.put(currentUser, userComponent);
      }
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

  public Set<User> getUsers()
  {
    return users;
  }

  public void setUsers(Set<User> users)
  {
    this.users = users;
  }

  /**
   * Retourne la liste des composants de users contenus dans la map.
   * 
   * @return Liste des composants de tweets.
   */
  public List<ProfileFollowComponent> getUserListComponent()
  {
    return new ArrayList<>(userComponentMap.values());
  }
}
