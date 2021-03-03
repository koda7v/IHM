package com.iup.tp.twitup.ihm.hometwitt.creationtwitt;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.hometwitt.creationtwitt.observer.ICreationTwittViewObserver;

public class CreationTwittController implements ICreationTwittViewObserver
{

  protected IDatabase base;

  protected User user;

  public CreationTwittController(IDatabase base, User user)
  {
    this.base = base;
    this.user = user;
  }

  @Override
  public void notificationCreationValidate(String text)
  {
    System.out.println(user.getName());
    this.base.addTwit(new Twit(this.user, text));

  }

}
