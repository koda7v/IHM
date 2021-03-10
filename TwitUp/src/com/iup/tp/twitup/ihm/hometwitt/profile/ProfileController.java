package com.iup.tp.twitup.ihm.hometwitt.profile;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.iup.tp.twitup.core.EntityManager;
import com.iup.tp.twitup.datamodel.IUserObserver;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.hometwitt.follow.SwitchFollowButtonModel;
import com.iup.tp.twitup.ihm.hometwitt.follow.observers.ISwitchFollowButtonComponentObserver;

/**
 * Permet aux boutons switch et à la liste des users d'interagir. Utilisée pour le follow et unfollow d'un user.
 * 
 * @author yann
 *
 */
public class ProfileController implements Serializable, IUserObserver, ISwitchFollowButtonComponentObserver
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
  public ProfileController(User user, User userConnected, EntityManager manager)
  {
    this.manager = manager;
    this.userConnected = userConnected;
    this.user = user;
    this.userSwitchMap = new HashMap<>();
  }

  public ProfileController(User user)
  {
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
  public void changeFollowActivation(boolean changeFollow)
  {
    this.userSwitchMap.get(user).setActivated(changeFollow);
    this.changeFollow(changeFollow);

  }

  @Override
  public void updateSwitchFollowActivation(SwitchFollowButtonModel model)
  {
    for (Entry<User, SwitchFollowButtonModel> currentEntry : userSwitchMap.entrySet())
    {
      if (currentEntry.getValue().equals(model))
      {
        currentEntry.getKey().setFollowActivated(!model.isActivated());
        break;
      }
    }

  }

  public void changeFollow(boolean change)
  {
    if (change)
    {
      this.userConnected.addFollowing(user.getUserTag());
      this.manager.sendUser(userConnected);

    }
    else
    {
      this.userConnected.removeFollowing(user.getUserTag());
      this.manager.sendUser(userConnected);
    }

  }

}
