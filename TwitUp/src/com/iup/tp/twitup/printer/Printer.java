package com.iup.tp.twitup.printer;

import com.iup.tp.twitup.datamodel.IDatabaseObserver;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;

public class Printer implements IDatabaseObserver
{

  @Override
  public void notifyTwitAdded(Twit addedTwit)
  {
//    System.out.println("Twit Added");

  }

  @Override
  public void notifyTwitDeleted(Twit deletedTwit)
  {
    System.out.println("Twit Deleted");

  }

  @Override
  public void notifyTwitModified(Twit modifiedTwit)
  {
    System.out.println("Twit Modified");

  }

  @Override
  public void notifyUserAdded(User addedUser)
  {
//    System.out.println("User Added");

  }

  @Override
  public void notifyUserDeleted(User deletedUser)
  {
    System.out.println("User Deledted");

  }

  @Override
  public void notifyUserModified(User modifiedUser)
  {
    System.out.println("User Modified");

  }

}
