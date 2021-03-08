package com.iup.tp.twitup.ihm.hometwitt;

import java.util.ArrayList;
import java.util.List;

import com.iup.tp.twitup.ihm.hometwitt.buttons.observer.ITwittButtonsControllerObserver;
import com.iup.tp.twitup.ihm.hometwitt.search.observer.ISearchControllerObserver;

public class HomeTwittController implements ITwittButtonsControllerObserver, ISearchControllerObserver
{
  protected HomeTwittView homeTwittView;

  protected List<IHomeTwittControllerObserver> observers;

  public HomeTwittController(HomeTwittView homeTwittView)
  {
    this.homeTwittView = homeTwittView;

    this.observers = new ArrayList<>();
  }

  public void addObserver(IHomeTwittControllerObserver observer)
  {
    if (observer != null)
    {
      this.observers.add(observer);
    }
  }

  public void removeObserver(IHomeTwittControllerObserver observer)
  {
    if (observer != null)
    {
      this.observers.remove(observer);
    }
  }

  @Override
  public void swapViewToHome()
  {
    this.homeTwittView.showHomeTwittView();
  }

  @Override
  public void swapViewToProfile()
  {
    this.homeTwittView.showProfileView();

  }

  @Override
  public void logOut()
  {
    for (IHomeTwittControllerObserver currentObserver : observers)
    {
      currentObserver.logOut();
    }

  }

  @Override
  public void notifySearch(String text)
  {
    for (IHomeTwittControllerObserver currentObserver : observers)
    {
      currentObserver.updateListWithSearch(text);
    }

  }

  @Override
  public void swapViewToUser()
  {
    this.homeTwittView.showListUserView();

  }

}
