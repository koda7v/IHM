package com.iup.tp.twitup.ihm.hometwitt.twittlist;

import com.iup.tp.twitup.datamodel.IDatabaseObserver;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;

public class TwittControllerList implements IDatabaseObserver
{

  protected TwittViewList view;

  public TwittControllerList(TwittViewList view)
  {
    this.view = view;
  }

  @Override
  public void notifyTwitAdded(Twit addedTwit)
  {
    view.revalidate();
    view.repaint();

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
