package com.iup.tp.twitup.ihm.hometwitt.profile;

import com.iup.tp.twitup.core.EntityManager;
import com.iup.tp.twitup.datamodel.User;

/**
 * Composant permettant le vue de l'utilisateur connecté.
 * 
 * @author EPE
 *
 */
public class ProfileComponent
{
  /**
   * Le contrôleur de composant Profile.
   */
  protected ProfileController profileController;

  /**
   * Le model du composant Profile.
   */
  protected ProfileModel profileModel;

  /**
   * La vue du composant Profile.
   */
  protected ProfileView profileView;

  /**
   * La vue du composant profile avec les follow
   */
  protected ProfileFollowView profileFollowView;

  /**
   * Instanciation du MVC du composant Profile.
   * 
   * @param userConnected
   * @param userConnected2
   */
  public ProfileComponent(User user, User userConnected, EntityManager manager)
  {
    this.profileController = new ProfileController(user, userConnected, manager);
    this.profileModel = new ProfileModel();
    this.profileFollowView = new ProfileFollowView(user, userConnected, profileController);

  }

  public ProfileComponent(User user)
  {
    this.profileController = new ProfileController(user);
    this.profileModel = new ProfileModel();
    this.profileView = new ProfileView(user, profileController);

  }

  /**
   * Récupération du la vue du composant Profile.
   * 
   * @return
   */
  public ProfileView getProfileView()
  {
    return profileView;
  }

  /**
   * Récupération de la vue du composant Profile avec Follow
   */
  public ProfileFollowView getProfileFollowView()
  {
    return profileFollowView;
  }

}
