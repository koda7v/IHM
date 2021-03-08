package com.iup.tp.twitup.ihm.hometwitt.usertwittlist;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;

public class UserTwittListComponent
{
  protected UserTwittListModel modelList;
  protected UserTwittListView viewList;
  protected User user;

  public UserTwittListComponent(IDatabase base, User user)
  {
    this.modelList = new UserTwittListModel(base, user);
    this.viewList = new UserTwittListView(modelList);

    // this.modelList.addObserver(this.viewList);
  }

  public UserTwittListView getUserTwittListView()
  {
    return viewList;
  }
}
