package com.iup.tp.twitup.ihm.hometwitt.vortex;

/**
 * Composant permettant la vue du VORTTTEEEEEEEEEXXXXXXXXXXXXXXXXXXXXXXXX.
 * 
 * @author EPE
 *
 */
public class VortexComponent
{
  /**
   * Le controlleur du comporsant Vortex.
   */
  protected VortexController vortexController;

  /**
   * Le modèle du composant Vortex.
   */
  protected VortexModel vortexModel;

  /**
   * La vue du composant Vue.
   */
  protected VortexView vortexView;

  /**
   * Instanciation du MVC du composant Vortex.
   */
  public VortexComponent()
  {
    this.vortexController = new VortexController();
    this.vortexModel = new VortexModel();
    this.vortexView = new VortexView();
  }

  /**
   * Récupération du la vue du composant Vortex.
   * 
   * @return
   */
  public VortexView getVortexView()
  {
    return vortexView;
  }
}
