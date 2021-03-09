package com.iup.tp.twitup.ihm.hometwitt.creationtwitt;

import com.iup.tp.twitup.core.EntityManager;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;

public class CreationTwittComponent
{
  protected CreationTwittController controller;
  protected CreationTwittModel model;
  protected CreationTwittView view;

  public CreationTwittComponent(IDatabase base, User user, EntityManager manager)
  {
    this.controller = new CreationTwittController(base, user, manager);
    this.model = new CreationTwittModel();
    this.view = new CreationTwittView();

    this.view.addCreationViewObserver(this.controller);
  }

  public CreationTwittView getCreationTwittView()
  {
    return view;
  }

}
