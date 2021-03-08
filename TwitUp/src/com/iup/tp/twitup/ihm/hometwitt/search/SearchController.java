package com.iup.tp.twitup.ihm.hometwitt.search;

import java.util.ArrayList;
import java.util.List;

import com.iup.tp.twitup.ihm.hometwitt.search.observer.ISearchControllerObserver;
import com.iup.tp.twitup.ihm.hometwitt.search.observer.ISearchViewObserver;

public class SearchController implements ISearchViewObserver
{

  protected List<ISearchControllerObserver> observers;

  public SearchController()
  {
    this.observers = new ArrayList<>();
  }

  public void addISearchControllerObserver(ISearchControllerObserver observer)
  {
    if (observer != null)
    {
      this.observers.add(observer);
    }
  }

  public void removeISearchControllerObserver(ISearchControllerObserver observer)
  {
    if (observer != null)
    {
      this.observers.remove(observer);
    }
  }

  @Override
  public void notifySearch(String text)
  {
    for (ISearchControllerObserver currentObserver : observers)
    {
      currentObserver.notifySearch(text);
    }

  }

}
