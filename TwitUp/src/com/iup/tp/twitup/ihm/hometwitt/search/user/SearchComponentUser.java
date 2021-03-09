package com.iup.tp.twitup.ihm.hometwitt.search.user;

import com.iup.tp.twitup.ihm.hometwitt.search.observer.ISearchControllerObserver;

public class SearchComponentUser
{
  protected SearchViewUser searchViewUser;
  protected SearchControllerUser searchControllerUser;
  protected SearchModelUser searchModelUser;

  public SearchComponentUser()
  {
    this.searchControllerUser = new SearchControllerUser();
    this.searchModelUser = new SearchModelUser();
    this.searchViewUser = new SearchViewUser();

    this.searchViewUser.addISearchViewObserver(searchControllerUser);
  }

  public void addObserverController(ISearchControllerObserver observer)
  {
    this.searchControllerUser.addISearchControllerObserver(observer);
  }

  public void removeObserverController(ISearchControllerObserver observer)
  {
    this.searchControllerUser.removeISearchControllerObserver(observer);
  }

  public SearchViewUser getSearchViewUser()
  {
    return searchViewUser;
  }

  public void setSearchViewUser(SearchViewUser searchViewUser)
  {
    this.searchViewUser = searchViewUser;
  }

}
