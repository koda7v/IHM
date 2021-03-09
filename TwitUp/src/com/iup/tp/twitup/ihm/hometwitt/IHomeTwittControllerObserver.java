package com.iup.tp.twitup.ihm.hometwitt;

public interface IHomeTwittControllerObserver
{
  public void logOut();

  public void updateListTwitWithSearch(String text);

  public void updateListUserWithSearch(String text);
}
