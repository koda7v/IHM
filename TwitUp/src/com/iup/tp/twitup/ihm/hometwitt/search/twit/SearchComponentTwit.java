package com.iup.tp.twitup.ihm.hometwitt.search.twit;

import com.iup.tp.twitup.ihm.hometwitt.search.observer.ISearchControllerObserver;

public class SearchComponentTwit
{
  protected SearchViewTwit view;
  protected SearchControllerTwit controller;
  protected SearchModelTwit model;

  public SearchComponentTwit()
  {
    this.controller = new SearchControllerTwit();
    this.model = new SearchModelTwit();
    this.view = new SearchViewTwit();

    this.view.addISearchViewObserver(this.controller);
  }

  public void addObserverController(ISearchControllerObserver observer)
  {
    this.controller.addISearchControllerObserver(observer);
  }

  public void removeObserverController(ISearchControllerObserver observer)
  {
    this.controller.removeISearchControllerObserver(observer);
  }

  public SearchViewTwit getSearchView()
  {
    return view;
  }

  public void setSearchView(SearchViewTwit view)
  {
    this.view = view;
  }

}
