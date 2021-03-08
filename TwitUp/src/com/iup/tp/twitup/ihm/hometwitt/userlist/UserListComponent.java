package com.iup.tp.twitup.ihm.hometwitt.userlist;

import com.iup.tp.twitup.datamodel.IDatabase;

public class UserListComponent
{
  UserListModel modelList;
  UserListView viewList;

  public UserListComponent(IDatabase base)
  {
    this.modelList = new UserListModel(base);
    this.viewList = new UserListView(modelList);

    // this.modelList.addObserver(this.viewList);
  }

  public UserListView getUserListView()
  {
    return viewList;
  }

}
