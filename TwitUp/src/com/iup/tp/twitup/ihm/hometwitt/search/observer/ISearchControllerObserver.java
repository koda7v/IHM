package com.iup.tp.twitup.ihm.hometwitt.search.observer;

public interface ISearchControllerObserver
{
  public void notifySearchTwit(String text);

  public void notifySearchUser(String text);
}
