package com.iup.tp.twitup.ihm.hometwitt.buttons;

import java.util.ArrayList;
import java.util.List;

import com.iup.tp.twitup.ihm.hometwitt.buttons.observer.ITwittButtonsControllerObserver;
import com.iup.tp.twitup.ihm.hometwitt.buttons.observer.ITwittButtonsViewObserver;

public class TwittButtonsController implements ITwittButtonsViewObserver
{

  protected List<ITwittButtonsControllerObserver> observers;

  public TwittButtonsController()
  {
    this.observers = new ArrayList<>();
  }

  public void addObserver(ITwittButtonsControllerObserver observer)
  {
    if (observer != null)
    {
      this.observers.add(observer);
    }
  }

  public void removeObserver(ITwittButtonsControllerObserver observer)
  {
    if (observer != null)
    {
      this.observers.remove(observer);
    }
  }

  @Override
  public void notifyHome()
  {
    for (ITwittButtonsControllerObserver currentObserver : observers)
    {
      currentObserver.swapViewToHome();
    }

  }

  @Override
  public void notifyProfile()
  {
    for (ITwittButtonsControllerObserver currentObserver : observers)
    {
      currentObserver.swapViewToProfile();
    }
  }

  @Override
  public void notififyLogout()
  {
    for (ITwittButtonsControllerObserver currentObserver : observers)
    {
      currentObserver.logOut();
    }

  }

}
