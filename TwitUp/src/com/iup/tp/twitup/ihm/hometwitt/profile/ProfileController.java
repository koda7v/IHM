package com.iup.tp.twitup.ihm.hometwitt.profile;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
   * Créer un nouveau contrôleur pour le changement des follow unfollow.
   */
  public ProfileController()
  {
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
  public void addSwitchButton(User user, SwitchFollowButtonModel switchFollowButtonModel)
  {
    this.userSwitchMap.put(user, switchFollowButtonModel);
  }

  @Override
  public void changeFollowActivation(boolean changeFollow, User user)
  {
    this.userSwitchMap.get(user).setActivated(changeFollow);
    ;

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

}
