package com.iup.tp.twitup.ihm.hometwitt.search;

import com.iup.tp.twitup.ihm.hometwitt.search.observer.ISearchControllerObserver;

public class SearchComponent
{
  protected SearchView view;
  protected SearchController controller;
  protected SearchModel model;

  public SearchComponent()
  {
    this.controller = new SearchController();
    this.model = new SearchModel();
    this.view = new SearchView();

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

  public SearchView getSearchView()
  {
    return view;
  }

  public void setSearchView(SearchView view)
  {
    this.view = view;
  }

}
