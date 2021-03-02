package com.iup.tp.twitup.ihm.home;

import java.util.ArrayList;
import java.util.List;

import com.iup.tp.twitup.ihm.home.observer.IHomeObserver;

public class HomeComponent
{
  protected HomeModel homeModel;

  protected HomeView homeView;

  protected HomeController homeController;

  protected List<IHomeObserver> observers;

  public HomeComponent()
  {
    this.homeModel = new HomeModel();
    this.homeView = new HomeView();
    this.homeController = new HomeController(this, this.homeView);
    this.homeView.addIHomeViewObserver(this.homeController);

    this.observers = new ArrayList<>();
  }

  public void addObserver(IHomeObserver observer)
  {
    if (observer != null)
      this.observers.add(observer);
  }

  public void notificationSwapMainView(Integer value)
  {
    for (IHomeObserver currentObserver : observers)
    {
      currentObserver.notificationSwapView(value);
    }
  }

  public HomeView getHomeView()
  {
    return homeView;
  }

}
