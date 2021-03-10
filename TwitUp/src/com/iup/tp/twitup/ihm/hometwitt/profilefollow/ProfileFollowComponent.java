package com.iup.tp.twitup.ihm.hometwitt.profilefollow;

import com.iup.tp.twitup.core.EntityManager;
import com.iup.tp.twitup.datamodel.User;

public class ProfileFollowComponent
{

  /**
   * Le contrôleur de composant Profile.
   */
  protected ProfileFollowController profileFollowController;

  /**
   * Le model du composant Profile.
   */
  protected ProfileFollowModel profileFollowModel;

  /**
   * La vue du composant Profile.
   */
  protected ProfileFollowView profileFollowView;

  /**
   * Instanciation du MVC du composant Profile.
   * 
   * @param userConnected
   * @param userConnected2
   */
  public ProfileFollowComponent(User user, User userConnected, EntityManager manager)
  {
    this.profileFollowController = new ProfileFollowController(user, userConnected, manager);
    this.profileFollowModel = new ProfileFollowModel();
    this.profileFollowView = new ProfileFollowView(user, userConnected, profileFollowController);

//    userConnected.addObserver(profileFollowController);
  }

  /**
   * Récupération de la vue du composant Profile avec Follow
   */
  public ProfileFollowView getProfileFollowView()
  {
    return profileFollowView;
  }

}
