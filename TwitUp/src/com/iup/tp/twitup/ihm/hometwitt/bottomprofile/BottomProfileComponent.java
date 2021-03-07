package com.iup.tp.twitup.ihm.hometwitt.bottomprofile;

/**
 * Composant allant sous le profil.
 * 
 * @author EPE
 *
 */
public class BottomProfileComponent
{

  /**
   * Controlleur du composant.
   */
  protected BottomProfileController bottomProfileController;

  /**
   * Controlleur du composant.
   */
  protected BottomProfileModel bottomProfileModel;

  /**
   * Vue du composant.
   */
  protected BottomProfileView bottomProfileView;

  /**
   * Instanciation du MVC du composant sous le Profile.
   */
  public BottomProfileComponent()
  {
    this.bottomProfileController = new BottomProfileController();
    this.bottomProfileModel = new BottomProfileModel();
    this.bottomProfileView = new BottomProfileView();
  }

  public BottomProfileView getBottomProfileView()
  {
    return bottomProfileView;
  }

}
