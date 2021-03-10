package com.iup.tp.twitup.ihm.hometwitt.userlist;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;

public class UserListComponent
{
  UserListModel modelList;
  UserListView viewList;
  UserListController userListController;

  public UserListComponent(IDatabase base, User userConnected)
  {
    this.modelList = new UserListModel(base, userConnected);
    this.viewList = new UserListView(modelList);
    this.userListController = new UserListController(modelList, viewList);

    // this.modelList.addObserver(this.viewList);

  }

  public UserListView getUserListView()
  {
    return viewList;
  }

  public UserListController getUserListController()
  {
    return userListController;
  }

  public void setUserListController(UserListController userListController)
  {
    this.userListController = userListController;
  }

}
