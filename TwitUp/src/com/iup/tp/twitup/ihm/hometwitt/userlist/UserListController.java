package com.iup.tp.twitup.ihm.hometwitt.userlist;

import java.util.HashSet;
import java.util.Set;

import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.hometwitt.IHomeTwittControllerObserver;

public class UserListController implements IHomeTwittControllerObserver
{

  protected UserListView view;

  protected UserListModel model;

  public UserListController(UserListModel modelList, UserListView view)
  {
    this.view = view;
    this.model = modelList;
  }

  @Override
  public void logOut()
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void updateListTwitWithSearch(String text)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void updateListUserWithSearch(String text)
  {
    Set<User> users = this.model.getBase().getUsers();
    Set<User> newTwits = new HashSet<User>();
    for (User user : users)
    {
      if (user.getUserTag().contains(text))
      {
        newTwits.add(user);
      }
    }
    this.model.setUsers(newTwits);
    this.model.initMap();
    this.view.repaintContentPane();

  }

}
