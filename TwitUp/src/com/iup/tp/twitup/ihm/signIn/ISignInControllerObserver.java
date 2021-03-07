package com.iup.tp.twitup.ihm.signIn;

public interface ISignInControllerObserver
{
  public void notifyCancelButtonPressed();

  public void notifyValidateButtonPressed(String tag);
}
