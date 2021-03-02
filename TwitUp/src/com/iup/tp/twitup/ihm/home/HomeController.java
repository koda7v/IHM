package com.iup.tp.twitup.ihm.home;

import com.iup.tp.twitup.configuration.ConstantLoader;
import com.iup.tp.twitup.ihm.home.observer.IHomeViewObserver;

public class HomeController implements IHomeViewObserver
{
  protected HomeView homeView;

  protected HomeComponent homeComponent;

  protected static final String KEY_SIGNUP_BUTTON_TITLE = "KEY_SIGNUP_BUTTON_TITLE";

  protected static final String KEY_SIGNIN_BUTTON_TITLE = "KEY_SIGNIN_BUTTON_TITLE";

  public HomeController(HomeComponent homeComponent, HomeView homeView)
  {
    this.homeView = homeView;
    this.homeComponent = homeComponent;
  }

  @Override
  public void notificationChoiceView(String choice)
  {
    if (choice.equals(ConstantLoader.getInstance().getText(KEY_SIGNUP_BUTTON_TITLE)))
    {
      this.homeComponent.notificationSwapMainView(1);
    }
    else if (choice.equals(ConstantLoader.getInstance().getText(KEY_SIGNIN_BUTTON_TITLE)))
    {
      this.homeComponent.notificationSwapMainView(2);
    }

  }

}
