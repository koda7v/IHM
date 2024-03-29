package com.iup.tp.twitup.ihm.hometwitt.profilefollow;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.iup.tp.twitup.core.EntityManager;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.hometwitt.follow.SwitchFollowButtonModel;
import com.iup.tp.twitup.ihm.hometwitt.follow.observers.ISwitchFollowButtonComponentObserver;

public class ProfileFollowController implements Serializable, ISwitchFollowButtonComponentObserver
{

  private static final long serialVersionUID = 4868883826324988463L;

  /**
   * Map permettant la liaison entre les users et les boutons switch.
   */
  protected Map<User, SwitchFollowButtonModel> userSwitchMap;

  /**
   * Utilisateur connecté.
   */
  protected User userConnected;

  /**
   * Utilisateur à afficher.
   */
  protected User user;

  /**
   * base de donnée
   */
  protected EntityManager manager;

  /**
   * Créer un nouveau contrôleur pour le changement des follow unfollow.
   * 
   * @param userConnected
   */
  public ProfileFollowController(User user, User userConnected, EntityManager manager)
  {
    this.manager = manager;
    this.userConnected = userConnected;
    this.user = user;
    this.userSwitchMap = new HashMap<>();
  }

  /**
   * Ajoute un user et un modèle d'un bouton switch à la map.
   * 
   * @param user
   *          User à ajouter.
   * @param switchButtonModel
   *          Modèle du bouton switch à ajouter.
   */
  public void addSwitchButton(SwitchFollowButtonModel switchFollowButtonModel)
  {
    this.userSwitchMap.put(user, switchFollowButtonModel);
  }

  @Override
  public void updateSwitchFollowActivation(SwitchFollowButtonModel model)
  {
    for (Entry<User, SwitchFollowButtonModel> currentEntry : userSwitchMap.entrySet())
    {
      if (currentEntry.getValue().equals(model))
      {
        this.changeFollow(model.getUserConnected().isFollowing(model.getUser()));
        break;
      }
    }

  }

  public void changeFollow(boolean change)
  {
    if (change)
    {
      this.userConnected.removeFollowing(user.getUserTag());
      this.manager.sendUser(userConnected);
    }
    else
    {
      this.userConnected.addFollowing(user.getUserTag());
      this.manager.sendUser(userConnected);
    }

  }

}
