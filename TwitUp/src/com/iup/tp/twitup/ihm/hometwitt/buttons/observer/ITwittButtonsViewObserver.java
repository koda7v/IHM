package com.iup.tp.twitup.ihm.hometwitt.buttons.observer;

/**
 * Gestion des différentes actions émises par la vue du composant TwittButtonsComponent.
 * 
 * @author EPE
 *
 */
public interface ITwittButtonsViewObserver
{
  /**
   * Notifie le changement de vue vers l'accueil.
   */
  public void notifyHome();

  /**
   * Notifie un changement de vue vers le profil.
   */
  public void notifyProfile();

  /**
   * Notifie une deconnexion.
   */
  public void notififyLogout();
}
