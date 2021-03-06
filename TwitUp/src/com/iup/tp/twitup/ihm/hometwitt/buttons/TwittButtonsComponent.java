package com.iup.tp.twitup.ihm.hometwitt.buttons;

public class TwittButtonsComponent
{
  protected TwittButtonsController twittButtonsController;

  protected TwittButtonsModel twittButtonsModel;

  protected TwittButtonsView twittButtonsView;

  public TwittButtonsComponent()
  {
    this.twittButtonsController = new TwittButtonsController();
    this.twittButtonsModel = new TwittButtonsModel();
    this.twittButtonsView = new TwittButtonsView();

  }

  public TwittButtonsView getTwittButtonsView()
  {
    return twittButtonsView;
  }

}
