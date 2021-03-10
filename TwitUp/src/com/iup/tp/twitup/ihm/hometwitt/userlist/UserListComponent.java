package com.iup.tp.twitup.ihm.hometwitt.userlist;

import com.iup.tp.twitup.core.EntityManager;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;

public class UserListComponent
{
  protected UserListModel modelList;
  protected UserListView viewList;
  protected UserListController userListController;

  public UserListComponent(IDatabase base, User userConnected, EntityManager manager)
  {
    this.modelList = new UserListModel(base, userConnected, manager);
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
