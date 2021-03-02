package com.iup.tp.twitup.ihm.home;

public class HomeComponent
{
  protected HomeModel homeModel;

  protected HomeView homeView;

  protected HomeController homeController;

  public HomeComponent()
  {
    this.homeModel = new HomeModel();
    this.homeView = new HomeView();
    this.homeController = new HomeController();
  }

  public HomeView getHomeView()
  {
    return homeView;
  }

}
