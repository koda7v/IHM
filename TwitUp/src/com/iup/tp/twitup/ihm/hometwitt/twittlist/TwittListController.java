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
    Set<Twit> newTwits = this.model.getBase().getTwits();
    for (Twit twit : newTwits)
    {
      if (twit.getTwiter().getUserTag().equals(text))
      {
        twits.add(twit);
      }

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
  public void updateListTwitWithSearch(String text)
  {
    Set<Twit> newTwits = new HashSet<Twit>();

    if (text.contains("@"))
    {
      text = text.substring(1, text.length());
      this.twitsWithUser(text, newTwits);
    }
    else if (text.contains("#"))
    {
      text = text.substring(1, text.length());
      this.twitsWithTag(text, newTwits);
    }
    else
    {
      Set<Twit> twits = this.model.getBase().getTwits();
      for (Twit twit : twits)
      {
        if (twit.getText().contains(text))
        {
          newTwits.add(twit);
        }
      }
    }

    this.model.setTwitts(newTwits);
    this.view.repaintContentPane();

  }

  @Override
  public void updateListUserWithSearch(String text)
  {
    // TODO Auto-generated method stub

  }

}
