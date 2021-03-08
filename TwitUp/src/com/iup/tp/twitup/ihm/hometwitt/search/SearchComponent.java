package com.iup.tp.twitup.ihm.hometwitt.search;

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
