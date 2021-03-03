package com.iup.tp.twitup.ihm.hometwitt.creationtwitt;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;

public class CreationTwittComponent
{
  protected CreationTwittController controller;
  protected CreationTwittModel model;
  protected CreationTwittView view;

  public CreationTwittComponent(IDatabase base, User user)
  {
    this.controller = new CreationTwittController(base, user);
    this.model = new CreationTwittModel();
    this.view = new CreationTwittView();

    this.view.addCreationViewObserver(this.controller);
  }

  public CreationTwittView getTwittView()
  {
    return view;
  }

}
