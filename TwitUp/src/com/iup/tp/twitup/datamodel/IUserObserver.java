package com.iup.tp.twitup.datamodel;

public interface IUserObserver
{
  void changeFollowActivation(boolean changeFollow, User user);
}
