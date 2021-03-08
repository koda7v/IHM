package com.iup.tp.twitup.ihm.hometwitt.twittlist;

import java.util.HashSet;
import java.util.Set;

import com.iup.tp.twitup.datamodel.IDatabaseObserver;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.hometwitt.IHomeTwittControllerObserver;
import com.iup.tp.twitup.ihm.hometwitt.twitt.TwittComponent;

public class TwittListController implements IDatabaseObserver, IHomeTwittControllerObserver
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

  @Override
  public void logOut()
  {
    // TODO Auto-generated method stub

  }

  public void twitsWithUser(String text, Set<Twit> twits)
  {
    Set<Twit> newTwits = this.model.getBase().getTwitsWithUserTag(text);
    for (Twit twit : newTwits)
    {
      twits.add(twit);
    }
  }

  public void twitsWithTag(String text, Set<Twit> twits)
  {
    Set<Twit> newTwits = this.model.getBase().getTwitsWithTag(text);
    for (Twit twit : newTwits)
    {
      twits.add(twit);
    }
  }

  @Override
  public void updateListWithSearch(String text)
  {
//    Set<Twit> twits = new HashSet<>();
//    if (text.contains("@"))
//    {
//      this.twitsWithUser(text, twits);
//    }
//    else if (text.contains("#"))
//    {
//      this.twitsWithTag(text, twits);
//    }
//    else
//    {
//      this.twitsWithTag(text, twits);
//      this.twitsWithUser(text, twits);
//    }

    Set<Twit> twits = this.model.getBase().getTwits();
    Set<Twit> newTwits = new HashSet<Twit>();
    for (Twit twit : twits)
    {
      if (twit.getText().contains(text))
      {
        newTwits.add(twit);
      }
    }
    this.model.setTwitts(newTwits);
    this.view.repaintContentPane();

  }

}
