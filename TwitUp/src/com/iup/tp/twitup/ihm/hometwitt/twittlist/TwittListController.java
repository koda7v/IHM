package com.iup.tp.twitup.ihm.hometwitt.twittlist;

import com.iup.tp.twitup.datamodel.IDatabaseObserver;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.hometwitt.twitt.TwittComponent;

public class TwittListController implements IDatabaseObserver
{

  protected TwittListView view;

  protected TwittListModel model;

  public TwittListController(TwittListModel modelList, TwittListView view)
  {
    this.view = view;
    this.model = modelList;
  }

  @Override
  public void notifyTwitAdded(Twit addedTwit)
  {
    this.model.addTwittComponent(addedTwit, new TwittComponent(addedTwit));
  }

  @Override
  public void notifyTwitDeleted(Twit deletedTwit)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void notifyTwitModified(Twit modifiedTwit)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void notifyUserAdded(User addedUser)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void notifyUserDeleted(User deletedUser)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void notifyUserModified(User modifiedUser)
  {
    // TODO Auto-generated method stub

  }

}