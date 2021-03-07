package com.iup.tp.twitup.ihm.hometwitt.buttons;

import com.iup.tp.twitup.datamodel.User;

public class TwittButtonsComponent
{
  protected TwittButtonsController twittButtonsController;

  protected TwittButtonsModel twittButtonsModel;

  protected TwittButtonsView twittButtonsView;

  public TwittButtonsComponent(User user)
  {
    this.twittButtonsController = new TwittButtonsController();
    this.twittButtonsModel = new TwittButtonsModel();
    this.twittButtonsView = new TwittButtonsView(user);

  }

  public TwittButtonsView getTwittButtonsView()
  {
    return twittButtonsView;
  }

}
