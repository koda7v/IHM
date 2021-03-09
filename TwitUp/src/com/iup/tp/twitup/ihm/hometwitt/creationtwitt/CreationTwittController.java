package com.iup.tp.twitup.ihm.hometwitt.creationtwitt;

import com.iup.tp.twitup.core.EntityManager;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.hometwitt.creationtwitt.observer.ICreationTwittViewObserver;

public class CreationTwittController implements ICreationTwittViewObserver
{

  protected IDatabase base;

  protected User user;

  protected EntityManager manager;

  public CreationTwittController(IDatabase base, User user, EntityManager manager)
  {
    this.base = base;
    this.user = user;
    this.manager = manager;
  }

  @Override
  public void notificationCreationValidate(String text)
  {
    Twit twit = new Twit(this.user, text);
    this.manager.sendTwit(twit);
  }

}
