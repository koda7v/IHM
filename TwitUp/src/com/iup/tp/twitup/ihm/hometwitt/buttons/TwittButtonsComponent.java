package com.iup.tp.twitup.ihm.hometwitt.buttons;

import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.hometwitt.buttons.observer.ITwittButtonsControllerObserver;

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

    this.twittButtonsView.addObserver(twittButtonsController);

  }

  public void addITwittButtonsControllerObserver(ITwittButtonsControllerObserver observer)
  {
    this.twittButtonsController.addObserver(observer);
  }

  public void removeITwittButtonsControllerObserver(ITwittButtonsControllerObserver observer)
  {
    this.twittButtonsController.removeObserver(observer);
  }

  public TwittButtonsView getTwittButtonsView()
  {
    return twittButtonsView;
  }

}
