package com.iup.tp.twitup.ihm.hometwitt.profile;

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
   * Instanciation du MVC du composant Profile.
   */
  public ProfileComponent(User user)
  {
    this.profileController = new ProfileController();
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

}
