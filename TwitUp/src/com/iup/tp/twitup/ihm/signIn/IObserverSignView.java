package com.iup.tp.twitup.ihm.signIn;

public interface IObserverSignView
{
  public void notifyValidateButtonPressed(String pseudo, String mdp);

  public void notifyCancelButtonPressed();

}
